package de.hoover.imu.mpu6050;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MPU6050Control {

	private static final int POLL_DELAY = 100;

	private MPU6050 mpu6050;
	private boolean polling = false;
	private MPU6050Offset offset;

	private MPU6050Calibration calibrater = new MPU6050Calibration();

	private Set<MPU6050Listener> listeners = new HashSet<MPU6050Listener>(1);

	public MPU6050Control(byte i2cAddress) {
		init(i2cAddress);
	}

	private void init(byte i2cAddress) {
		mpu6050 = new MPU6050(i2cAddress);
	}

	/**
	 * Reads the current sensor data.
	 * 
	 * @return
	 * @throws IOException
	 */
	public MPU6050Data getData() throws IOException {
		return mpu6050.readingSensors();
	}

	/**
	 * Starts reading the sensor data and notifies all registered
	 * <code>MPU6050Listener</code>s.
	 */
	public void startPolling() {
		polling = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (polling) {
					try {
						MPU6050Data data = mpu6050.readingSensors();
						if (!calibrater.isComplete()) {
							calibrater.addData(data);
							offset = calibrater.getOffset();
							System.out.print("Calibrating: " + offset.toString() + "\r");
						} else {
							data = calcCorrectedData(data);
							fireDataChanged(data);
						}
						Thread.sleep(POLL_DELAY);
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	/**
	 * Stops reading sensor data.
	 */
	public void stopPolling() {
		polling = false;
	}

	/**
	 * Registers the <code>MPU6050Listener</code>. Listers are not notified as
	 * long as <code>startPolling()</code> has been invoked.
	 * 
	 * @param listener
	 */
	public void addDataListener(MPU6050Listener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes the <code>MPU6050Listener</code>.
	 * 
	 * @param listener
	 */
	public void removeMPU6050DataListener(MPU6050Listener listener) {
		listeners.remove(listener);
	}

	private void fireDataChanged(MPU6050Data data) {
		for (MPU6050Listener listener : listeners) {
			listener.dataChanged(data.getGyroX(), data.getGyroY(), data.getGyroZ(), data.getAccX(), data.getAccY(),
					data.getAccZ());
		}
	}

	private MPU6050Data calcCorrectedData(MPU6050Data rawData) {

		int gyroX = rawData.getGyroX() - offset.getGyroX();
		int gyroY = rawData.getGyroY() - offset.getGyroY();
		int gyroZ = rawData.getGyroZ() - offset.getGyroZ();

		int accX = rawData.getAccX() - offset.getAccX();
		int accY = rawData.getAccY() - offset.getAccY();
		int accZ = rawData.getAccZ() - offset.getAccZ();

		MPU6050Data data = new MPU6050Data(gyroX, gyroY, gyroZ, accX, accY, accZ);
		return data;
	}

}

package de.hoover.imu.mpu6050;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

public class MPU6050 {

	private I2CBus bus;
	private I2CDevice mpu6050;
	private byte[] sensorData;

	private MPU6050Listener listener;

	private static boolean verbose = true;

	public void start() {
		if (verbose)
			System.out.println("Starting sensors reading:");
		try {
			// Get i2c bus
			bus = I2CFactory.getInstance(I2CBus.BUS_1);
			if (verbose)
				System.out.println("Connected to bus. OK.");

			// Get device itself
			mpu6050 = bus.getDevice(0x68);

			if (verbose)
				System.out.println("Connected to device. OK.");

			mpu6050.write(Mpu6050Registers.MPU6050_RA_PWR_MGMT_1,
					Mpu6050RegisterValues.MPU6050_RA_PWR_MGMT_1);
			mpu6050.write(Mpu6050Registers.MPU6050_RA_SMPLRT_DIV,
					Mpu6050RegisterValues.MPU6050_RA_SMPLRT_DIV);
			mpu6050.write(Mpu6050Registers.MPU6050_RA_CONFIG,
					Mpu6050RegisterValues.MPU6050_RA_CONFIG);
			mpu6050.write(Mpu6050Registers.MPU6050_RA_GYRO_CONFIG,
					Mpu6050RegisterValues.MPU6050_RA_GYRO_CONFIG_2000);
			mpu6050.write(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG,
					Mpu6050RegisterValues.MPU6050_RA_ACCEL_CONFIG_16G);
			mpu6050.write(Mpu6050Registers.MPU6050_RA_INT_ENABLE,
					Mpu6050RegisterValues.MPU6050_RA_INT_ENABLE);
			mpu6050.write(Mpu6050Registers.MPU6050_RA_PWR_MGMT_2,
					Mpu6050RegisterValues.MPU6050_RA_PWR_MGMT_2);

			if (verbose)
				System.out.println("Gyroscope OK.");

			startReading();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private void startReading() {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						readingSensors();
						Thread.sleep(100);
					}
				} catch (IOException | InterruptedException ioe) {
					System.err.println("Reading thread:");
					ioe.printStackTrace();
				}
			}
		};
		new Thread(task).start();
	}

	private void readingSensors() throws IOException {

		sensorData = new byte[14];

		mpu6050.read(Mpu6050Registers.MPU6050_RA_ACCEL_XOUT_H, sensorData, 0,
				14);

		int gyroX = gyro16(sensorData, 0);
		int gyroY = gyro16(sensorData, 2);
		int gyroZ = gyro16(sensorData, 4);

		int accX = gyro16(sensorData, 8);
		int accY = gyro16(sensorData, 10);
		int accZ = gyro16(sensorData, 12);

		listener.dataChanged(gyroX, gyroY, gyroZ, accX, accY, accZ);
	}

	private static int gyro16(byte[] list, int idx) {
		// High, low bytes
		int n = ((list[idx] & 0xFF) << 8) | (list[idx + 1] & 0xFF);
		// 2's complement signed
		return (n < 32768 ? n : n - 65536);
	}

	public MPU6050Listener getListener() {
		return listener;
	}

	public void setListener(MPU6050Listener listener) {
		this.listener = listener;
	}

}

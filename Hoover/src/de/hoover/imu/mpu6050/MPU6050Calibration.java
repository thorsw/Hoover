package de.hoover.imu.mpu6050;

public class MPU6050Calibration {

	private static final int CALIBRATION_INTERVAL = 50;

	private int gyroX;
	private int gyroY;
	private int gyroZ;

	private int accX;
	private int accY;
	private int accZ;

	private int calCount;
	private boolean complete;

	public void addData(MPU6050Data data) {

		gyroX += data.getGyroX();
		gyroY += data.getGyroY();
		gyroZ += data.getGyroZ();

		accX += data.getAccX();
		accY += data.getAccY();
		accZ += data.getAccZ();

		calCount++;

		if (calCount >= CALIBRATION_INTERVAL) {
			complete = true;
		}
	}

	public MPU6050Offset getOffset() {

		MPU6050Offset offset = new MPU6050Offset();

		offset.setGyroX(gyroX / calCount);
		offset.setGyroY(gyroY / calCount);
		offset.setGyroZ(gyroZ / calCount);

		offset.setAccX(accX / calCount);
		offset.setAccY(accY / calCount);
		offset.setAccZ(accZ / calCount);

		return offset;
	}

	public boolean isComplete() {
		return complete;
	}

}

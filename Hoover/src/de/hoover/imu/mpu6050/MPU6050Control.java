package de.hoover.imu.mpu6050;

public class MPU6050Control {

	private MPU6050 mpu6050;

	public MPU6050Control() {
		init();
	}

	private void init() {
		mpu6050 = new MPU6050();
	}

	public MPU6050Data getData() {
		return null;
	}

}

package de.hoover.imu.mpu6050;

public class MPU6050Offset {

	private int gyroX;
	private int gyroY;
	private int gyroZ;

	private int accX;
	private int accY;
	private int accZ;

	public int getGyroX() {
		return gyroX;
	}

	public void setGyroX(int gyroX) {
		this.gyroX = gyroX;
	}

	public int getGyroY() {
		return gyroY;
	}

	public void setGyroY(int gyroY) {
		this.gyroY = gyroY;
	}

	public int getGyroZ() {
		return gyroZ;
	}

	public void setGyroZ(int gyroZ) {
		this.gyroZ = gyroZ;
	}

	public int getAccX() {
		return accX;
	}

	public void setAccX(int accX) {
		this.accX = accX;
	}

	public int getAccY() {
		return accY;
	}

	public void setAccY(int accY) {
		this.accY = accY;
	}

	public int getAccZ() {
		return accZ;
	}

	public void setAccZ(int accZ) {
		this.accZ = accZ;
	}

	@Override
	public String toString() {
		return "MPU6050Offset [gyroX=" + gyroX + ", gyroY=" + gyroY + ", gyroZ=" + gyroZ + ", accX=" + accX + ", accY="
				+ accY + ", accZ=" + accZ + "]";
	}

}

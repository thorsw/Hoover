package mpu6050;

public class MPU6050Data {

	private int gyroX;
	private int gyroY;
	private int gyroZ;

	private int accX;
	private int accY;
	private int accZ;

	public MPU6050Data(int gyroX, int gyroY, int gyroZ, int accX, int accY, int accZ) {
		super();
		this.gyroX = gyroX;
		this.gyroY = gyroY;
		this.gyroZ = gyroZ;
		this.accX = accX;
		this.accY = accY;
		this.accZ = accZ;
	}

	public int getGyroX() {
		return gyroX;
	}

	public int getGyroY() {
		return gyroY;
	}

	public int getGyroZ() {
		return gyroZ;
	}

	public int getAccX() {
		return accX;
	}

	public int getAccY() {
		return accY;
	}

	public int getAccZ() {
		return accZ;
	}

	@Override
	public String toString() {
		return "MPU6050Data [gyroX=" + gyroX + ", gyroY=" + gyroY + ", gyroZ=" + gyroZ + ", accX=" + accX + ", accY="
				+ accY + ", accZ=" + accZ + "]";
	}

}

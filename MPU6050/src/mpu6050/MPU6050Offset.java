package mpu6050;

/**
 * Calibrating: MPU6050Offset [gyroX=30, gyroY=-44, gyroZ=1947, accX=-30,
 * accY=11, accZ=39]]]
 * 
 * @author tschwarz
 *
 */
public class MPU6050Offset {

	private int gyroX = 0;
	private int gyroY = 0;
	private int gyroZ = 0;

	private int accX = 0;
	private int accY = 0;
	private int accZ = 0;

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

package mpu6050;

public interface MPU6050Listener {

	void dataChanged(int gyroX, int gyroY, int gyroZ, int accX, int accY,
			int accZ);

}

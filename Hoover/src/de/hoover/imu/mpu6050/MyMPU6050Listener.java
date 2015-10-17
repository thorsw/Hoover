package de.hoover.imu.mpu6050;

public class MyMPU6050Listener implements MPU6050Listener {

	private int x, y, z;

	@Override
	public void dataChanged(int gyroX, int gyroY, int gyroZ, int accX, int accY, int accZ) {

		x += accX;
		y += accY;
		z += accZ;

		System.out.print("gyro: (X: ");
		System.out.printf("%4d", gyroX);
		System.out.print(", Y: ");
		System.out.printf("%4d", gyroY);
		System.out.print(", Z: ");
		System.out.printf("%4d", gyroZ);

		System.out.print("); acc (X: ");
		System.out.printf("%4d", accX);
		System.out.print(", Y: ");
		System.out.printf("%4d", accY);
		System.out.print(", Z: ");
		System.out.printf("%4d", accZ);

		System.out.print("); pos (X: ");
		System.out.printf("%4d", x);
		System.out.print(", Y: ");
		System.out.printf("%4d", y);
		System.out.print(", Z: ");
		System.out.printf("%4d", z);

		System.out.print(")\r");

	}

}

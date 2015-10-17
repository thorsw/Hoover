package mpu6050;

public class MyMPU6050Listener implements MPU6050Listener {

	private static final int PRECISION = 20;

	@Override
	public void dataChanged(int gyroX, int gyroY, int gyroZ, int accX, int accY, int accZ) {

		System.out.print("gyro: (X: ");
		System.out.printf("%4d", Math.floorDiv(gyroX, PRECISION));
		System.out.print(", Y: ");
		System.out.printf("%4d", Math.floorDiv(gyroY, PRECISION));
		System.out.print(", Z: ");
		System.out.printf("%4d", Math.floorDiv(gyroZ, PRECISION));

		System.out.print("); acc (X: ");
		System.out.printf("%4d", Math.floorDiv(accX, PRECISION));
		System.out.print(", Y: ");
		System.out.printf("%4d", Math.floorDiv(accY, PRECISION));
		System.out.print(", Z: ");
		System.out.printf("%4d", Math.floorDiv(accZ, PRECISION));

		System.out.print(")\r");

	}

}

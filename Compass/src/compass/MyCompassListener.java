package compass;

public class MyCompassListener implements LSM303Listener {

	private int lastAccX, lastAccY, lastAccZ;

	@Override
	public void dataDetected(int accX, int accY, int accZ, int magX, int magY,
			int magZ, float heading) {

		int accXChange = accX - lastAccX;
		int accYChange = accY - lastAccY;
		int accZChange = accZ - lastAccZ;

		System.out.print("X: ");
		System.out.printf("%08d", accXChange);
		System.out.print(", Y: ");
		System.out.printf("%08d", accYChange);
		System.out.print(", Z: ");
		System.out.printf("%08d", accZChange);
		System.out.print(", Heading: ");
		System.out.print(heading);		
		System.out.println();

		lastAccX = accX;
		lastAccY = accY;
		lastAccZ = accZ;
	}

}

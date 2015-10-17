package mpu6050;

public class Main {

	private final static byte MPU6050_I2C_ADDRESS = 0x68;

	public static void main(String[] args) {
		MPU6050Control control = new MPU6050Control(MPU6050_I2C_ADDRESS);
		MPU6050Listener listener = new MyMPU6050Listener();
		control.addDataListener(listener);
		control.startPolling();
	}
}
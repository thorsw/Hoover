package compass;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

public class GY511 {

	public final static int LSM303_ADDRESS_MAG = (0x3C >> 1); // 0011110x, 0x1E

	public final static int LSM303_REGISTER_MAG_MR_REG_M = 0x02;
	public final static int LSM303_REGISTER_MAG_CRB_REG_M = 0x01;

	// Gain settings for setMagGain()
	public final static int LSM303_MAGGAIN_1_3 = 0x20; // +/- 1.3
	public final static int LSM303_MAGGAIN_1_9 = 0x40; // +/- 1.9
	public final static int LSM303_MAGGAIN_2_5 = 0x60; // +/- 2.5
	public final static int LSM303_MAGGAIN_4_0 = 0x80; // +/- 4.0
	public final static int LSM303_MAGGAIN_4_7 = 0xA0; // +/- 4.7
	public final static int LSM303_MAGGAIN_5_6 = 0xC0; // +/- 5.6
	public final static int LSM303_MAGGAIN_8_1 = 0xE0; // +/- 8.1

	private I2CBus bus;
	private I2CDevice magnetometer;
	private byte[] magData;

	public GY511() {
		init();
	}

	private void init() {
		try {
			bus = I2CFactory.getInstance(I2CBus.BUS_1);
			magnetometer = bus.getDevice(LSM303_ADDRESS_MAG);
			magnetometer.write(LSM303_REGISTER_MAG_MR_REG_M, (byte) 0x00);
			int gain = LSM303_MAGGAIN_1_3;
			magnetometer.write(LSM303_REGISTER_MAG_CRB_REG_M, (byte) gain);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

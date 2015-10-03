package de.hoover;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;

import de.hoover.hardware.motor.Motor;
import de.hoover.hardware.motor.MotorFactory;
import de.hoover.hardware.motor.PWMMotor;

public class HooverFactory {

	private final static Pin LEFT_FORWARD = RaspiPin.GPIO_00;
	private final static Pin LEFT_BACKWARD = RaspiPin.GPIO_01;
	private final static Pin RIGHT_FORWARD = RaspiPin.GPIO_02;
	private final static Pin RIGHT_BACKWARD = RaspiPin.GPIO_03;

	public static Hoover createHoover() {

		Motor engineLeft = MotorFactory.createMotor(LEFT_FORWARD,
				LEFT_BACKWARD, "Left Engine");
		Motor engineRight = MotorFactory.createMotor(RIGHT_FORWARD,
				RIGHT_BACKWARD, "Right Engine");

		Hoover hoover = new Hoover();
		hoover.setEngineLeft(engineLeft);
		hoover.setEngineRight(engineRight);

		// LSM303 compass = new LSM303();
		// compass.setDataListener(new MyLSM303Listener());
		// compass.startReading();

		return hoover;
	}

	public static PWMHoover createPWMHoover() {
		
		Gpio.wiringPiSetup();
		
		PWMMotor leftMotor = MotorFactory.createPWMMotor(0, 1);
		PWMMotor rightMotor = MotorFactory.createPWMMotor(2, 3);

		PWMHoover hoover = new PWMHoover();
		hoover.setEngineLeft(leftMotor);
		hoover.setEngineRight(rightMotor);

		return hoover;
	}

}

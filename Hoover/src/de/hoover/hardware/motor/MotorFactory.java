package de.hoover.hardware.motor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.wiringpi.SoftPwm;

public class MotorFactory {

	public static Motor createMotor(Pin forwardPin, Pin backwardPin, String name) {

		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput outputPinForward = gpio
				.provisionDigitalOutputPin(forwardPin, name, PinState.LOW);
		outputPinForward.setShutdownOptions(true, PinState.LOW);
		final GpioPinDigitalOutput outputPinBackward = gpio
				.provisionDigitalOutputPin(backwardPin, name, PinState.LOW);
		outputPinBackward.setShutdownOptions(true, PinState.LOW);

		Motor motor = new Motor();
		motor.setForward(outputPinForward);
		motor.setBackward(outputPinBackward);

		return motor;
	}

	public static PWMMotor createPWMMotor(int forwardPin, int backwardPin) {

		SoftPwm.softPwmCreate(forwardPin, 0, 100);
		SoftPwm.softPwmCreate(backwardPin, 0, 100);
		PWMMotor motor = new PWMMotor(forwardPin, backwardPin);
		
		return motor;
	}
}

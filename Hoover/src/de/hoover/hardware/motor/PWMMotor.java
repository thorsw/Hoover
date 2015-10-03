package de.hoover.hardware.motor;

import com.pi4j.wiringpi.SoftPwm;

public class PWMMotor {

	private static final int PWM_STOP = 0;

	private int forwardPin;
	private int backwardPin;

	public PWMMotor(int forwardPin, int backwardPin) {
		this.forwardPin = forwardPin;
		this.backwardPin = backwardPin;
	}

	/**
	 * Value needs to be between 0 and 100. <br>
	 * 0 = stop<br>
	 * 100 = full
	 * 
	 * @param value
	 * @throws IllegalArgumentException
	 *             - if value < 0 or value > 100.
	 */
	public void forward(int value) throws IllegalArgumentException {
		if (!isValueInRange(value)) {
			throw new IllegalArgumentException("Value: " + value
					+ " is not in valid range.");
		}

		SoftPwm.softPwmWrite(backwardPin, PWM_STOP);
		SoftPwm.softPwmWrite(forwardPin, value);
	}

	/**
	 * Value needs to be between 0 and 100. <br>
	 * 0 = stop<br>
	 * 100 = full
	 * 
	 * @param value
	 * @throws IllegalArgumentException
	 *             - if value < 0 or value > 100.
	 */
	public void backward(int value) throws IllegalArgumentException {
		if (!isValueInRange(value)) {
			throw new IllegalArgumentException("Value: " + value
					+ " is not in valid range.");
		}

		SoftPwm.softPwmWrite(forwardPin, PWM_STOP);
		SoftPwm.softPwmWrite(backwardPin, value);
	}

	public void stop() {
		SoftPwm.softPwmWrite(forwardPin, 0);
		SoftPwm.softPwmWrite(backwardPin, 0);
	}

	private boolean isValueInRange(int value) {
		if (value >= 0 && value <= 100) {
			return true;
		} else {
			return false;
		}
	}

}

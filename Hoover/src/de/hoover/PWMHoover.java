package de.hoover;

import de.hoover.hardware.motor.PWMMotor;

public class PWMHoover {

	private PWMMotor engineLeft;
	private PWMMotor engineRight;

	public void left(int value) {
		try {
			if (value >= 0) {
				engineLeft.forward(value);
			} else {
				value *= -1;
				engineLeft.backward(value);
			}
		} catch (IllegalArgumentException e) {
			engineLeft.stop();
			e.printStackTrace();
		}
	}

	public void right(int value) {
		try {
			if (value >= 0) {
				engineRight.forward(value);
			} else {
				value *= -1;
				engineRight.backward(value);
			}
		} catch (IllegalArgumentException e) {
			engineRight.stop();
			e.printStackTrace();
		}
	}

	public void stop() {
		engineLeft.stop();
		engineRight.stop();
	}

	public void setEngineLeft(PWMMotor engineLeft) {
		this.engineLeft = engineLeft;
	}

	public void setEngineRight(PWMMotor engineRight) {
		this.engineRight = engineRight;
	}

}

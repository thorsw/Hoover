package de.hoover;

import de.hoover.hardware.motor.Motor;

public class Hoover {

	private Motor engineLeft;
	private Motor engineRight;

	public void forward() {
		engineLeft.forward();
		engineRight.forward();
	}

	public void stop() {
		engineLeft.stop();
		engineRight.stop();
	}

	public void backward() {
		engineLeft.backward();
		engineRight.backward();
	}

	public void leftForward() {
		engineLeft.stop();
		engineRight.forward();
	}

	public void rightForward() {
		engineLeft.forward();
		engineRight.stop();
	}

	public void leftBackward() {
		engineLeft.stop();
		engineRight.backward();
	}

	public void rightBackward() {
		engineLeft.backward();
		engineRight.stop();
	}

	public void rotateLeft() {
		engineLeft.backward();
		engineRight.forward();
	}

	public void rotateRight() {
		engineLeft.forward();
		engineRight.backward();
	}

	protected void setEngineLeft(Motor engineLeft) {
		this.engineLeft = engineLeft;
	}

	protected void setEngineRight(Motor engineRight) {
		this.engineRight = engineRight;
	}

	public void shutdown() {

	}

}

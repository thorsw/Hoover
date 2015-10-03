package de.hoover.hardware.motor;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

public class Motor {

	private GpioPinDigitalOutput forward;
	private GpioPinDigitalOutput backward;

	public void forward() {
		backward.setState(PinState.LOW);
		forward.setState(PinState.HIGH);
	}

	public void stop() {
		backward.setState(PinState.LOW);
		forward.setState(PinState.LOW);
	}

	public void backward() {
		forward.setState(PinState.LOW);
		backward.setState(PinState.HIGH);
	}

	protected GpioPinDigitalOutput getForward() {
		return forward;
	}

	protected void setForward(GpioPinDigitalOutput forward) {
		this.forward = forward;
	}

	protected GpioPinDigitalOutput getBackward() {
		return backward;
	}

	protected void setBackward(GpioPinDigitalOutput backward) {
		this.backward = backward;
	}

}

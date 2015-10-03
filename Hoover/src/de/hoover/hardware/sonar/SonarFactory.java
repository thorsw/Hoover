package de.hoover.hardware.sonar;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;

public class SonarFactory {

	public static Sonar createSonar(Pin triggerPin, Pin echoPin, String name) {

		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalInput echoInputPin = gpio
				.provisionDigitalInputPin(echoPin);
		GpioPinDigitalOutput triggerOutputPin = gpio
				.provisionDigitalOutputPin(triggerPin);
		triggerOutputPin.low();

		Sonar sonar = new Sonar(echoInputPin, triggerOutputPin);
		return sonar;
	}

}

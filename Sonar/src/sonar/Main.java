package sonar;

import java.util.concurrent.TimeoutException;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class Main {

	private final static Pin TRIGGER_PIN = RaspiPin.GPIO_00;
	private final static Pin ECHO_PIN = RaspiPin.GPIO_01;

	public static void main(String[] args) {
		Sonar sonar = new Sonar(ECHO_PIN, TRIGGER_PIN);
		
		while(true) {
			 try {
				float distance = sonar.measureDistance();
				System.out.println(distance);
				Thread.sleep(500);
			} catch (TimeoutException e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

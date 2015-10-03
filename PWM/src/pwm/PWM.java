package pwm;

import com.pi4j.wiringpi.SoftPwm;

public class PWM {

	public static void main(String[] args) throws InterruptedException {

		// initialize wiringPi library
		com.pi4j.wiringpi.Gpio.wiringPiSetup();

		// create soft-pwm pins (min=0 ; max=100)
		SoftPwm.softPwmCreate(1, 0, 100);

		// continuous loop
		while (true) {
			// fade LED to fully ON
			for (int i = 0; i <= 100; i++) {
				SoftPwm.softPwmWrite(1, i);
				Thread.sleep(100);
			}

			// fade LED to fully OFF
			for (int i = 100; i >= 0; i--) {
				SoftPwm.softPwmWrite(1, i);
				Thread.sleep(100);
			}
		}
	}
}

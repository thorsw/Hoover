package de.hoover.control;

import de.hoover.Hoover;
import de.hoover.HooverFactory;

public class HooverTestController implements HooverController {

	private Hoover hoover;

	public HooverTestController() {
		hoover = HooverFactory.createHoover();
	}

	public void start() {
		try {
			System.out.println("Forward");
			hoover.forward();
			Thread.sleep(5000);
			System.out.println("Backward");
			hoover.backward();
			Thread.sleep(5000);
			System.out.println("Stop");
			hoover.stop();
			Thread.sleep(5000);
			System.out.println("Left");
			hoover.leftForward();
			Thread.sleep(5000);
			System.out.println("Right");
			hoover.rightForward();
			Thread.sleep(5000);
			System.out.println("Left on Spot");
			hoover.rotateLeft();
			Thread.sleep(5000);
			System.out.println("Right on Spot");
			hoover.rotateRight();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		hoover.stop();
	}

}

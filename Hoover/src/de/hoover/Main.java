package de.hoover;

import de.hoover.control.HooverWebControl;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		HooverWebControl controller = new HooverWebControl();
		controller.start();
	}

}

package de.hoover.hardware.sonar;

public interface SonarListener {

	/**
	 * Provides the new distance in millimeters.
	 * 
	 * @return
	 */
	public void distanceChanged(int distance);

}

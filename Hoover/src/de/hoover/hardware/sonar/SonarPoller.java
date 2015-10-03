package de.hoover.hardware.sonar;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class SonarPoller implements Runnable {

	private final static int POLL_INTERVAL = 500;

	private Sonar sonar;
	private boolean shutdown = false;
	private Set<SonarListener> sonarListeners = new HashSet<SonarListener>(1);

	public SonarPoller(Sonar sonar) {
		this.sonar = sonar;
	}

	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (!shutdown) {
			try {
				int distance = sonar.measureDistance();
				fireDistanceChanged(distance);
				Thread.sleep(POLL_INTERVAL);
			} catch (TimeoutException e) {
				fireDistanceChanged(-1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addSonarListener(SonarListener listener) {
		sonarListeners.add(listener);
	}

	public void removeSonarListener(SonarListener listener) {
		sonarListeners.remove(listener);
	}

	private void fireDistanceChanged(int distance) {
		for (SonarListener listener : sonarListeners) {
			listener.distanceChanged(distance);
		}
	}

	public void shutdown() {
		shutdown = true;
	}

}

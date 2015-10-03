package compass;

import java.util.EventListener;

public interface LSM303Listener extends EventListener {
	public void dataDetected(int accX, int accY, int accZ, int magX, int magY,
			int magZ, float heading);
}
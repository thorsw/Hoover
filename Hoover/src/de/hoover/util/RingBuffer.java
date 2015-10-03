package de.hoover.util;

/**
 * Generic ring buffer. If the buffer is full it overwrites the oldest item.
 * 
 * @author tschwarz
 *
 * @param <T>
 */
public class RingBuffer<T> {

	private Object[] buffer;
	private int head;

	public RingBuffer(int capacity) {
		buffer = new Object[capacity];
		head = -1;
	}

	/**
	 * Adds one item to the buffer. If the buffers capacity is reached it
	 * overwrites the oldest existing item in the buffer.
	 * 
	 * @param item
	 */
	public void put(T item) {
		if (head < buffer.length - 1) {
			head++;
		} else {
			head = 0;
		}
		buffer[head] = item;

	}

	/**
	 * Returns the buffer's capacity (buffer size).
	 * 
	 * @return
	 */
	public int capacity() {
		return buffer.length;
	}

	/**
	 * Returns the item from the given position.<br>
	 * Position = 0 returns the last added (newest) item from the buffer.<br>
	 * Position = buffer size returns the oldest item from the buffer.
	 * 
	 * @param position
	 * @return
	 * @throws IllegalAccessException
	 *             - if position is larger buffer size.
	 */
	@SuppressWarnings("unchecked")
	public T get(int position) throws IllegalArgumentException {
		if (position > capacity() - 1) {
			throw new IllegalArgumentException(
					"Position is larger than buffer size");
		}

		int bufferPos = 0;
		if (head - position >= 0) {
			bufferPos = head - position;
		} else {
			bufferPos = buffer.length + head - position;
		}

		return (T) buffer[bufferPos];
	}

	/**
	 * Returns item on top of the buffer (the item that has been added last).
	 * 
	 * @return
	 */
	public T head() {
		return get(0);
	}
}

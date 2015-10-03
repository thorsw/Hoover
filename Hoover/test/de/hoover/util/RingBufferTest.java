package de.hoover.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RingBufferTest {

	@Test
	public void testCapacity() {
		RingBuffer<Integer> buffer = new RingBuffer<Integer>(10);
		assertEquals(10, buffer.capacity());
	}

	@Test
	public void testContent() {
		RingBuffer<Integer> buffer = new RingBuffer<Integer>(10);
		for (int i = 0; i < 45; i++) {
			buffer.put(i);
		}
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Position " + i + ":" + buffer.get(i));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testEmptyMin() {
		RingBuffer<Integer> buffer = new RingBuffer<Integer>(10);
		assertEquals(null, buffer.get(0));
	}

	@Test
	public void testEmptyMax() {
		RingBuffer<Integer> buffer = new RingBuffer<Integer>(10);
		assertEquals(null, buffer.get(9));
	}

}

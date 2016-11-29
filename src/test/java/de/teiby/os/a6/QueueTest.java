package de.teiby.os.a6;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	
	@Test
	public void testQueue() {
		Queue queue = new Queue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
		
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		assertEquals(6, queue.dequeue());
		assertEquals(7, queue.dequeue());
		assertEquals(9, queue.dequeue());
		
		try {
			queue.dequeue();
			fail();
		} catch (Exception e) {
		}
	}

}

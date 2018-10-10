package com.rzinaliev.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CircularQueueTest {

  @Test
  public void testMyCircularQueue() {
    MyCircularQueue queue = new MyCircularQueue(4);

    assertTrue(queue.enQueue(3));
    assertTrue(queue.enQueue(9));
    assertTrue(queue.enQueue(5));
    assertTrue(queue.enQueue(1));

    assertFalse(queue.enQueue(1));

    assertTrue(queue.deQueue());
    assertTrue(queue.deQueue());

    assertFalse(queue.isEmpty());
    assertFalse(queue.isEmpty());

    assertEquals(1, queue.Rear());
    assertEquals(1, queue.Rear());

    assertEquals(5, queue.Front());
    assertTrue(queue.deQueue());

    assertEquals(1, queue.Front());
    assertEquals(1, queue.Rear());

    assertTrue(queue.deQueue());
    assertFalse(queue.deQueue());
  }

  @Test
  public void testLcCircularQueue() {
    LcCircularQueue queue = new LcCircularQueue(4);

    assertTrue(queue.enQueue(3));
    assertTrue(queue.enQueue(9));
    assertTrue(queue.enQueue(5));
    assertTrue(queue.enQueue(1));

    assertFalse(queue.enQueue(1));

    assertTrue(queue.deQueue());
    assertTrue(queue.deQueue());

    assertFalse(queue.isEmpty());
    assertFalse(queue.isEmpty());

    assertEquals(1, queue.Rear());
    assertEquals(1, queue.Rear());

    assertEquals(5, queue.Front());
    assertTrue(queue.deQueue());

    assertEquals(1, queue.Front());
    assertEquals(1, queue.Rear());

    assertTrue(queue.deQueue());
    assertFalse(queue.deQueue());
  }

}
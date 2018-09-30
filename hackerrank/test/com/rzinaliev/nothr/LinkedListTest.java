package com.rzinaliev.nothr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {

  @Test
  public void testCopyItems() {
    LinkedList<String> list = new LinkedList<>();

    list.add("one");
    list.add("two");
    list.add("three");
    list.add("four");

    String[] items = list.copyItems();

    assertEquals(4, items.length);
    assertEquals("one", items[0]);
    assertEquals("two", items[1]);
    assertEquals("three", items[2]);
    assertEquals("four", items[3]);
  }

  @Test
  public void testGetByIndex() {
    LinkedList<String> list = new LinkedList<>();

    list.add("one");
    list.add("two");
    list.add("three");
    list.add("four");

    assertEquals("one", list.get(0));
    assertEquals("two", list.get(1));
    assertEquals("three", list.get(2));
    assertEquals("four", list.get(3));
  }

  @Test(timeout = 100L)
  public void testCreateLoop_GetLastItemFails() {

    LinkedList<String> list = new LinkedList<>();

    list.add("one");
    list.add("two");
    list.add("three");
    list.add("four");

    assertEquals("four", list.get(3));

    list.createLoop(2, 1);

    assertNotEquals("four", list.get(3));
  }

  @Test
  public void testHasLoop_OnFullLoopedList_ReturnsTrue() {
    LinkedList<String> list = new LinkedList<>();

    list.add("one");
    list.add("two");
    list.add("three");
    list.add("four");

    assertFalse(list.hasLoop());

    list.createLoop(3, 0);

    assertTrue(list.hasLoop());
  }

  @Test
  public void testHasLoop_OnShortLoopedList_ReturnsTrue() {
    LinkedList<String> list = new LinkedList<>();

    list.add("one");
    list.add("two");
    list.add("three");
    list.add("four");

    assertFalse(list.hasLoop());

    list.createLoop(2, 1);

    assertTrue(list.hasLoop());
  }
}
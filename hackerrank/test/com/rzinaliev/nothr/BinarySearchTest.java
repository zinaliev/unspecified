package com.rzinaliev.nothr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

  @Test
  public void testEmptyArray() {
    assertEquals(-1, new BinarySearch(new int[]{}).indexOf(5));
  }

  @Test
  public void testSingleItemArrayContainingSearchedItem() {
    assertEquals(0, new BinarySearch(new int[]{5}).indexOf(5));
  }

  @Test
  public void testSingleItemArrayNotContainingSearchedItem() {
    assertEquals(-1, new BinarySearch(new int[]{1}).indexOf(5));
  }

  @Test
  public void testEvenItemsArrayNotContainingSearchedItem() {
    assertEquals(-1, new BinarySearch(new int[]{1, 2, 3, 4}).indexOf(5));
  }

  @Test
  public void testEvenItemsArrayContainingSearchedItem() {
    assertEquals(3, new BinarySearch(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}).indexOf(5));
  }

  @Test
  public void testOddItemsArrayNotContainingSearchedItem() {
    assertEquals(-1, new BinarySearch(new int[]{1, 2, 3}).indexOf(5));
  }

  @Test
  public void testOddItemsArrayContainingSearchedItem() {
    assertEquals(2, new BinarySearch(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11}).indexOf(5));
  }


}
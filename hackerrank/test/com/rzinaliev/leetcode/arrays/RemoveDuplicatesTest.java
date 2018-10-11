package com.rzinaliev.leetcode.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {

  RemoveDuplicates solution = new RemoveDuplicates();
  int[] input;

  @Test
  public void testRemoveDuplicates_11() {
    input = new int[] {1, 1};

    assertEquals(1, solution.removeDuplicates(input));
    assertEquals(1, input[0]);
  }

  @Test
  public void testRemoveDuplicates_112233() {
    input = new int[] {1, 1, 2, 2, 3, 3};

    assertEquals(3, solution.removeDuplicates(input));
    assertEquals(1, input[0]);
    assertEquals(2, input[1]);
    assertEquals(3, input[2]);
  }

  @Test
  public void testRemoveDuplicates_11222234566667() {
    input = new int[] {1, 1, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 7};

    assertEquals(7, solution.removeDuplicates(input));
    assertEquals(1, input[0]);
    assertEquals(2, input[1]);
    assertEquals(3, input[2]);
    assertEquals(4, input[3]);
    assertEquals(5, input[4]);
    assertEquals(6, input[5]);
    assertEquals(7, input[6]);
  }

}
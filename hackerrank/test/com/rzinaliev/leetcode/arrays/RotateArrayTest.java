package com.rzinaliev.leetcode.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RotateArrayTest {

  int[] input;
  RotateArray solution = new RotateArray();

  @Test
  public void testRotate_123_0() {
    input = new int[]{1, 2, 3};

    solution.rotate(input, 0);

    assertEquals(1, input[0]);
    assertEquals(2, input[1]);
    assertEquals(3, input[2]);
  }

  @Test
  public void testRotate_12345_1() {
    input = new int[]{1, 2, 3, 4, 5};

    solution.rotate(input, 1);

    assertEquals(5, input[0]);
    assertEquals(1, input[1]);
    assertEquals(2, input[2]);
    assertEquals(3, input[3]);
    assertEquals(4, input[4]);
  }

  @Test
  public void testRotate_123456_2() {
    input = new int[]{1, 2, 3, 4, 5, 6};

    solution.rotate(input, 2);

    assertEquals(5, input[0]);
    assertEquals(6, input[1]);
    assertEquals(1, input[2]);
    assertEquals(2, input[3]);
    assertEquals(3, input[4]);
    assertEquals(4, input[5]);
  }

  @Test
  public void testRotate_123_2() {
    input = new int[]{1, 2, 3};

    solution.rotate(input, 2);

    assertEquals(2, input[0]);
    assertEquals(3, input[1]);
    assertEquals(1, input[2]);
  }

  @Test
  public void testRotate_123_3() {
    input = new int[]{1, 2, 3};

    solution.rotate(input, 3);

    assertEquals(1, input[0]);
    assertEquals(2, input[1]);
    assertEquals(3, input[2]);
  }

  @Test
  public void testReverse() {
    int[] original = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] expected = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

    solution.reverse(original, 0, original.length - 1);

    assertArrayEquals(expected, original);
  }
}
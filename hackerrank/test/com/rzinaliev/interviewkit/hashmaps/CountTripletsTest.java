package com.rzinaliev.interviewkit.hashmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CountTripletsTest {

  private final CountTriplets solution = new CountTriplets();

  @Test
  public void test() {
    List<Long> arr = new ArrayList<>();
    arr.add(1L);
    arr.add(5L);
    arr.add(5L);
    arr.add(25L);
    arr.add(125L);

    long r = 5;

    assertEquals(4, solution.getTripletsCount(arr, r));
  }
}
package com.rzinaliev.interviewkit.hashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

  public long getTripletsCount(List<Long> arr, long r) {

    Map<Long, Long> right = new HashMap<>();
    Map<Long, Long> left = new HashMap<>();

    for (Long i : arr) {
      right.put(i, right.get(i) == null ? 1L : right.get(i) + 1);
    }

    long triplets = 0;

    for (Long i : arr) {
      right.put(i, right.get(i) - 1);

      if (i % r == 0) {
        Long countLeft = left.get(i / r);
        Long countRight = right.get(i * r);

        if (countLeft != null && countRight != null) {
          triplets += countLeft * countRight;
        }
      }

      left.put(i, left.get(i) == null ? 1L : left.get(i) + 1);
    }

    return triplets;
  }
}

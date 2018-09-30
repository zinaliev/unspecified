package com.rzinaliev.nothr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class HashMapTest {


  /**
   * Copied and pasted from actual {@link java.util.HashMap} implementation
   */
  static int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

  @Test
  public void testHashMapHashMethod() {
    List<Object> objects = new ArrayList<>();
    for (int i = 0; i < 128; i++) {
      objects.add(new Object());
    }

    SortedMap<Integer, Integer> freqs = new TreeMap<>();

    for (Object object : objects) {
      int h = hash(object);
      int index = objects.size() - 1 & h;
      System.out.println("map's hash: " + h + ", map's index: " + index);

      Integer c;
      freqs.put(index, (c = freqs.get(index)) == null ? 1 : c + 1);
    }

    freqs.forEach((index, freq) -> System.out.println(index + " -> " + freq));

  }
}

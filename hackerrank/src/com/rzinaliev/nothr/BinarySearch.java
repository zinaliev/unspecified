package com.rzinaliev.nothr;

public class BinarySearch {

  private final int[] array;

  public BinarySearch(int[] array) {
    checkSortedAndDistinct(array);

    this.array = array;
  }

  private void checkSortedAndDistinct(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] >= array[i])
        throw new IllegalArgumentException("input array must be sorted and distinct");
    }
  }

  public int indexOf(int item) {

    int l = 0;
    int r = array.length - 1;
    int i;

    while (l <= r) {

      i = (l + r) / 2;

      if (array[i] == item)
        return i;
      else if (array[i] > item) {
        // go left
        r = i - 1;
      } else {
        // go right
        l = i + 1;
      }
    }

    return -1;
  }
}

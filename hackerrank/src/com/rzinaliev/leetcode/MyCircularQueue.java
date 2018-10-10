package com.rzinaliev.leetcode;

public class MyCircularQueue {

  private final int[] store;

  private int head = -1;
  private int tail = -1;

  /**
   * Initialize your data structure here. Set the size of the queue to be k.
   */
  public MyCircularQueue(int k) {
    this.store = new int[k];
  }

  /**
   * Insert an element into the circular queue. Return true if the operation is successful.
   */
  public boolean enQueue(int value) {
    if (isEmpty()) {
      head = nextFor(head);
      tail = nextFor(tail);
      store[head] = value;
      return true;
    }

    if (isFull())
      return false;

    tail = nextFor(tail);
    store[tail] = value;

    return true;
  }

  /**
   * Delete an element from the circular queue. Return true if the operation is successful.
   */
  public boolean deQueue() {
    if (isEmpty())
      return false;

    head = nextFor(head);
    if (head == nextFor(tail)) {
      head = -1;
      tail = -1;
    }

    return true;

  }

  /**
   * Get the front item from the queue.
   */
  public int Front() {
    return head != -1 ? store[head] : head;
  }

  /**
   * Get the last item from the queue.
   */
  public int Rear() {
    return tail != -1 ? store[tail] : tail;
  }

  /**
   * Checks whether the circular queue is empty or not.
   */
  public boolean isEmpty() {
    return tail == -1 && head == -1;
  }

  /**
   * Checks whether the circular queue is full or not.
   */
  public boolean isFull() {
    return head == nextFor(tail);
  }

  private int nextFor(int index) {
    if (index < 0)
      return 0;
    else if (index < store.length - 1) {
      return index + 1;
    } else {
      return 0;
    }
  }
}

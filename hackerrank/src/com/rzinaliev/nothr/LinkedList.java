package com.rzinaliev.nothr;

import java.lang.reflect.Array;

public class LinkedList<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  public void add(T item) {
    size++;

    if (head == null) {
      head = new Node<>(item);
      tail = head;
      return;
    }

    tail.next = new Node<>(item);
    tail = tail.next;
  }

  public T get(int index) {
    Node<T> node = getNode(index);

    if (node == null)
      return null;

    return node.item;
  }

  private Node<T> getNode(int index) {
    if (index >= size)
      return null;

    Node<T> cur = head;
    while (index-- > 0) {
      cur = cur.next;
    }

    return cur;
  }

  public void createLoop(int from, int to) {
    Node<T> nodeFrom = getNode(from);
    Node<T> nodeTo = getNode(to);

    if (nodeFrom == null || nodeTo == null)
      throw new IllegalArgumentException("can not get Node 'for' from and/or 'to' indexes, probably list size is exceeded " + size);

    nodeFrom.next = nodeTo;
  }

  @SuppressWarnings("unchecked")
  public T[] copyItems() {

    if (head == null)
      return (T[]) new Object[]{};

    T[] result = (T[]) Array.newInstance(head.item.getClass(), size);
    Node<T> cur = head;
    for (int i = 0; i < size; i++) {
      result[i] = cur.item;
      cur = cur.next;
    }

    return result;
  }

  public boolean hasLoop() {
    if (size < 2)
      return false;

    Node<T> slow = head;
    Node<T> fast = head.next;

    while (slow.next != null) {

      if (fast == slow)
        return true;

      if(fast == null || fast.next == null)
        return false;

      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }

  private static class Node<T> {

    private Node<T> next;
    private T item;

    public Node(T item) {
      this.item = item;
    }
  }

}

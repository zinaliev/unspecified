package com.rzinaliev.nothr;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConcurrentFibonacciIteratorTest {

  private ConcurrentFibonacciIterator fibonator = new ConcurrentFibonacciIterator();

  @Test
  public void testNext_InConcurrentEnvironment_ProducesSameSequenceAsInSingleThreaded() {
    int count = 1500;

    List<BigInteger> fibos = new CopyOnWriteArrayList<>();
    CompletableFuture[] futures = new CompletableFuture[count - 2];

    ExecutorService executor = Executors.newFixedThreadPool(9);

    assertEquals(BigInteger.ZERO, fibonator.next());
    assertEquals(BigInteger.ONE, fibonator.next());

    for (int i = 0; i < futures.length; i++) {

      futures[i] = CompletableFuture.supplyAsync(
          () -> fibos.add(fibonator.next()),
          executor
      );
    }

    CompletableFuture.allOf(futures).join();

    for (int i = 2; i < count; i++) {
      BigInteger next = calcFibo(i);
      assertTrue(
          "item #" + i + " = " + next,
          fibos.contains(next)
      );
    }
  }

  @Test
  public void testNext_SingleThread_First1500Items() {
    for (int i = 0; i < 1500; i++) {
      assertEquals("item #" + i, calcFibo(i), fibonator.next());
    }
  }

  private BigInteger calcFibo(int index) {
    BigInteger[] cache = new BigInteger[]{BigInteger.ZERO, BigInteger.ONE};

    for (int i = 2; i <= index; i++) {
      cache[i % 2] = cache[0].add(cache[1]);
    }

    return cache[index % 2];
  }
}
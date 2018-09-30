package com.rzinaliev.nothr;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConcurrentFibonacciIterator {

  private final AtomicBoolean processing = new AtomicBoolean(false);

  private BigInteger a = BigInteger.ZERO.subtract(BigInteger.ONE);
  private BigInteger b = BigInteger.ONE;

  public BigInteger next() {
    BigInteger result;

    while (!processing.compareAndSet(false, true)) {
      System.out.println("Thread " + Thread.currentThread().getName() + " is on spin-wait cycle" );
    }

    b = b.add(a);
    a = b.subtract(a);

    result = b;

    if (!processing.compareAndSet(true, false))
      throw new IllegalStateException("Wrong atomic boolean 'processing' state at the end of execution - " + processing.get());

    return result;
  }

}

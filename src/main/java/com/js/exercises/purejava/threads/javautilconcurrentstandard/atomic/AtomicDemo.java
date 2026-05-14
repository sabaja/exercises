package com.js.exercises.purejava.threads.javautilconcurrentstandard.atomic;

import org.springframework.util.StopWatch;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    static void main() throws InterruptedException {

        CounterWithAtomic counter = new CounterWithAtomic();

        Runnable task = () -> {
            for (int i = 0; i < 100_000_000; ++i) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        stopWatch.stop();
        System.out.println("Valore finale = " + counter.increment() + " duration: " + stopWatch.getTotalTimeNanos() / Math.pow(10, 9) + " seconds");
    }
}

class CounterWithAtomic {

    private final AtomicInteger value = new AtomicInteger(0);

    public int increment() {
        return value.getAndIncrement();
    }
}

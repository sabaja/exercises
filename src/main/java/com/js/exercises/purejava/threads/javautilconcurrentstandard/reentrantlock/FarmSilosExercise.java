package com.js.exercises.purejava.threads.javautilconcurrentstandard.reentrantlock;

import org.jspecify.annotations.NonNull;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FarmSilosExercise {

    static void main() {
        SilosService silosService = new SilosService(new BigDecimal("10.0"));

        final Runnable task = createOperation(silosService);

        for (int i = 1; i <= 10; i++) {
            new Thread(task, "farmer_" + i).start();
        }
    }

    private static @NonNull Runnable createOperation(SilosService silosService) {
        return () -> {
            try {
                final String name = Thread.currentThread().getName();
                silosService.tryGet(name, new BigDecimal("2.2"));
            } catch (SilosException e) {
                IO.println(e.getMessage());
            }
        };
    }
}

class SilosService {
    private final Lock lock = new ReentrantLock();
    private BigDecimal capacity;
    private boolean closed;

    public SilosService(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public void tryGet(String userName, BigDecimal quantityToExtract) throws SilosException {
        try {
            if (!lock.tryLock(400, TimeUnit.MILLISECONDS)) {
                IO.println(userName + " the silos is locked, try later...");
                return;
            }

            try {
                if (closed) {
                    return;
                }

                if (Objects.isNull(capacity) || capacity.compareTo(new BigDecimal("0.1")) < 0) {
                    throw new SilosException("SilosService is empty");
                } else if (capacity.compareTo(quantityToExtract) < 0) {
                    closed = true;
                    throw new SilosException(String.format("Quantity to be extracted [%s] is more than capacity [%s]", quantityToExtract, capacity));
                }

                capacity = capacity.subtract(quantityToExtract);
                IO.println(userName + " -> inventory remaining: " + capacity);
                Thread.sleep(390);
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SilosException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -471638918376427L;

    public SilosException(String message) {
        super(message);
    }
}

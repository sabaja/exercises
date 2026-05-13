package com.js.exercises.purejava.threads.schedulerpriorita;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class Click implements Runnable {

    private final Thread clickThread;
    @Getter
    private final AtomicLong clicker = new AtomicLong(0L);
    private volatile boolean running = true;

    public Click(int priority) {
        this.clickThread = new Thread(this);
        this.clickThread.setPriority(priority);
    }

    @Override
    public void run() {
        while (running) {
            clicker.incrementAndGet();
        }
    }

    public void stop() {
        running = false;
    }

    public synchronized void start() {
        this.clickThread.start();
    }


}

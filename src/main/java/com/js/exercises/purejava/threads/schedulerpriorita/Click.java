package com.js.exercises.purejava.threads.schedulerpriorita;

import lombok.Getter;

public class Click implements Runnable {

    private final Thread clickThread;
    @Getter
    private long click = 0L;
    private volatile boolean running = true;

    public Click(int priority) {
        this.clickThread = new Thread(this);
        this.clickThread.setPriority(priority);
    }

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    public void stop() {
        running = false;
    }

    public synchronized void start() {
        this.clickThread.start();
    }


}

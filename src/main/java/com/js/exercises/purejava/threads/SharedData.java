package com.js.exercises.purejava.threads;

import com.js.exercises.purejava.threads.nonthread.Scelta;

public class SharedData {

    private Scelta scelta;
    private boolean available = false;

    public synchronized void put(Scelta scelta) throws InterruptedException {
        while (available) {
            wait();
        }
        this.scelta = scelta;
        this.available = true;
        notifyAll();
    }

    public synchronized Scelta take() throws InterruptedException {
        while (!available) {
            wait();
        }
        available = false;
        notifyAll();
        return scelta;
    }
}
package com.js.exercises.purejava.thread;

import com.js.exercises.purejava.thread.nonthread.Scelta;

import java.util.Random;

public class Producer extends Thread {

    private final SharedData sharedData;
    private final int attempts;
    private final Random random = new Random();

    public Producer(SharedData sharedData, int attempts) {
        this.sharedData = sharedData;
        this.attempts = attempts;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < attempts; i++) {
                Scelta scelta = random.nextInt(2) == 0
                        ? Scelta.SOPRA
                        : Scelta.SOTTO;

                sharedData.put(scelta);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
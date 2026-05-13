package com.js.exercises.purejava.threads.idealeconomy.quartaf.esercizio;

import com.js.exercises.purejava.threads.idealeconomy.quartaf.esercizio.nonthread.Scelta;

public class Producer extends Thread {

    private final SharedData sharedData;
    private final int attempts;

    public Producer(SharedData sharedData, int attempts) {
        this.sharedData = sharedData;
        this.attempts = attempts;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < attempts; i++) {
                Scelta scelta = Scelta.randomScelta();

                sharedData.put(scelta);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
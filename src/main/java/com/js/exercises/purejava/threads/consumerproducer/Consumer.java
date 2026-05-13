package com.js.exercises.purejava.threads.consumerproducer;

import com.js.exercises.purejava.threads.consumerproducer.nonthread.Scelta;
import lombok.Getter;

public class Consumer implements Runnable {

    private final SharedData sharedData;
    private final int attempts;

    @Getter
    private int guessedResults = 0;

    public Consumer(SharedData sharedData, int attempts) {
        this.sharedData = sharedData;
        this.attempts = attempts;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < attempts; i++) {
                Scelta producerChoice = sharedData.take();

                Scelta ownScelta = Scelta.randomScelta();

                if (ownScelta == producerChoice) {
                    guessedResults++;
                }

                IO.println(
                        "Tentativo " + (i + 1) +
                                " | Produttore: " + producerChoice +
                                " | Consumatore: " + ownScelta
                );
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
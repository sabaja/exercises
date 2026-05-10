package com.js.exercises.purejava.threads;

import com.js.exercises.purejava.threads.nonthread.Scelta;
import lombok.Getter;

import java.util.Random;

public class Consumer extends Thread {

    private final SharedData sharedData;
    private final int attempts;
    private final Random random = new Random();

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

                Scelta ownScelta = random.nextInt(2) == 0
                        ? Scelta.SOPRA
                        : Scelta.SOTTO;

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
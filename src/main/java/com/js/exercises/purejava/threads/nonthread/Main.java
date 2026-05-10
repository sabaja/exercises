package com.js.exercises.purejava.threads.nonthread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    static void main() throws InterruptedException {

        AtomicReference<Scelta> scelta = new AtomicReference<>();
        AtomicBoolean isCorrect = new AtomicBoolean(false);
        Consumer consumer = new Consumer();
        final int MAX_RESULTS = 20;

        for (int i = 1; i <= MAX_RESULTS; i++) {
            Thread producerThread = new Thread(() -> {
                final Producer producer = new Producer();
                scelta.set(producer.produce());
            });
            producerThread.start();
            producerThread.join();

            Thread consumerThread = new Thread(() ->
                    isCorrect.set(consumer.consume(scelta.get())));

            consumerThread.start();
            consumerThread.join();

            String corretto = isCorrect.get() ? "Giusto" : "Sbagliato";
            IO.println("Tentativo " + i + " " + corretto + " Produttore ha scelto " + scelta.get().toString() + ", Consumatore ha scelto " + consumer.getOwnScelta().toString());
        }

        final AtomicInteger guessedResults = consumer.getGuessedResults();
        final int percentuale = (guessedResults.get() * 100) / MAX_RESULTS;

        IO.println("Numero di volte indovinate " + guessedResults.get() + "\nPercentuale " + percentuale + "%");
    }
}
package com.js.exercises.purejava.threads;

public class Main {


   static void main() throws InterruptedException {

        final int MAX_RESULTS = 20;

        SharedData sharedData = new SharedData();

        Producer producer = new Producer(sharedData, MAX_RESULTS);
        Consumer consumer = new Consumer(sharedData, MAX_RESULTS);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        int guessed = consumer.getGuessedResults();
        int percentuale = guessed * 100 / MAX_RESULTS;

        IO.println(
                "Numero di volte indovinate: " + guessed +
                        "\nPercentuale: " + percentuale + "%"
        );
    }

}

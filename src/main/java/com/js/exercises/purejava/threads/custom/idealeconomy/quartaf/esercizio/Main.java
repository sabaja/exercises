package com.js.exercises.purejava.threads.custom.idealeconomy.quartaf.esercizio;

public class Main {


    static void main() throws InterruptedException {

        final int MAX_RESULTS = 20;

        SharedData sharedData = new SharedData();

        Producer producer = new Producer(sharedData, MAX_RESULTS);
        Consumer consumer = new Consumer(sharedData, MAX_RESULTS);

        producer.start();
        consumer.start();

//        producer.join();
        /*
          Comunico al thread principale di aspettare la fine del processo innescato dai thread producer e consumer
          Senza il metodo join serebbe andato subito ai comandi sotto
        */
        consumer.join();

        int guessed = consumer.getGuessedResults();
        int percentuale = guessed * 100 / MAX_RESULTS;

        IO.println(
                "Numero di volte indovinate: " + guessed +
                        "\nPercentuale: " + percentuale + "%"
        );
    }

}

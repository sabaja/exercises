package com.js.exercises.purejava.threads.custom.idealeconomy;

public class CustomIdealEconomy {

    static void main() {
        WareHouse wareHouse = new WareHouse();
        new Thread(new Consumer(wareHouse), "Consumer").start();
        new Thread(new Producer(wareHouse), "Producer").start();

    }

}

class WareHouse {

    private int numberOfProducts;
    private volatile int idProduct;

    private volatile boolean empty = true; // guarded block

    public synchronized void put(int idProduct) {
        if (!empty) { // se il magazzino non è vuoto
            try {
                this.wait(); // blocca il producer
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.idProduct = idProduct;
        this.numberOfProducts++;
        this.empty = false;
        printSituation("Prodotto oggetto n°:" + idProduct);
        this.notify();
    }

    public synchronized int get() {
        if (empty) { // se il magazzino è vuoto
            try {
                wait(); // blocca consumer
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        numberOfProducts--;
        this.empty = true;
        printSituation("Consumato oggetto n°:" + idProduct);
        this.notify();
        return this.idProduct;
    }


    private synchronized void printSituation(String msg) {
        System.out.println(msg + " - " + numberOfProducts + " oggetto in magazzino");
    }

}

class Consumer implements Runnable {


    private final WareHouse wareHouse;

    Consumer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            wareHouse.put(i);
        }
    }

}

class Producer implements Runnable {


    private final WareHouse wareHouse;

    Producer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            wareHouse.get();
        }
    }

}

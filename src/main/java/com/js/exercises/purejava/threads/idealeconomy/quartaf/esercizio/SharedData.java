package com.js.exercises.purejava.threads.idealeconomy.quartaf.esercizio;

import com.js.exercises.purejava.threads.idealeconomy.quartaf.esercizio.nonthread.Scelta;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedData {

    private final BlockingQueue<Scelta> queue = new ArrayBlockingQueue<>(1);

    public void put(Scelta scelta) throws InterruptedException {
        queue.put(scelta);
    }

    public Scelta take() throws InterruptedException {
        return queue.take();
    }
}
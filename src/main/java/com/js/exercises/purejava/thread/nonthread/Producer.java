package com.js.exercises.purejava.thread.nonthread;

import java.util.Random;

public class Producer {

    synchronized public Scelta produce() {
        Random rand = new Random();
        final int randValue = rand.nextInt(2);
        return randValue == 0 ? Scelta.SOPRA : Scelta.SOTTO;
    }
}

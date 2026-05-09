package com.js.exercises.purejava.thread.nonthread;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public class Consumer {

    AtomicInteger guessedResults = new AtomicInteger(0);
    AtomicReference<Scelta> ownScelta = new AtomicReference<>();

    synchronized public boolean consume(Scelta scelta) {
        Random rand = new Random();
        final int randValue = rand.nextInt(2);
        Scelta ownScelta = randValue == 0 ? Scelta.SOPRA : Scelta.SOTTO;
        this.ownScelta.getAndSet(ownScelta);

        if (ownScelta.equals(scelta)) {
            guessedResults.incrementAndGet();
            return true;
        }
        return false;
    }

}

package com.js.exercises.purejava.threads.consumerproducer.nonthread;

import java.util.concurrent.ThreadLocalRandom;

public enum Scelta {
    SOPRA,
    SOTTO;

    public static Scelta randomScelta() {
        return ThreadLocalRandom.current().nextInt(2) == 0 ? Scelta.SOPRA
                : Scelta.SOTTO;
    }
}

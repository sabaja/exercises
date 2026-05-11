package com.js.exercises.purejava.threads.threadexists;

import java.time.Duration;

public class FirstThread {

    static void main() {
        Thread mainThread = Thread.currentThread();
        mainThread.setName("Main Thread");
        mainThread.setPriority(Thread.MAX_PRIORITY);

        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(Duration.ofMillis(1000));
                System.out.println(mainThread.getName() + " " + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

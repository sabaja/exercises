package com.js.exercises.purejava.threads.schedulerpriorita;

public class ThreadRace {

    static void main() {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Click hiClick = new Click(Thread.NORM_PRIORITY + 2);
        Click loClick = new Click(Thread.NORM_PRIORITY - 2);

        loClick.start();
        hiClick.start();
        IO.println("ThreadRace started, please wait for 10 seconds..");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loClick.stop();
        hiClick.stop();

        IO.println("lo:[" + loClick.getClicker() + "] vs hi:[" + hiClick.getClicker() + "]");

    }
}

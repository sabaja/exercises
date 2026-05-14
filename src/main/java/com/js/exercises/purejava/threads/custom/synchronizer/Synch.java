package com.js.exercises.purejava.threads.custom.synchronizer;

// Provare a commentare le parti synchronized
public class Synch {
    static void main() {

        CallMe target = new CallMe();
        new Caller(target, "Hello");
        new Caller(target, "Synchronized");
        new Caller(target, "World");
    }
}

class CallMe {
    public synchronized void call(String msg) {

        System.out.print("[" + msg);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("]");
    }
}

class Caller implements Runnable {

    private final String msg;

    private final CallMe target;

    public Caller(CallMe t, String s) {
        target = t;
        msg = s;
        new Thread(this).start();
    }

    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }

}


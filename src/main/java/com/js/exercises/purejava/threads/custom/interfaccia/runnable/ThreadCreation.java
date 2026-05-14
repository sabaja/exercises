package com.js.exercises.purejava.threads.custom.interfaccia.runnable;

public class ThreadCreation implements Runnable {

    public ThreadCreation() {
        Thread ct = Thread.currentThread();
        ct.setName("Thread Principale");
        Thread t = new Thread(this, "Thread Figlio");
        System.out.println("Thread Principale: " + ct);
        System.out.println("Thread Secondario: " + t);
        t.start();
        try {
            /*
                Un altro metodo simile al metodo sleep() è il metodo join().
                A differenza di sleep() però, join() non è un metodo statico.
                Va chiamato su una particolare istanza.
                In particolare, supponiamo che un certo thread stia eseguendo una certa parte di codice. S
                e trova sulla sua strada un’espressione del tipo: t.join() dove t è un altro thread in esecuzione,
                il thread corrente si metterà in pausa sino a quando il thread t non avrà completato il suo compito.
            */
            t.join(); // Il thread principale aspetta che t finisca
            Thread.sleep(3000); // Il thread principale riaquisisce il controllo ma si blooca per 3 secondi si poteva scrivere t.join(3000);
            System.out.println("Uscita thread principale");
        } catch (InterruptedException e) {
            System.out.println("principale interrotto");

        }
    }

    static void main() {
        new ThreadCreation();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread figlio: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("figlio interrotto");
        }
        System.out.println("Uscita thread figlio");
    }
}

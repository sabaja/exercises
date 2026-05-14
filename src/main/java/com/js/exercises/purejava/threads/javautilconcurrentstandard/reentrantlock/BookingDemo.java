package com.js.exercises.purejava.threads.javautilconcurrentstandard.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Simuliamo un servizio di prenotazione (posti limitati).
    Regola:

    Se il posto è disponibile → prenoti
    Se qualcuno sta già prenotando → non resti bloccato, fai fallback

    Cosa hai ottenuto grazie a ReentrantLock?
		* Controllo sul tempo di attesa
		* Nessun thread resta bloccato all’infinito
		* Fallback controllato
		* Puoi loggare, ritentare, degradare il servizio
		* Gestione pulita dell’interruzione fondamentale in ambienti enterprise

	👉 Con synchronized:

	i thread si sarebbero ammucchiati
	nessun timeout
	nessun controllo


	🔑 Qui sta l’utilità concreta di Lock

	non è per “proteggere”
	è per governare cosa succede quando NON puoi entrare
*/
public class BookingDemo {

    static void main() {

        BookingService service = new BookingService(2);

        Runnable task = () -> {
            String user = Thread.currentThread().getName();
            service.tryBook(user);
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task, "User-" + i).start();
        }
    }
}

class BookingService {

    private final Lock lock = new ReentrantLock();
    private int availableSeats;

    public BookingService(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void tryBook(String user) {
        try {
            // Aspetto al massimo 300 ms il lock
            if (!lock.tryLock(300, TimeUnit.MILLISECONDS)) {
                System.out.println(user + " -> sistema occupato, riprova più tardi");
                return;
            }

            try {
                if (availableSeats > 0) {
                    // simuliamo operazione lenta (DB, rete)
                    Thread.sleep(200);
                    availableSeats--;
                    System.out.println(user + " -> prenotazione OK | posti rimasti: " + availableSeats);
                } else {
                    System.out.println(user + " -> nessun posto disponibile");
                }
            } finally {
                lock.unlock();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
package com.js.exercises.purejava.scopedvalues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScopedUserExample {
//    static final ScopedValue<String> USER = ScopedValue.newInstance();
//    static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();
//
//
//    static void main() {
//        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            executor.submit(() -> ScopedValue.where(USER, "Alice").run(() -> {
//                System.out.println("Thread1: " + Thread.currentThread());
//                System.out.println("User1: " + USER.get());
//                doSomething(executor, CURRENT_USER);
//            }));
//
//            executor.submit(() -> ScopedValue.where(USER, "Bob").run(() -> {
//                System.out.println("Thread2: " + Thread.currentThread());
//                System.out.println("User2: " + USER.get());
//            }));
//
//            executor.submit(() -> ScopedValue.where(USER, "Jacopo").run(() -> {
//                System.out.println("Thread3: " + Thread.currentThread());
//                System.out.println("User3: " + USER.get());
//            }));
//            // Optional delay to ensure output appears before main exits
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//
//    private static void doSomething(ExecutorService executor, ScopedValue<String> user) {
//        executor.submit(() -> ScopedValue.where(user, user.get()).run(() -> System.out.println(user.orElse("A"))));
//    }
}

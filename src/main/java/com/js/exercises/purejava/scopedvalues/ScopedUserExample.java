package com.js.exercises.purejava.scopedvalues;

public class ScopedUserExample {
//    static final ScopedValue<String> USER = ScopedValue.newInstance();
//    static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();
//
//
//    static void main() {
//        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            executor.submit(() -> ScopedValue.where(USER, "Alice").run(() -> {
//                IO.println("Thread1: " + Thread.currentThread());
//                IO.println("User1: " + USER.get());
//                doSomething(executor, CURRENT_USER);
//            }));
//
//            executor.submit(() -> ScopedValue.where(USER, "Bob").run(() -> {
//                IO.println("Thread2: " + Thread.currentThread());
//                IO.println("User2: " + USER.get());
//            }));
//
//            executor.submit(() -> ScopedValue.where(USER, "Jacopo").run(() -> {
//                IO.println("Thread3: " + Thread.currentThread());
//                IO.println("User3: " + USER.get());
//            }));
//            // Optional delay to ensure output appears before main exits
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//
//    private static void doSomething(ExecutorService executor, ScopedValue<String> user) {
//        executor.submit(() -> ScopedValue.where(user, user.get()).run(() -> IO.println(user.orElse("A"))));
//    }
}

package com.js.exercises.purejava.threads.classeimmutabile;

import java.time.ZonedDateTime;

public record ImmutableRecord(int id, String name, ZonedDateTime dateTime) {

    public ImmutableRecord {
        if (name == null || dateTime == null) {
            throw new IllegalArgumentException("name e dateTime non possono essere null");
        }
    }
}
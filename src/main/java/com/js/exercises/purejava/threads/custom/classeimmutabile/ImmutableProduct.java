package com.js.exercises.purejava.threads.custom.classeimmutabile;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Objects;

@Getter
public final class ImmutableProduct {

    private final int id;
    private final String name;
    private final ZonedDateTime createdDate;

    public ImmutableProduct(int id, String string, ZonedDateTime createdDate) {
        this.id = id;
        this.name = Objects.requireNonNull(string, "name must not be null");
        this.createdDate = Objects.requireNonNull(createdDate, "createdDate must not be null");
    }

    @Override
    public String toString() {
        return "ImmutableProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
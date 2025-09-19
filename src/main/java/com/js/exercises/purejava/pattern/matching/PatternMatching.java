package com.js.exercises.purejava.pattern.matching;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PatternMatching {

    public static String describeDayOfWeek(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case null -> "Are you alright, mate?";
            case FRIDAY -> "Hold on till 17.00! than margarita time";
            case SATURDAY, SUNDAY -> "Bella vita!";
            default -> "Boring work Day..";
        };
    }

    static String asStringValue(Object anyValue) {

        return switch (anyValue) {
            case null       -> "n/a";
            case String str      -> str;
            case JSONObject json -> json.toString();
            case BigDecimal bd   -> bd.toEngineeringString();
            case Integer i       -> Integer.toString(i);
            case LocalDate ld    -> ld.format(DateTimeFormatter.ISO_LOCAL_DATE);
            default -> throw new IllegalStateException("Unexpected value: "  + anyValue.getClass() + " is not supported");
        };
    }

    public static void main(String[] args) {
        System.out.println(describeDayOfWeek(LocalDate.now().getDayOfWeek()));
        final var string = """
                {"dire":"ciao"}
                """;
        JSONObject json = new JSONObject(string);
        System.out.println(asStringValue(json));
        BigDecimal bigDecimal = new BigDecimal("13.45");
        System.out.println(asStringValue(bigDecimal));
        System.out.println(asStringValue(LocalDateTime.now()));

    }
}

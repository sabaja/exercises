package com.js.exercises.purejava.generics;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class ProveGenerics {

    static void main() {
        Box<Number> numbers = new Box<>();
        numbers.add(Integer.valueOf("1"));
        numbers.add(Double.valueOf("2.1"));
        numbers.add(Integer.valueOf("13"));
        numbers.add(Double.valueOf("4.011"));
        IO.println(numbers.countHowManyOccurenceOfElement(numbers.getBoxedList(), Double.valueOf("2.1")));
    }
}

@ToString
@Getter
class Box<E> {

    private final List<E> boxedList = new ArrayList<>();

    public void add(E element) {
        boxedList.add(element);
    }

    public <T> int countHowManyOccurenceOfElement(List<? extends T> elements, T element) {
        int num = 0;
        for (T t : elements) {
            if (t.equals(element)) {
                ++num;
            }
        }
        return num;
    }
}
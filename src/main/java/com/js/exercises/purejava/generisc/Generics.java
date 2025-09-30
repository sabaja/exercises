package com.js.exercises.purejava.generisc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface Inheritance {
    String toString();
}

public class Generics {


    static void main(String[] args) {
//        test1Generics();
        testInheritance();
        

    }

    private static void testInheritance() {
        final Util<Inheritance> inherintanceUtil = new Util<>();
        final Test test = new Test();
        Pair<Integer, String> pair = new Pair<>(1, "1");

        inherintanceUtil.addElement(test);
        inherintanceUtil.addElement(pair);
        System.out.println(inherintanceUtil);
    }

    private static void test1Generics() {
        Pair<Integer, Object> p1 = new Pair<>(1, 3);
        Pair<Integer, Object> p2 = new Pair<>(1, 3);
        boolean same = Util.compare(p1, p2);
        boolean ref = p1 == p2;
        System.out.println(same + " " + ref);
        System.out.println(p1 + " " + p2);
    }
}

@Getter
@Setter
@AllArgsConstructor
class Pair<K, V> implements Inheritance {
    private K key;
    private V value;

    @Override
    public String toString() {
        return "PAIR";
    }
}

class Util<E extends Inheritance> {

    private final List<E> inheritances = new ArrayList<>();

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue()) && p1.equals(p2);
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0) {
                ++count;
            }
        return count;
    }

    public void addElement(E element) {
        inheritances.add(element);
    }

    @Override
    public String toString() {
        return inheritances.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}

class Test implements Inheritance {

    @Override
    public String toString() {
        return "TEST";
    }
}


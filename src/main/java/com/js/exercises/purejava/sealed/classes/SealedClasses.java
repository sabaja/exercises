package com.js.exercises.purejava.sealed.classes;


public class SealedClasses {
}
                    // si può scrivere anche senza permits perchè nello stesso file
sealed class Figure permits Circle, Square, Rectangle {
}

final class Circle extends Figure {
    float radius;
}

non-sealed class Square extends Figure {
    float side;
}

final class FilledRectangle extends Rectangle {
    int red, green, blue;

}

sealed class Rectangle extends Figure {
    float length, width;
}

class MySquare extends Square {
    String color;
}
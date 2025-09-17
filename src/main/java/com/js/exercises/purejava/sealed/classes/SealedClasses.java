package com.js.exercises.purejava.sealed.classes;


import lombok.Getter;
import lombok.ToString;

sealed interface Service permits Car, Truck {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }

}

public class SealedClasses {

    public static void main(String[] args) {
        final var truck = new Truck(100, "0000AAAZ");
        final var car = new Car(4, "1224PPPP1");
        System.out.println(truck.getLoadCapacity() + truck.getMaxServiceIntervalInMonths());
        System.out.println(car.getMaxDistanceBetweenServicesInKilometers() + car.getMaxServiceIntervalInMonths());
        Service service = new Car(5, "NILL");
        System.out.println(service.getMaxServiceIntervalInMonths());
    }
}

@Getter
abstract sealed class Vehicle permits Car {

    protected final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}

record Truck(int loadCapacity, String registrationNumber) implements Service {


    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 32;
    }
}

@ToString
@Getter
non-sealed class Car extends Vehicle implements Service {

    private final int numberOfSeats;

    public Car(int numberOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 12;
    }

}

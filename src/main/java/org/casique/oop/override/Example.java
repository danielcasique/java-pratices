package org.casique.oop.override;

import lombok.Data;

@Data
class Vehicle {

    public double value;

    void run(String name) {
        System.out.println(name + " is running");
    }

    public void printDetails() {
    }

    public double calculateValue() {
        return 0.0;
    }

    public void addVehicleToDB() {
    }
}

class Car extends Vehicle {

}

class VehicleCalculations {
    public double calculateValue(Vehicle v) {
        if (v instanceof Car) {
            return v.getValue() * 0.8;
        }
        if (v instanceof Bike) {
            return v.getValue() * 0.5;
        }
        return 0.0;
    }
}

class Bike extends Vehicle {

    void run(String name) {
        System.out.println(name + " is running safely");
    }

    void run(String name, int wheels) {
        System.out.println(name + " is running safely on " + wheels + " wheels");
    }

    public static void main(String args[]) {
        Bike obj = new Bike();
        obj.run("Bike");
        obj.run("Bike", 2);
    }
}

public class Example  {

    public static void main(String args[]) {
        Bike obj = new Bike();
        obj.run("Bike");
        obj.run("Bike", 2);
    }
}

/*
public class Vehicle {
    public double calculateValue() {...}
}
public class Car extends Vehicle {
    public double calculateValue() {
        return this.getValue() * 0.8;
}
public class Truck extends Vehicle{
    public double calculateValue() {
        return this.getValue() * 0.9;
}
 */
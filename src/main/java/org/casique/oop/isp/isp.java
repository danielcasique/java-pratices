package org.casique.oop.isp;

//Interface Segregation Principle (ISP)
interface Vehicle {
    public void drive();
    public void stop();
    public void refuel();
    public void openDoors();
}

class Bike implements Vehicle {

    // Can be implemented
    public void drive() {

    }
    public void stop() {

    }
    public void refuel() {

    }

    public void openDoors() {

    }
}

public class isp {
}

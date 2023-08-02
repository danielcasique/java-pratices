package org.casique.dagger;

public class Main {

  public static void main(String[] args) {
    VehiclesComponent component = DaggerVehiclesComponent.create();
    Car one = component.buildCar();
    Car two = component.buildCar();
  }

}

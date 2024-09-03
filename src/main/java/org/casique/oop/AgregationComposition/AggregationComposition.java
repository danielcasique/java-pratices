package org.casique.oop.AgregationComposition;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

enum PersonType{
  Passenger,
  Pilot,
  Driver,
  Captain,
  Rider
}

@Data
class Person{
  private String name;
  private PersonType type; //to-do enum
}

enum TransportationType{
  Air,
  Road,
  Sea,
  Rail
}

@Data
abstract class Transportation{
  private TransportationType type;
  private Integer maxPassengers;
  private List<Person> passengers;

  public abstract void start();
  public abstract void stop();
}

class Engine{
  private String brand;
  private Double taxPerMinute;
  private Double costPerMinute;
}

class Plate{
  private String number;
  private String year;
  private String model;
}

@EqualsAndHashCode(callSuper = true)
@Data
class Car extends Transportation{

  private Engine engine;
  private Plate plate;

  @Override
  public void start() {
    //TO-Do
  }

  @Override
  public void stop() {
  //TO-Do
  }
}

public class AggregationComposition {

  public static void main(String[] args) {
    Person driver = new Person();
    List<Person> passengers = new ArrayList<>();
    passengers.add(driver);
    Engine engine = new Engine();
    Car car = new Car();
    car.setEngine(engine);
    car.setPlate(new Plate());
    car.setPassengers(passengers);
  }

}

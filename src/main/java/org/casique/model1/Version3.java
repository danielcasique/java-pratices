package org.casique.model1;

import lombok.Data;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@Data
class Plate{
    private String plateNumber;

    private String brand;

    private int year;
}

enum PersonType{
    Driver,
    Captain,
    Pilot,
    Passenger
}

@Data
class Person{
    private String name;

    private PersonType type;

    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;
    }
}

enum VehicleType{
    Car,
    Ship,
    Plane;
}

enum EngineType{
    Petrol,
    Electric,
    Gas
}

@Data
@ToString
abstract class Transportation {

    private VehicleType type;
    private int maxPassengers;
    List<Person> passengers;
    private Plate plate;

    private Transportation(){

        passengers = new ArrayList<>();
        plate = new Plate();
    }

    public Transportation(VehicleType type,  int maxPassengers){
        this();
        this.type = type;
        this.maxPassengers = maxPassengers;
    }

    public void start() throws Exception {
        validate();
        System.out.println("Starting a " +  type);
    }

    public void stop(){
        System.out.println("stopping a " +  type);
    }

    public void validate() throws Exception {
        if(passengers.size()>maxPassengers){
            throw new Exception("Overloaded!!!");
        }
    }
}

@Data
abstract class EngineTransportation extends Transportation {


    public EngineTransportation(VehicleType vehicleType, int maxPassengers, EngineType engineType) {
        super(vehicleType, maxPassengers);
        this.engineType = engineType;
    }

    private EngineType engineType;

    private Double taxPerMinute;

    private Double costPerMinute;

    private int minutes;

    public void calculateCost(){
        System.out.println("The cost is: " + (costPerMinute * minutes) + ". The tax is: " + (taxPerMinute * minutes));
    }

}
@Data
class Car extends EngineTransportation {

    private Integer doors;
    public Car(VehicleType vehicleType, int maxPassengers, EngineType engineType) {
        super(vehicleType, maxPassengers, engineType);
    }

    @Override
    public void validate() throws Exception {
        String label = "";
        if(EngineType.Electric.equals(this.getEngineType())){
            label = "no";
        }
        System.out.printf("%s %s has %s tax \n", this.getEngineType(), this.getType(), label);

        boolean requiredType = false;
        for(var value : this.getPassengers()){
            if(PersonType.Driver.equals(value.getType())){
                requiredType  = true;
            }
        }
        if(!requiredType){
            throw new Exception("Car has not driver!!!");
        }
    }

    @Override
    public void stop() {
        super.stop();
        this.calculateCost();
    }
}

@Data
class Plane extends Transportation {

    public Plane(VehicleType type, int maxPassengers) {
        super(type, maxPassengers);
    }

    @Override
    public void validate() throws Exception {

        boolean requiredType = false;
        for(var value : this.getPassengers()){
            if(PersonType.Pilot.equals(value.getType())){
                requiredType  = true;
            }
        }
        if(!requiredType){
            throw new Exception("Car has not driver!!!");
        }
    }
}

class Ship extends Transportation {

    public Ship(VehicleType type, int maxPassengers) {
        super(type, maxPassengers);
    }

    @Override
    public void validate() throws Exception {
        boolean requiredType = false;
        for(var value : this.getPassengers()){
            if(PersonType.Captain.equals(value.getType())){
                requiredType  = true;
            }
        }
        if(!requiredType){
            throw new Exception("Car has not driver!!!");
        }
    }
}

public class Version3 {

    public static void main(String ...args) throws Exception {

        Car obj = new Car(VehicleType.Car, 5, EngineType.Petrol);
        obj.getPlate().setBrand("Volkswagen T-Cross");
        obj.setDoors(4);
        obj.setMaxPassengers(5);
        obj.setTaxPerMinute(0.006);
        obj.setCostPerMinute(0.15);
        obj.getPlate().setPlateNumber("ABC123");
        obj.getPlate().setYear(2021);
        obj.getPassengers().add(new Person("Pedro Perez", PersonType.Driver));
        obj.setMinutes(60);
        obj.start();
        obj.stop();



    }
}






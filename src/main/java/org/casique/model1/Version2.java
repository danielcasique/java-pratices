package org.casique.model1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Vehicle2{
    String plateNumber;
    String brand;
    String type;
    int year;
    int maxPassengers;
    List<String> passengerName;
    List<String> passengerType;
    int wheels;
    int doors;
    String engineType;
    double taxPerMinute;

    double costPerMinute;
    int minutes;

    void start() throws Exception {

        if(passengerName.size()>maxPassengers){
            throw new Exception("Overloaded!!!");
        }

        if(type.equals("Car")){
            if(engineType.equals("Electric")){
                System.out.println("Electric car has not tax");
            }else if(engineType.equals("Petrol")){
                System.out.println("Petrol car generates tax");
            }else if(engineType.equals("Gas")) {
                System.out.println("Petrol car generates tax");
            }
            boolean requiredType = false;
            for(String value : passengerType){
                if(value == "Driver"){
                    requiredType  = true;
                }
            }
            if(!requiredType){
                throw new Exception("Car has not driver!!!");
            }

        }else if(type.equals("Ship")){
            if(wheels > 0){
                throw new Exception("bad setting!!!");
            }
            boolean requiredType = false;
            for(String value : passengerType){
                if(value == "Captain"){
                    requiredType  = true;
                }
            }
            if(!requiredType){
                throw new Exception("Ship has not captain!!!");
            }

        }else if(type.equals("plane")){
            boolean requiredType = false;
            for(String value : passengerType){
                if(value == "Pilot"){
                    requiredType  = true;
                }
            }
            if(!requiredType){
                throw new Exception("plane has not Pilot!!!");
            }
        }
        System.out.println("Starting a " +  type);
    }

    void stop(){
        System.out.println("stopping a " +  type + "The cost is: " + (costPerMinute * minutes) + ". The tax is: " + (taxPerMinute * minutes));
    }
}

public class Version2 {

    public static void main(String ...args) throws Exception {

        Vehicle2 obj = new Vehicle2();
        obj.type = "Car";
        obj.brand = "Volkswagen T-Cross";
        obj.doors = 4;
        obj.maxPassengers = 5;
        obj.taxPerMinute = 0.006;
        obj.costPerMinute = 0.15;
        obj.engineType = "Petrol";
        obj.plateNumber = "ABC123";
        obj.year = 2021;
        obj.passengerName = new ArrayList<>();
        obj.passengerType = new ArrayList<>();
        obj.passengerType.add("Driver");
        obj.passengerName.add("Pedro Perez");
        obj.minutes = 60;
        obj.start();
        obj.stop();



    }


}


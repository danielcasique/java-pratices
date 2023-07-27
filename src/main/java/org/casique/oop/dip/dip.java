package org.casique.oop.dip;

//Dependency inversion principle
class Car {
    private Engine engine;
    public Car(Engine e) {
        engine = e;
    }
    public void start() {
        engine.start();
    }
}
class Engine {
    String type;
    public void start() {
        if(type.equals("Petrol")){

        }else if(type.equals("Diesel")){

        }

    }
}

/*
public class Car {
    private Engine engine;
    public Car(Engine e) {
        engine = e;
    }
    public void start() {
        engine.start();
    }
}
public class PetrolEngine implements Engine {
   public void start() {...}
}
public class DieselEngine implements Engine {
   public void start() {...}
}
 */
public class dip {
}

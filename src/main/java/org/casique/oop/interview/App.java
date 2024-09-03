package org.casique.oop.interview;

import java.util.Map;
import org.casique.oop.interview.impl.Fish;
import org.casique.oop.interview.model.Animal;
import org.casique.oop.interview.model.AnimalAbstractFactory;
import org.casique.oop.interview.model.Identity;
import org.casique.oop.interview.model.SupportedAnimals;

public class App {

  public static void main(String[] args) {
    Animal dog = AnimalAbstractFactory.createAnimal(SupportedAnimals.Dog, "001");
    Animal eagle = AnimalAbstractFactory.createAnimal(SupportedAnimals.Eagle, "002");
    Animal eagle2 = AnimalAbstractFactory.createAnimal(SupportedAnimals.Eagle, "002");

    Map<Identity, Animal> animalMap = Map.of(dog.id, dog, eagle.id, eagle);
    System.out.println(eagle == eagle2);
    eagle = eagle2;
    dog = eagle;

    //Fish fish1 = AnimalAbstractFactory.createAnimal(SupportedAnimals.Fish, "003");
  }
}

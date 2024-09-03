package org.casique.oop.interview.model;

import org.casique.oop.interview.impl.Dog;
import org.casique.oop.interview.impl.Eagle;

public class AnimalAbstractFactory {

  public static Animal createAnimal(SupportedAnimals type, String code) {
    Animal obj;
    switch (type) {
      case Dog :
        //obj = new Dog();
        break;
      case Eagle:
        obj = new Eagle();
        break;
      default:
          return null;
    }
    //obj.id.code = code;
   // obj.id.type = type;
    //return obj;
    return null;
  }

}

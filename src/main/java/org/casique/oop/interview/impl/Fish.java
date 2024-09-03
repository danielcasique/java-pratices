package org.casique.oop.interview.impl;

import org.casique.oop.interview.model.Animal;
import org.casique.oop.interview.model.Swim;

public class Fish extends Animal implements Swim {

  @Override
  public void swim() {
    System.out.printf("%s is swimming ", this.name);
  }
}

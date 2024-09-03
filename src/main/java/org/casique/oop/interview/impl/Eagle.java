package org.casique.oop.interview.impl;

import org.casique.oop.interview.model.Animal;
import org.casique.oop.interview.model.Fly;
import org.casique.oop.interview.model.Swim;
import org.casique.oop.interview.model.Walk;

public class Eagle extends Animal implements Fly, Walk {

  public void fly() {
    System.out.printf("%s is flying ", this.name);
  }

  public void fly(int meters){
    System.out.printf("%s is flying to %d meters", this.name, meters);
  }

  public void walk() {
    System.out.printf("%s is walking ", this.name);
  }
}

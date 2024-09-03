package org.casique.oop.interview.impl;

import org.casique.oop.interview.model.Animal;
import org.casique.oop.interview.model.Walk;

public class Dog extends Animal implements Walk {

  protected int paws;
  protected boolean tail;

  public Dog(int paws) {
    this.paws = paws;
  }

  public Dog(int paws, boolean tail){
    this(paws);
    this.tail = tail;
  }

  @Override
  public void walk() {
    this.breath();
    //System.out.printf("%s is walking. Color %".formatted(this.name, this.color));
  }

  @Override
  public String toString() {
    return "Dog{" +
        "name=" + this.name +
     //   ", color=" + this.color +
        ", tail=" + tail +
        ", paws=" + paws +
        '}';
  }
}


package org.casique.oop.interview.model;

public abstract class Animal {

  private Integer age;
  public Identity id;
  protected String name;
  String color;

  protected void breath(){
    System.out.println("breathing...");
  }

  public void eat(){
    System.out.println("eating...");
  }

  public final void setAge(int age){
    this.age = age;
  }

}

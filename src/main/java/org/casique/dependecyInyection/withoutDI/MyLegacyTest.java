package org.casique.dependecyInyection.withoutDI;

public class MyLegacyTest {


  public static void main(String[] args) {
    MyApplication app = new MyApplication();
    app.processMessage("Hi Daniel", "daniel@test.com");
  }
}

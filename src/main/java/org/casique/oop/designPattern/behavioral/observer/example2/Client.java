package org.casique.oop.designPattern.behavioral.observer.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Synchronized;

abstract class Company {

  List<Observer> observerList = new ArrayList<>();
  @Getter
  private String name;
  @Getter
  private int stockPrice;

  public Company(String name) {
    this.name = name;
  }

  public void setStockPrice(int stockPrice){
    this.stockPrice = stockPrice;
    notifyRegisteredUsers();
  }

  abstract void register(Observer o);

  abstract void unRegister(Observer o);

  abstract void notifyRegisteredUsers();
}

interface Observer {
  void getNotification(Company company);
  String getObserverName();
}

class Employee implements Observer{
  String observerName;

  public Employee(String observerName) {
    this.observerName = observerName;
  }

  @Override
  public void getNotification(Company company) {
    System.out.println(observerName + " has received an alert form " + company.getName() + " stock price " + company.getStockPrice());
  }

  @Override
  public String getObserverName() {
    return observerName;
  }
}

class Customer implements Observer{
  String observerName;

  public Customer(String observerName) {
    this.observerName = observerName;
  }

  @Override
  public void getNotification(Company company) {
    System.out.println(observerName + " has received an alert form " + company.getName() + " stock price " + company.getStockPrice());
  }

  @Override
  public String getObserverName() {
    return observerName;
  }
}

class SpecificCompany extends Company{

  public SpecificCompany(String name) {
    super(name);
  }

  @Override
  void register(Observer anObserver) {
    observerList.add(anObserver);
    System.out.println(this.getName() + " registers " + anObserver.getObserverName());
  }

  @Override
  void unRegister(Observer anObserver) {
    observerList.remove(anObserver);
    System.out.println(this.getName() + " unregisters " + anObserver.getObserverName());
  }

  @Override
  void notifyRegisteredUsers() {
    for(Observer observer : observerList){
      observer.getNotification(this);
    }
  }
}

class CompanyEnvironment implements Runnable{

  private final Company company;

  public CompanyEnvironment(Company company) {
    this.company = company;
  }

  //@Synchronized
  public void addObserver(Observer observer){
    synchronized (this.company.getName()){
      this.company.register(observer);
    }
  }

  //@Synchronized
  public void removeObserver(Observer observer)
  {
    synchronized (this.company.getName()){
      this.company.unRegister(observer);
    }
  }

  @Override
  public void run() {
    while (true){
      try {
        long time = (new Random()).nextInt(10000);
        System.out.println("new waiting time : " + time);
        Thread.sleep(time);
        int stockPrice = (new Random()).nextInt(2000);
        System.out.println("new stockPrice : " + stockPrice);
        this.company.setStockPrice(stockPrice);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}


public class Client {

  public static void main(String[] args) {
    System.out.println("****Observer Pattern****");
    Observer roy = new Employee("Roy");
    Observer kevin = new Employee("Kevin");
    Observer bose = new Customer("Bose");
    Observer jacklin = new Customer("Jacklin");

    Company abcLtd = new SpecificCompany("ABC Ltd. ");
    // Registering the observers - Roy, Kevin, Bose
    abcLtd.register(roy);
    abcLtd.register(kevin);
    abcLtd.register(bose);
    System.out.println(" ABC Ltd.'s current stock price is $5.");
    abcLtd.setStockPrice(5);
    System.out.println("-----");
    // Kevin doesn't want to get further notification.
    System.out.println("ABC Ltd. is removing Kevin from the observer list now.");
        abcLtd.unRegister(kevin);
    // No notification is sent to Kevin any more.
    System.out.println("ABC Ltd.'s new stock price is $50.");
    abcLtd.setStockPrice(50);
    System.out.println("-----");
    System.out.println("Kevin registers again to get notification from ABC Ltd.");
    abcLtd.register(kevin);
    System.out.println("ABC Ltd.'s new stock price is $100.");
    abcLtd.setStockPrice(100);
    System.out.println("-----");
    System.out.println("Working with another company: XYZ Co.");
    // Creating another company
    Company xyzCo = new SpecificCompany("XYZ Co. ");
    // Registering the observers-Roy and Jacklin
    xyzCo.register(roy);
    xyzCo.register(jacklin);
    System.out.println("XYZ Co.'s new stock price is $500.");
    xyzCo.setStockPrice(500);

    //in a thread
    Company testCO = new SpecificCompany("Test Thread CO");
    CompanyEnvironment companyEnvironment = new CompanyEnvironment(testCO);
    Thread worker = new Thread(companyEnvironment);
    worker.setName("Thread 1");
    worker.start();
    companyEnvironment.addObserver(roy);
    companyEnvironment.addObserver(jacklin);
    companyEnvironment.addObserver(kevin);
  }

}

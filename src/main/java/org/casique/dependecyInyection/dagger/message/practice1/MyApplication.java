package org.casique.dependecyInyection.dagger.message.practice1;

public class MyApplication {

  public static void main(String[] args) {
    MyDIApplicationFactory app = DaggerMyDIApplicationFactory.create();
    MyDIApplication service =  app.buildMyDiApplication();
    service.processMessages("daniel", "daniel@test.com");
  }

}

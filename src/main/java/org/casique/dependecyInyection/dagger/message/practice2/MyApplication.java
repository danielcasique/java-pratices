package org.casique.dependecyInyection.dagger.message.practice2;


public class MyApplication {

  public static void main(String[] args) {
    MyDIApplicationFactory app = DaggerMyDIApplicationFactory.create();
    MyDIApplication service =  app.buildMyDIApplication();
    service.processMessages(MessageType.EMAIL, "daniel", "daniel@test.com");
    service.processMessages(MessageType.SMS, "daniel", "123");
  }

}

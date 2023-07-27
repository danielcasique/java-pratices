package org.casique.dependecyInyection.dagger.message.practice2;

import javax.inject.Inject;

public class SMSService implements MessageService {

  @Inject
  SMSService(){  }

  @Override
  public void sendMessage(String msg, String rec) {
    //logic to send SMS
    System.out.println("SMS sent to "+rec+ " with Message="+msg);
  }

}
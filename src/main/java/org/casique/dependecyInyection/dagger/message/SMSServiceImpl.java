package org.casique.dependecyInyection.dagger.message;

import javax.inject.Inject;

public class SMSServiceImpl implements MessageService {

  @Inject
  SMSServiceImpl(){

  }

  @Override
  public void sendMessage(String msg, String rec) {
    //logic to send SMS
    System.out.println("SMS sent to "+rec+ " with Message="+msg);
  }

}
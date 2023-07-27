package org.casique.dependecyInyection.dagger.message.practice2;

import javax.inject.Inject;

public class EmailService implements MessageService {

  @Inject
  EmailService(){}
  @Override
  public void sendMessage(String msg, String rec) {
    //logic to send email
    System.out.println("Email sent to " + rec + " with Message=" + msg);
  }

}

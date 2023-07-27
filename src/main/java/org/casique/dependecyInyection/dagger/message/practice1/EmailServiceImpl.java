package org.casique.dependecyInyection.dagger.message.practice1;

import javax.inject.Inject;

public class EmailServiceImpl implements MessageService {

  @Inject
  EmailServiceImpl() {

  }

  @Override
  public void sendMessage(String msg, String rec) {
    //logic to send email
    System.out.println("Email sent to " + rec + " with Message=" + msg);
  }

}

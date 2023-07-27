package org.casique.dependecyInyection.dagger.message;

import javax.inject.Inject;

public class MyDIApplication {

  private MessageService service;
  @Inject
  public MyDIApplication(EmailServiceImpl svc){
    this.service=svc;
  }

  public void processMessages(String msg, String rec){
    //do some msg validation, manipulation logic etc
    this.service.sendMessage(msg, rec);
  }
}

package org.casique.dependecyInyection.withWeld;

import javax.inject.Inject;
import javax.inject.Named;
import org.casique.dependecyInyection.withWeld.qualifiers.EmailQualifier;
import org.casique.dependecyInyection.withWeld.services.MessageService;
public class MyDIApplication {

  private MessageService service;
  @Inject
  public MyDIApplication(@Named("EmailService") MessageService svc){
    this.service=svc;
  }

  public void processMessages(String msg, String rec){
    //do some msg validation, manipulation logic etc
    this.service.sendMessage(msg, rec);
  }
}

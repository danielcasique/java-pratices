package org.casique.dependecyInyection.dagger.message.practice2;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

public class MyDIApplication {

  private Map<String, MessageService> services = new HashMap<>();
  @Inject
  public MyDIApplication(Map<String, MessageService> services){

    this.services=services;
  }

  public void processMessages(MessageType type, String msg, String rec){
    //do some msg validation, manipulation logic etc
    this.services.get(type.name().toUpperCase()).sendMessage(msg, rec);
  }
}

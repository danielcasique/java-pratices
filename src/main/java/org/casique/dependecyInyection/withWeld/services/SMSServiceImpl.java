package org.casique.dependecyInyection.withWeld.services;

import org.casique.dependecyInyection.withWeld.qualifiers.SMSQualifier;

@SMSQualifier
public class SMSServiceImpl implements MessageService {

  @Override
  public void sendMessage(String msg, String rec) {
    //logic to send SMS
    System.out.println("SMS sent to "+rec+ " with Message="+msg);
  }

}
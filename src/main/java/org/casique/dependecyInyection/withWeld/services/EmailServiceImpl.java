package org.casique.dependecyInyection.withWeld.services;

import jakarta.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.casique.dependecyInyection.withWeld.qualifiers.EmailQualifier;

@Named("EmailService")
@ApplicationScoped
@EmailQualifier
public class EmailServiceImpl implements MessageService {

  @Override
  public void sendMessage(String msg, String rec) {
    //logic to send email
    System.out.println("Email sent to "+rec+ " with Message="+msg);
  }

}

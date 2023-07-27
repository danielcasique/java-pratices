package org.casique.dependecyInyection.withoutDI;

public class EmailService {

  public void sendEmail(String message, String receiver){
    System.out.println("Email sent to " + receiver + " with message=" + message);
  }

}

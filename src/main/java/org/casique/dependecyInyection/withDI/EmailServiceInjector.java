package org.casique.dependecyInyection.withDI;

public class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
      return new MyDIApplication(new EmailServiceImpl());
    }

  }

package org.casique.dependecyInyection.dagger.message;

import dagger.Component;

@Component
public interface MyDIApplicationFactory {

  MyDIApplication buildMyDiApplication();

}

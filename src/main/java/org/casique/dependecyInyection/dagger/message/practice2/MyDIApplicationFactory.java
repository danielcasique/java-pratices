package org.casique.dependecyInyection.dagger.message.practice2;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {EmailModule.class, SMSModule.class})
public interface MyDIApplicationFactory {

  MyDIApplication buildMyDIApplication();

}

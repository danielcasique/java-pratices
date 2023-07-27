package org.casique.dependecyInyection.dagger.message.practice2;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
@Module
abstract class EmailModule {

  @Binds
  @IntoMap
  @StringKey("EMAIL")
  abstract MessageService buildEmailService(EmailService emailService);
}

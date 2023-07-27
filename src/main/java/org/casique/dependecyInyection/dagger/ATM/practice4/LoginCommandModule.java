package org.casique.dependecyInyection.dagger.ATM.practice4;

import dagger.Module;
import dagger.Binds;
/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
@Module
abstract class LoginCommandModule {
  @Binds
  abstract Command loginCommand(LoginCommand command);
}

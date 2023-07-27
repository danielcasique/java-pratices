package org.casique.dependecyInyection.dagger.ATM.practice4;

import dagger.Binds;
import dagger.Module;
/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
@Module
abstract class HelloWorldModule {
  @Binds
  abstract Command helloWorldCommand(HelloWorldCommand command);
}

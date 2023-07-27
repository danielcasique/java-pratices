package org.casique.dependecyInyection.dagger.ATM.practice3;

import dagger.Binds;
import dagger.Module;
/**
 * based on https://dagger.dev/tutorial/05-abstraction-for-output
 */
@Module
abstract class HelloWorldModule {
  @Binds
  abstract Command helloWorldCommand(HelloWorldCommand command);
}

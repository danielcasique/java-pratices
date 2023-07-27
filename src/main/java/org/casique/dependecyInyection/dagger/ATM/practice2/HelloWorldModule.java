package org.casique.dependecyInyection.dagger.ATM.practice2;

import dagger.Binds;
import dagger.Module;
/**
 * based on https://dagger.dev/tutorial/04-depending-on-interface
 */
@Module
abstract class HelloWorldModule {
  @Binds
  abstract Command helloWorldCommand(HelloWorldCommand command);
}

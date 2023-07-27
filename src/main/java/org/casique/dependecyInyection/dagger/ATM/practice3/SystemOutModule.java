package org.casique.dependecyInyection.dagger.ATM.practice3;

import dagger.Module;
import dagger.Provides;
/**
 * based on https://dagger.dev/tutorial/05-abstraction-for-output
 */
@Module
abstract class SystemOutModule {
  @Provides
  static Outputter textOutputter(){
    return System.out::println;
  }
}

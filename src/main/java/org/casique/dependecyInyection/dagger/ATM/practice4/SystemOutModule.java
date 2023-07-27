package org.casique.dependecyInyection.dagger.ATM.practice4;

import dagger.Module;
import dagger.Provides;
/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
@Module
abstract class SystemOutModule {
  @Provides
  static Outputter textOutputter(){
    return System.out::println;
  }
}

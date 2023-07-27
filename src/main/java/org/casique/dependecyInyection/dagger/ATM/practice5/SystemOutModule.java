package org.casique.dependecyInyection.dagger.ATM.practice5;

import dagger.Module;
import dagger.Provides;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
 */
@Module
abstract class SystemOutModule {
  @Provides
  static Outputter textOutputter(){
    return System.out::println;
  }
}

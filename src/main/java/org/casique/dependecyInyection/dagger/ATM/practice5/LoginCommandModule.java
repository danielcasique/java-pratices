package org.casique.dependecyInyection.dagger.ATM.practice5;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
 */
@Module
abstract class LoginCommandModule {
  @Binds
  @IntoMap
  @StringKey("login")
  abstract Command loginCommand(LoginCommand command);
}

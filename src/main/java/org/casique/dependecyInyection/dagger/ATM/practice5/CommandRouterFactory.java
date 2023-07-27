package org.casique.dependecyInyection.dagger.ATM.practice5;

import dagger.Component;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
 */
@Component(modules = {HelloWorldModule.class, LoginCommandModule.class, SystemOutModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}

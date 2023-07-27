package org.casique.dependecyInyection.dagger.ATM.practice3;

import dagger.Component;
/**
 * based on https://dagger.dev/tutorial/05-abstraction-for-output
 */
@Component(modules = {HelloWorldModule.class, SystemOutModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}

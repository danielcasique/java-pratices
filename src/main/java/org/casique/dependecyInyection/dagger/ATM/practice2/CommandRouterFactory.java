package org.casique.dependecyInyection.dagger.ATM.practice2;

import dagger.Component;
/**
 * based on https://dagger.dev/tutorial/04-depending-on-interface
 */
@Component(modules = {HelloWorldModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}

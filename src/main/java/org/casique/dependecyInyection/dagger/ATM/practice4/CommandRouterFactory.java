package org.casique.dependecyInyection.dagger.ATM.practice4;

import dagger.Component;
/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
@Component(modules = {LoginCommandModule.class, SystemOutModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}

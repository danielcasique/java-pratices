package org.casique.dependecyInyection.dagger.ATM.practice1;

import dagger.Component;

/**
 * based on https://dagger.dev/tutorial/03-first-command
 */
@Component
interface CommandRouterFactory {
  CommandRouter router();
}

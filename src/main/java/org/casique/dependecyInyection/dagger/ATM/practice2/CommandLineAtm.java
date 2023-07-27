package org.casique.dependecyInyection.dagger.ATM.practice2;

import java.util.Scanner;
import org.casique.dependecyInyection.dagger.ATM.practice2.Command.Result;

/**
 * based on https://dagger.dev/tutorial/04-depending-on-interface
 */
public class CommandLineAtm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //CommandRouter commandRouter = new CommandRouter();
    CommandRouterFactory commandRouterFactory = DaggerCommandRouterFactory.create();
    CommandRouter commandRouter = commandRouterFactory.router();
    while (scanner.hasNextLine()) {
      Result unused = commandRouter.route(scanner.nextLine());
    }
  }

}

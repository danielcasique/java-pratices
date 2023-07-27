package org.casique.dependecyInyection.dagger.ATM.practice3;

import java.util.Scanner;
import org.casique.dependecyInyection.dagger.ATM.practice3.Command.Result;
/**
 * based on https://dagger.dev/tutorial/05-abstraction-for-output
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

package org.casique.dependecyInyection.dagger.ATM.practice4;

import java.util.Scanner;
import org.casique.dependecyInyection.dagger.ATM.practice4.Command.Result;
/**
 * based on https://dagger.dev/tutorial/06-new-command
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

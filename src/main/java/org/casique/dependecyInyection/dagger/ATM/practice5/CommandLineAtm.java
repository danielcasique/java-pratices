package org.casique.dependecyInyection.dagger.ATM.practice5;

import java.util.Scanner;
import org.casique.dependecyInyection.dagger.ATM.practice5.Command.Result;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
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

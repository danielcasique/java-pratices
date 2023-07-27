package org.casique.dependecyInyection.dagger.ATM.practice5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.casique.dependecyInyection.dagger.ATM.practice5.Command.Result;
import org.casique.dependecyInyection.dagger.ATM.practice5.Command.Status;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
 */
public class CommandRouter {
  private final Map<String, Command> commands;
  @Inject
  CommandRouter(Map<String, Command> commands) {
    this.commands = commands;
  }

  Result route(String input) {
    List<String> splitInput = split(input);
    if (splitInput.isEmpty()) {
      return invalidCommand(input);
    }

    String commandKey = splitInput.get(0);
    Command command = commands.get(commandKey);
    if (command == null) {
      return invalidCommand(input);
    }

    List<String> args = splitInput.subList(1, splitInput.size());
    Result result = command.handleInput(args);
    return result.status().equals(Status.INVALID) ?
        invalidCommand(input) : result;
  }

  private Result invalidCommand(String input) {
    System.out.println(
        String.format("couldn't understand \"%s\". please try again.", input));
    return Result.invalid();
  }

  // Split on whitespace
  private static List<String> split(String input) {
    return Arrays.asList(input.trim().split("\\s+"));
  }
}

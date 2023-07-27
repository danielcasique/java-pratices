package org.casique.dependecyInyection.dagger.ATM.practice1;

import java.util.List;
import javax.inject.Inject;

/**
 * based on https://dagger.dev/tutorial/03-first-command
 */
public class HelloWorldCommand implements Command {
  @Inject
  HelloWorldCommand() {}

  @Override
  public String key() {
    return "hello";
  }

  @Override
  public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }
    System.out.println("world!");
    return Result.handled();
  }
}
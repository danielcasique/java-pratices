package org.casique.dependecyInyection.dagger.ATM.practice3;

import java.util.List;
import javax.inject.Inject;
/**
 * based on https://dagger.dev/tutorial/05-abstraction-for-output
 */
public class HelloWorldCommand implements Command {

  private final Outputter outputter;
  @Inject
  HelloWorldCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public String key() {
    return "hello";
  }

  @Override
  public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }
    //System.out.println("world!");
    outputter.output("world!");
    return Result.handled();
  }
}
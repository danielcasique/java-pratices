package org.casique.dependecyInyection.dagger.ATM.practice5;

import java.util.List;
import javax.inject.Inject;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
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
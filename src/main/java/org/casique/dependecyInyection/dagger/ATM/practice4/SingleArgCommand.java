package org.casique.dependecyInyection.dagger.ATM.practice4;

import java.util.List;
/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
abstract class SingleArgCommand implements Command {

  @Override
  public final Result handleInput(List<String> input) {
    return input.size() == 1 ? handleArg(input.get(0)) : Result.invalid();
  }

  /** Handles the single argument to the command. */
  protected abstract Result handleArg(String arg);
}

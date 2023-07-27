package org.casique.dependecyInyection.dagger.ATM.practice5;

import javax.inject.Inject;
/**
 * base on https://dagger.dev/tutorial/07-two-for-the-price-of-one
 */
public class LoginCommand extends
    SingleArgCommand {
  private final Outputter outputter;

  @Inject
  LoginCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public String key() {
    return "login";
  }

  @Override
  public Result handleArg(String username) {
    outputter.output(username + " is logged in.");
    return Result.handled();
  }
}
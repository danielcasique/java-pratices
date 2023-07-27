package org.casique.dependecyInyection.dagger.ATM.practice4;

import javax.inject.Inject;
/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
public class LoginCommand extends SingleArgCommand {
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
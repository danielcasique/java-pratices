package org.casique.dependecyInyection.dagger.ATM.practice4;

import java.util.List;

/**
 * based on https://dagger.dev/tutorial/06-new-command
 */
public interface Command {
  /**
   * String token that signifies this command should be selected (e.g.:
   * "deposit", "withdraw")
   */
  String key();

  /** Process the rest of the command's words and do something. */
  Result handleInput(List<String> input);

  /**
   * This wrapper class is introduced to make a future change easier
   * even though it looks unnecessary right now.
   */
  final class Result {
    private final Status status;

    private Result(Status status) {
      this.status = status;
    }

    static Result invalid() {
      return new Result(Status.INVALID);
    }

    static Result handled() {
      return new Result(Status.HANDLED);
    }

    Status status() {
      return status;
    }
  }

  enum Status {
    INVALID,
    HANDLED
  }
}

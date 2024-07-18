package org.casique.exceptions;

public class AwsKinesisException extends RuntimeException {
  public AwsKinesisException(String message) {
    super(message);
  }

  public AwsKinesisException(String message, Throwable cause) {
    super(message, cause);
  }

  public AwsKinesisException(Throwable cause) {
    super(cause);
  }
}

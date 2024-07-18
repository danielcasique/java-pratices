package org.casique;

import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import org.casique.exceptions.AwsKinesisException;

public class DecoratorRunnable {

  public static void main(String[] args)  {
     TestDecorator.run();
  }
}

class TestDecorator{
  public static void run(){
    try {
      Decorators.ofRunnable(() -> {
        System.out.println(5/0);
      }).withRetry(Retry.ofDefaults("id")).run();
    } catch (RuntimeException var3) {
      throw new AwsKinesisException("Test");
    }
  }
}

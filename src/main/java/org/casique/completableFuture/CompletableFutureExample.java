package org.casique.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // CompletableFuture.completedFuture example

    // CompletableFuture.runAsync example
    CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
      try {
        Thread.sleep(8000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Executing a task asynchronously.");
    });

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("hola");

  }

}

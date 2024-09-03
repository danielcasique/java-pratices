package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.core.Observable;
import java.util.Random;

public class rx003Example {

  public static void main(String[] args) {
    Observable<String> observable = Observable.just("Hello", "RxJava", "World");

    // Creating an Observer
    observable
        .map(s -> s.toUpperCase())
        .filter(s -> s.startsWith("R"))
        .subscribe(
            System.out::println,  // onNext
            throwable -> System.err.println("Error: " + throwable.getMessage()),  // onError
            () -> System.out.println("Completed!")  // onComplete
        );

    Observable<Integer> observableInteger = Observable.range(1,5);

    // Creating an Observer
    observableInteger
       .subscribe(
            s -> {
              Random random = new Random();
              int divisor = random.nextInt(3);
              System.out.println("dividendo : " + s + " divisor : " + divisor);
              System.out.println("result : " + (s / divisor));
            },  // onNext
            throwable -> System.err.println("Error Flow: " + throwable.getMessage()),  // onError
            () -> System.out.println("Completed!")  // onComplete
        );
  }
}

package org.casique.rxjava.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;

public class Parallel {

  public static void main(String[] args) throws InterruptedException {
    Flowable.fromIterable(List.of(1, 2, 3, 4, 5))
        .parallel()
        .runOn(Schedulers.io())
        .map(i -> {
          System.out.println("Processing item " + i + " on thread " + Thread.currentThread().getName());
          return i * 10;
        })
        .sequential()
        .subscribe(result -> System.out.println("Result: " + result + " on thread " + Thread.currentThread().getName()));

    Thread.sleep(20000);
  }

}

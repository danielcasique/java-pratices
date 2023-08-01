package org.casique.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObservableTest {

  public static void main(String[] args) throws InterruptedException {
    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    final StringBuilder result = new StringBuilder();
    Observable<String> observable = Observable.fromArray(letters);
    observable
        .observeOn(Schedulers.io())
        .map(String::toUpperCase)
        .subscribe( letter -> {
          result.append(letter);
          System.out.println("inside: " + result);
        }, error -> error.printStackTrace(), () -> System.out.println("Finish!"));

    Thread.sleep(3);
    System.out.println("here: " + result);
  }
}

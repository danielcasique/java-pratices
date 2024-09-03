package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.core.Observable;

public class rx001Example {

  public static void main(String[] args) {
    Observable<String> observable = Observable.just("Hello", "RxJava", "World");

    // Subscribing Observer to Observable
    observable.subscribe(System.out::println);

  }

}

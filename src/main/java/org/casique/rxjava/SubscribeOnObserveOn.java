package org.casique.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOnObserveOn {

  public static void main(String[] args) throws InterruptedException {
    Observable.just("Hello ", "World")
        .doOnNext(item -> System.out.println("Emitting: " + item + " on " + Thread.currentThread().getName()))
        .subscribeOn(Schedulers.io())
        .subscribe(item -> System.out.println("Emitting: " + item + " on " + Thread.currentThread().getName()));

    Thread.sleep(1000);

    Observable.just("Hello ", "World")
        .doOnNext(item -> System.out.println("Emitting: " + item + " on " + Thread.currentThread().getName()))
        .observeOn(Schedulers.io())
        .subscribe(item -> System.out.println("Emitting: " + item + " on " + Thread.currentThread().getName()));

    Thread.sleep(1000);

  }

}

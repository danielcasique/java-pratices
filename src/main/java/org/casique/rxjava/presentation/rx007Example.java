package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class rx007Example {

  public static void main(String[] args) throws InterruptedException {

    Observable.range(1, 10)
        .map(v -> v * v)
        .subscribe(
            value -> System.out.println("no subscribeOn observeOn " + Thread.currentThread().getName() + " value " + value));

    System.out.println("Sequential");
    Observable.range(1, 10)
        .subscribeOn(Schedulers.io())
        .map( value -> {
          System.out.println("1st map : " + Thread.currentThread().getName());
          return value;
        })
        .observeOn(Schedulers.computation())
        .filter( value -> {
          System.out.println("1st filter : " + Thread.currentThread().getName());
          return value > 0;
        })
        .subscribe(System.out::println);
        //.doOnNext(System.out::println)
        //.blockingSubscribe();

    /*
    System.out.println("Parallel 1");
    Flowable.range(1, 10)
        .parallel()
        .runOn(Schedulers.io())
        .map( value -> {
          System.out.println("(Parallel 1) 1st map : " + Thread.currentThread().getName());
          return value;
        })
        .filter( value -> {
          System.out.println("(Parallel 1) 1st filter : " + Thread.currentThread().getName());
          return value > 0;
        })
        .doOnNext(System.out::println)
        .sequential()
        .blockingSubscribe();
    */



  }
}

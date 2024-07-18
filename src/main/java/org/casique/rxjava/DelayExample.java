package org.casique.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DelayExample {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    Flowable.fromIterable(List.of("11111", "22222", "3333333"))
        .concatMap(item ->
            Flowable.just(item)
                .delay(100, TimeUnit.MILLISECONDS)
        )
        .observeOn(Schedulers.io())
        .map(x -> x.substring(0,3))
        .doOnNext(x -> System.out.println(x + " Time: " + (System.currentTimeMillis() - startTime) +"ms"))
        .blockingSubscribe();
  }

}

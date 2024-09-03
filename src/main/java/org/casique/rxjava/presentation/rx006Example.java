package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class rx006Example {

  public static void main(String[] args) throws InterruptedException {
    Flowable.fromCallable(() -> {
          Thread.sleep(1000); //  imitate expensive computation
          return "Done";
        })
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.single())
        .subscribe(System.out::println, Throwable::printStackTrace);



    /*
    Thread.sleep(2000);

    ///

    Flowable<String> source = Flowable.fromCallable(() -> {
      Thread.sleep(1000); //  imitate expensive computation
      return "Done";
    });

    Flowable<String> runBackground = source.subscribeOn(Schedulers.io());

    Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());

    showForeground.subscribe(System.out::println, Throwable::printStackTrace);

    Thread.sleep(2000);*/
  }
}

package org.casique.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class SingleTest {

  public static void main(String[] args) throws InterruptedException {
    Single.just("Hello World")
        .delay(2, TimeUnit.SECONDS, Schedulers.io())
        .subscribeWith(new DisposableSingleObserver<String>() {

          @Override
          public void onSuccess(@NonNull String s) {
            System.out.println(s);
          }

          @Override
          public void onError(@NonNull Throwable e) {
            e.printStackTrace();
          }
        });
    System.out.println("Hola!!!");

    Single.just("Hello world2")
        .subscribeOn(Schedulers.io())
            .subscribe( t -> System.out.println(t), e -> e.printStackTrace());

    Thread.sleep(3000);

  }

}

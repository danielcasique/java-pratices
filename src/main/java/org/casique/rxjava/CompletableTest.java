package org.casique.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class CompletableTest {

  public static void main(String[] args) throws InterruptedException {
    Completable.complete()
        .delay(2, TimeUnit.SECONDS, Schedulers.io())
        .subscribeWith(new DisposableCompletableObserver() {
          @Override
          public void onComplete() {
            System.out.println("done!");
          }

          @Override
          public void onStart(){
            System.out.println("started!");
          }

          @Override
          public void onError(@NonNull Throwable e) {
            e.printStackTrace();
          }
        });

    Thread.sleep(3000);
  }

}

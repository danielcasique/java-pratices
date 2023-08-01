package org.casique.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class MaybeTest {

  public static void main(String[] args) throws InterruptedException {
    Maybe.just("Hello World")
        .delay(2, TimeUnit.SECONDS, Schedulers.io())
        .subscribeWith(new DisposableMaybeObserver<String>() {
                         @Override
                         public void onSuccess(@NonNull String s) {
                           System.out.println(s);
                         }

                         @Override
                         public void onError(@NonNull Throwable e) {
                           e.printStackTrace();
                         }

                         @Override
                         public void onComplete() {
                           System.out.println("done1!");

                         }
                       }
        );
    System.out.println("Hola!!!");

    Maybe.just("Hello world2")
        .subscribe(s -> System.out.println(s), e -> e.printStackTrace(), () -> System.out.println("done!"));

    Thread.sleep(3000);
  }
}

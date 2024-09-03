package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.core.Observable;

public class rx005Example {

  public static void main(String[] args) {
    Observable.create(emitter -> {
          while (!emitter.isDisposed()) {
            long time = System.currentTimeMillis();
            emitter.onNext(time);
            if (time % 2 != 0) {
              emitter.onError(new IllegalStateException("Odd millisecond!"));
              break;
            }
          }
        })
        .subscribe(System.out::println, Throwable::printStackTrace);
  }
}

package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Random;

public class rx002Example {

  public static void main(String[] args) {

    Observer<String> observer = new Observer<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        System.out.println("Subscribed");
      }

      @Override
      public void onNext(String s) {
        System.out.println(s);
      }

      @Override
      public void onError(Throwable e) {
        System.err.println("Error: " + e.getMessage());
      }

      @Override
      public void onComplete() {
        System.out.println("Completed!");
      }
    };

    Observable<String> observable = Observable.just("Hello", "RxJava", "World");

    observable.subscribe(observer);

    Observer<Integer> observerInt = new Observer<Integer>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        System.out.println("Subscribed");
      }

      @Override
      public void onNext(Integer s) {
        Random random = new Random();
        int divisor = random.nextInt(3);
        System.out.println("dividendo : " + s + " divisor : " + divisor);
        System.out.println("result : " + (s / divisor));
      }

      @Override
      public void onError(Throwable e) {
        System.err.println("Error Flow: " + e.getMessage());
      }

      @Override
      public void onComplete() {
        System.out.println("Completed!");
      }

    };

    Observable<Integer> observableInt = Observable.just(1,2,3,4,5);
    observableInt.subscribe(observerInt);

  }
}






/*
 try {
 if (divisor == 0) {
 throw new ArithmeticException("Division by zero error");
 } else {
 System.out.println("Result: " + (s / divisor));
 }
 } catch (Throwable e) {
 onError(e);  // Manually call onError
 }
 */

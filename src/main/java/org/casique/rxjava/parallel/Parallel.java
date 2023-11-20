package org.casique.rxjava.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;

public class Parallel {

  void test(){
    String methodName = new Object() {}
        .getClass()
        .getEnclosingMethod()
        .getName();

    System.out.println("method: " + methodName);
  }

  public static void main(String[] args) throws InterruptedException {

    String s = String.format("%s|%s|%s", "casa", null, "grande");
    String methodName = new Object() {}
        .getClass()
        .getEnclosingMethod()
        .getName();
    System.out.println("method: " + methodName);

    System.out.println(BigDecimal.ZERO.floatValue());
    System.out.println(NumberUtils.FLOAT_ZERO);

    Parallel test = new Parallel();
    test.test();
    Flowable.fromIterable(List.of(1, 2, 3, 4, 5))
        .parallel()
        .runOn(Schedulers.io())
        .map(i -> {
          System.out.println("Processing item " + i + " on thread " + Thread.currentThread().getName());
          return i * 10;
        })
        .sequential()
        .subscribe(result -> System.out.println("Result: " + result + " on thread " + Thread.currentThread().getName()));

    Thread.sleep(20000);
  }

}

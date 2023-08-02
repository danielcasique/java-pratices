package org.casique.rxjava.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

class Test {

  private List<String> list;

  public static Test newInstance() {
    System.out.println("newInstance : " + Thread.currentThread().getName());
    Test test = new Test();
    test.list = List.of("A", "B", "C", "D", "E", "F", "G", "H");
    return test;
  }

  public Optional<List<String>> getList() {
    System.out.println("getList : " + Thread.currentThread().getName());
    return Optional.of(this.list);
  }

  public Optional<String> getItem(String value) throws InterruptedException {
    long time = (new Random()).nextInt(2000) + 1000;
    Thread.sleep(time);
    System.out.println("getItem : " +  value + " : " + time + " : " + Thread.currentThread().getName());
    return this.list.stream().filter(x -> x.equals(value)).findFirst();
  }
}

public class RxExample {

  public static void main(String[] args) throws InterruptedException {

    Consumer<Optional<String>> consume = optionalValue -> {
      System.out.println("Consumer : " +  optionalValue + " : "  + Thread.currentThread().getName());
      if(optionalValue.isPresent()){
        System.out.println(optionalValue.get());
      }else {
        System.out.println("Item not found");
      }
    };
    Test test = Test.newInstance();
    Flowable.fromOptional(test.getList())
        .flatMap(Flowable::fromIterable)
        .parallel()
        .runOn(Schedulers.io())
        .map(test::getItem)
        .doOnNext(consume::accept)
        .sequential()
        .doOnComplete(() -> System.out.println("finish!"))
        .blockingSubscribe();

    Thread.sleep(8000);
  }
}

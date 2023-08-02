package org.casique.rxjava;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

class Test3 {

  private List<String> list;

  public static Test3 newInstance() {
    System.out.println("newInstance : " + Thread.currentThread().getName());
    Test3 test = new Test3();
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
public class RxJava3 {

  public static void main(String[] args) throws InterruptedException {
    Consumer<String> consume = value -> {
      System.out.println("consumer : " + Thread.currentThread().getName());
      System.out.println(value);
    };
    Test3 test = Test3.newInstance();
    Flowable.fromOptional(test.getList())
        .observeOn(Schedulers.io())
        .flatMap(Flowable::fromIterable)
        .flatMap(item -> Flowable.just(item)
            .observeOn(Schedulers.io())
            .doOnNext(test::getItem))
        .doOnNext(consume::accept)
        .doOnError(error -> System.out.println(error.getMessage()))
        .doOnComplete(() -> System.out.println("finish!"))
        .blockingSubscribe();

    Thread.sleep(8000);
  }
}

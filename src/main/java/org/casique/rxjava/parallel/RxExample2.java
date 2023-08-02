package org.casique.rxjava.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

class Test2 {

  private List<String> list;

  public static Test2 newInstance() {
    System.out.println("newInstance : " + Thread.currentThread().getName());
    Test2 test = new Test2();
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
public class RxExample2 {

  public static void main(String[] args) throws InterruptedException {
    Consumer<Optional<String>> consume = optionalValue -> {
      System.out.println("consumer : " + Thread.currentThread().getName());
      if(optionalValue.isPresent()){
        System.out.println(optionalValue.get());
      }else {
        System.out.println("Item not found");
      }
    };
    Test2 test = Test2.newInstance();
    Flowable.fromOptional(test.getList())
        .observeOn(Schedulers.io())
        .flatMap(Flowable::fromIterable)
        .map(test::getItem)
        .doOnNext(consume::accept)
        .doOnError(error -> System.out.println(error.getMessage()))
        .doOnComplete(() -> System.out.println("finish!"))
        .blockingSubscribe();

    Thread.sleep(8000);
  }

}

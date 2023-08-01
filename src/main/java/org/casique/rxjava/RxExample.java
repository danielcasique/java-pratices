package org.casique.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import org.jboss.jdeparser.FormatPreferences.Opt;

class Test {

  private List<String> list;

  public static Test newInstance() {
    Test test = new Test();
    test.list = List.of("A", "B", "C");
    return test;
  }

  public Optional<List<String>> getList() {
    return Optional.of(this.list);
  }

  public Optional<String> getItem(String value) throws InterruptedException {
    Thread.sleep((new Random()).nextInt(2000) + 1000);
    return this.list.stream().filter(x -> x.equals(value)).findFirst();
  }
}

public class RxExample {

  public static void main(String[] args) throws InterruptedException {
    Consumer<Optional<String>> consume = optionalValue -> {
      if(optionalValue.isPresent()){
        System.out.println(optionalValue.get());
      }else {
        System.out.println("Item not found");
      }
    };
    Test test = Test.newInstance();
    Flowable.fromOptional(test.getList())
        .observeOn(Schedulers.io())
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

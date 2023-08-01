package org.casique.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import org.jboss.jdeparser.FormatPreferences.Opt;

class Test{

  private List<String> list;

  public static Test newInstance(){
    Test test = new Test();
    test.list = List.of("A", "B", "C");
    return test;
  }

  public Optional<List<String>> getList(){
    return Optional.of(this.list);
  }

  public Optional<String> getItem(String value) throws InterruptedException {
    Thread.sleep((new Random()).nextInt(2000)+1000);
    return this.list.stream().filter(x -> x.equals(value)).findFirst();
  }
}
public class RxExample {

  public static void main(String[] args) throws InterruptedException {
    Consumer<String> consume = System.out::println;
    Test test = Test.newInstance();
    Flowable.fromOptional(test.getList())
        .flatMapIterable(list -> list)
        .parallel()
        .runOn(Schedulers.computation())
        .map(test::getItem)
        .sequential()
        .filter(Optional::isPresent)
        .map(Optional::get)
        .subscribe(consume::accept);

    Thread.sleep(8000);
  }
}

package org.casique.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class CombineLatestTest {

  public static void main(String[] args) {
    Integer[] numbers = { 1, 2, 3, 4, 5, 6};
    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    final StringBuilder result = new StringBuilder();
    Observable<String> observable1 = Observable.fromArray(letters);
    Observable<Integer> observable2 = Observable.fromArray(numbers);
    Observable.combineLatest(observable1, observable2, (a,b) -> a + b)
        .subscribe( letter -> result.append(letter));
    System.out.println(result);
  }

}

package org.casique.rxjava.presentation;

import io.reactivex.rxjava3.core.Flowable;

public class rx004example {

  public static void main(String[] args) {
    Flowable<Integer> flow = Flowable.range(1, 5)
        .map(v -> v * v)
        .filter(v -> v % 3 == 0);

    flow.subscribe(System.out::println);

  }

  /**
   * 1 * 1 = 1 % 3 = 1 (0,1)
   * 2 * 2 = 4 % 3 = 1 (1,)
   * 3 * 3 = 9 % 3 = 0 (2)
   * 4 * 4 = 16 % 3 = 1  (5,)
   * 5 * 5 = 25 % 3 = 1 (8,)
   */
}

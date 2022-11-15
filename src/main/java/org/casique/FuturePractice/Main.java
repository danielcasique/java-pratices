package org.casique.FuturePractice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String... args) throws InterruptedException, ExecutionException {
        FutureExample testFuture = new FutureExample(0);
        Future<Integer> future = testFuture.calculate(10);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();
        System.out.println("The square is " + result );
        testFuture.shutdown();

        FutureExample testFuture2 = new FutureExample(1);
        Future<Integer> future1 = testFuture2.calculate(10);
        Future<Integer> future2 = testFuture2.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        testFuture2.shutdown();

        FutureExample testFuture3 = new FutureExample(2);
        Future<Integer> future31 = testFuture3.calculate(10);
        Future<Integer> future32 = testFuture3.calculate(100);

        while (!(future31.isDone() && future32.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future31.isDone() ? "done" : "not done",
                            future32.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result31 = future31.get();
        Integer result32 = future32.get();

        System.out.println(result31 + " and " + result32);

        testFuture3.shutdown();
    }
}

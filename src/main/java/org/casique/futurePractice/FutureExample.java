package org.casique.futurePractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    private ExecutorService executor;

    public FutureExample(int threads){
       executor = threads > 1? Executors.newFixedThreadPool(threads) : Executors.newSingleThreadExecutor();
    }

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public void shutdown(){
        executor.shutdown();
    }
}

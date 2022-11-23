package org.casique.runnableExample;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        // We will store the threads so that we can check if they are done
        List<MyThreadExample> threads = new ArrayList<MyThreadExample>();
        // We will create 500 threads
        for (int i = 0; i < 500; i++) {
            MyThreadExample task = new MyThreadExample(10000000L + i);
            task.start();
            // Remember the thread for later usage
            threads.add(task);
        }
        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }
            System.out.println("We have " + running + " running threads. ");
        } while (running > 0);

    }
}

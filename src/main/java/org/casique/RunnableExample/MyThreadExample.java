package org.casique.RunnableExample;

public class MyThreadExample extends Thread{

    private final long countUntil;

    public MyThreadExample(long countUntil) {
        this.countUntil = countUntil;
    }

    public void run()
    {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

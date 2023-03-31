package org.casique.oop.designPattern.behavioral.strategy;

//This code belongs to https://medium.com/javarevisited/strategy-design-pattern-java-30439e00299e

interface IOperationStrategy {
    void compute();
}

abstract class AbstractOperationStrategy implements IOperationStrategy {

    private final int a;
    private final int b;

    public AbstractOperationStrategy(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

final class PlusOperationStrategy extends AbstractOperationStrategy {


    public PlusOperationStrategy(int a, int b){
        super(a, b);
    }

    @Override
    public void compute() {
        System.out.println(getA() + getB());
    }
}

final class MinusOperationStrategy extends AbstractOperationStrategy{

    public MinusOperationStrategy(int a, int b){
        super(a, b);
    }

    @Override
    public void compute() {
        System.out.println(getA() - getB());
    }
}

class CalculatorContext {

    private IOperationStrategy strategy;

    public CalculatorContext(IOperationStrategy strategy){
        this.strategy = strategy;
    }

    public void compute(){
        this.strategy.compute();
    }
}


public class Strategy {

    public static void main(String[] args) {

        CalculatorContext ctx = new CalculatorContext(new PlusOperationStrategy(2, 3));
        ctx.compute();

        ctx = new CalculatorContext(new MinusOperationStrategy(2, 3));
        ctx.compute();

    }
}

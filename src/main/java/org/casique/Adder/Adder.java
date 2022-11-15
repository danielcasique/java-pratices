package org.casique.Adder;

/**
 * The goal of this exercise is to understand how to use and implement an abstract class
 */

abstract class Calculator {
    abstract int add(int a, int b);
}

public class Adder extends Calculator{

    @Override
    int add(int a, int b) {
        return a + b;
    }
}
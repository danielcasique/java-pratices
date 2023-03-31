package org.casique.oop.polymorphism;

class Helper {

    static int Multiply(int a, int b)
    {
        return a * b;
    }

    static int Multiply(int a, int b, int c)
    {
        return a * b * c;
    }

    public static void main(String[] args)
    {
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(2, 7, 3));
    }
}
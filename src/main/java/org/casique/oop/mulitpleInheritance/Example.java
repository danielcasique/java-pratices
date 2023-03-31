package org.casique.oop.mulitpleInheritance;

interface A
{
    public abstract void execute();
}
interface B
{
    public abstract void execute();
}

abstract class C{
    void execute(){
        System.out.println("Haii.. I am from class C");
    }

    abstract void execute(String name);
}
class D extends C implements A,B
{
    public void execute()
    {
        System.out.println("Haii.. I am from class D");
    }

    @Override
    void execute(String name) {
        System.out.printf("Haii %s I am from class D \n", name);
    }


}
public class Example
{
    public static void main(String[] args)
    {
        A objA = new D();
        B objB = new D();
        C objC = new D();
        D objD = new D();
        objA.execute();
        objB.execute();
        objC.execute();
        objD.execute();
        objD.execute("John");
    }
}
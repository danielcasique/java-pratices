package org.casique.stringPractice;

public class StringPractice {

    public static void main(String ...args){
        String test1 = "Hola";
        String test2 = "Hola";
        String test3 = new String("Hola");
        System.out.println(test1 == test2);
        System.out.println(test1 == test3);
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(test3.hashCode());
        System.out.println(System.identityHashCode(test1));
        System.out.println(System.identityHashCode(test2));
        System.out.println(System.identityHashCode(test3));
    }
}

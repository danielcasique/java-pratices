package org.casique;

import java.lang.reflect.Method;
import java.util.Locale;

class Test{
    private void message(){
        System.out.printf("hello java");
    }
}

public class Main {

    public void messageTest(){
       // System.out.printf(String.format("Runtime.freeMemory()=%d", Runtime.freeMemory()));
    }

    public static int misterio(int uno, int dos){
        int calculo = 1;
        for(int x=0; x<dos; x++)
            calculo *= uno;
        return calculo;
    }

    public static void main(String[] args) {

        int moon=9, star = 2 + 2 * 3;
        float sun = star > 10 ? 1 : 3;
        double jupiter = (sun + moon) - 1.0f;
        int mars = --moon <= 8 ? 2 : 3;
        System.out.println(sun+"-"+jupiter+"-"+mars);

        var s1 = "Java";
        var s2= "Java";
        var s3 = "Ja".concat("va");
        var s4 = s3.intern();
        var sb1 = new StringBuilder();
        sb1.append("Ja").append("va");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(sb1.toString()==s1);
        System.out.println(sb1.toString().equals(s1));
        String s5 = "Baeldung";
        String s6 = new String("Baeldung");
        String s7 = new String("Baeldung").intern();
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);

        System.out.println(Main.misterio(2,4));

        Locale usersLocale = Locale.ITALY;
        System.out.println(String.format("There are %,d shirts to choose from. Good luck.", 1024));


        int j=2;
        System.out.println(j == 3);

        int x=0;
        do{
            System.out.println(x);
            x++;
        }while(x<10);

        int y=0;
        while(y<10){
            System.out.println(y);
            y++;
        }
        System.out.println("x="+x+" y="+y);

        switch(y){
            case 2:
                System.out.println("dos");
                break;
            case 4:
                System.out.println("cuarto");
                break;
        }

        /* int x = 10;
        int y = 0;
        while(y<x){
            y += x;
        }
        System.out.println(y);
        */
        /*
        Class c = null;
        try {
            c = Class.forName("com.casique.Test");
            Object o = c.newInstance();
            Method m = c.getDeclaredMethod("message", null);
            m.setAccessible(true);
            m.invoke(o, null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}

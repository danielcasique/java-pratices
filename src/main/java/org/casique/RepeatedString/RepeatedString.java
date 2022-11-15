package org.casique.RepeatedString;

import java.util.Arrays;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        //get the "a"s number
        Long aCounters =  Arrays.asList(s.split("")).stream().filter(x -> x.equals("a")).count();
        Long times = n / s.length();
        Long pendingSentenceSize = new Long(0);
        Long pendingsA = new Long(0);
        if(times * s.length() < n){
            pendingSentenceSize = n - times * s.length();
        }
        if(pendingSentenceSize > 0){
            String s1 = s.substring(0, pendingSentenceSize.intValue());
            pendingsA =  Arrays.asList(s1.split("")).stream().filter(x -> x.equals("a")).count();
        }

        return aCounters.longValue() * times.longValue() + pendingsA.longValue();

    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }
}

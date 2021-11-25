package fizzBuzz;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class PrintBuzzValidator {

    public static final int MIN_LIMIT = 1;
    public static final int MAX_LIMIT = (int)(2 * Math.pow(10,5));

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here
        float mod5;
        float mod3;
        if(n<MIN_LIMIT || n>MAX_LIMIT){
            throw new IllegalArgumentException(
                    String.format(
                            "The n value has an illegal value. It must be between %s and %s", MIN_LIMIT, MAX_LIMIT));
        }
        for(int i = MIN_LIMIT; i <= n; i++) {
            mod3 = i % 3;
            mod5 = i % 5;
            if (mod3 == 0 && mod5 == 0) {
                System.out.println("FizzBuzz");
            } else if (mod3 == 0) {
                System.out.println("Fizz");
            } else if (mod5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

}


public class PrintBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        PrintBuzzValidator.fizzBuzz(n);

        bufferedReader.close();
    }
}

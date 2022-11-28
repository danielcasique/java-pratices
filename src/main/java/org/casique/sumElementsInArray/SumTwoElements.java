package org.casique.sumElementsInArray;


// Dado arreglo ordenado de n enteros positivos, validar si un número
// x es el resultado de la suma de dos números cualquiera del arreglo.
// Ejemplo: [2,3,5] x = 7 resultado = true

// Extra: Se aspira a que la complejidad de la solución sea lineal, es decir de o(n)
import java.util.*;

public class SumTwoElements {

    public static void main(String args[]) {
        int numbers[] = { 1, 4, 6, 10, 45, 88 };
        long x = 16;

        int sum = 0;
        // Write code here..
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = i + 1;
            while (numbers[j] <= x && j < numbers.length && sum < x) {
                sum = numbers[i] + numbers[j];
                j++;
            }
            if (sum == x)
                break;
        }
        boolean result = x == sum;
        System.out.println("result = " + result + " " + sum);
    }
}

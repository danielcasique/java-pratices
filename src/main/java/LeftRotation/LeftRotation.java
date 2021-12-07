package LeftRotation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        Queue<Integer> queue = new LinkedList<>();

        Arrays.stream(a).forEach(x -> queue.add(x));
        int temp;
        for(int i=0; i<d; i++){
            temp = queue.peek();
            queue.remove();
            queue.add(temp);
        }
        int []finalArray = new int[a.length];
        for(int i=0; i<a.length; i++){
            temp = queue.peek();
            finalArray[i] = temp;
            queue.remove();
        }
        return finalArray;
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5};
        Arrays.stream(rotLeft(arr, 4)).forEach(System.out::println);

    }

}

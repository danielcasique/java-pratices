package org.casique.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

    public static void main(String[] args) {
        Practice practice = new Practice();

        int[] array = {-1, -2, -3};
        System.out.println(practice.solution(array));
    }

    public int solution(int[] A) {
        // Implement your solution here
        if (A == null || A.length == 0) {
            return 1;
        }
        boolean []check = new boolean[1000001];
        for(int i=0; i<A.length;i++){
            if(A[i]>0){
                check[A[i]] = true;
            }
        }
        for(int i=1; i<check.length; i++){
           if(!check[i]){
               return i;
           }
        }
        return 1000001;
        /*
        if (A == null || A.length == 0) {
            return 1;
        }
        List<Integer> input = Arrays.stream(A).boxed().parallel().filter(x -> x > 0).sorted().distinct().collect(Collectors.toList());
        if (input.isEmpty()){
            return 1;
        }
        int result = 0;
        int i;
        for(i=0; i<input.size()-1; i++){
            if(input.get(i) != input.get(i+1) -1){
                result = input.get(i) + 1;
                break;
            }
        }
        return result == 0? input.get(i) + 1 : result;

         */

        /*
        List<Integer> input = Arrays.stream(A).boxed().parallel().sorted().distinct().collect(Collectors.toList());
        Integer minValue = Collections.min(input);
        Integer maxValue = Collections.max(input);
        List<Integer> result = IntStream.range(minValue, maxValue).boxed().collect(Collectors.toList());
        result.removeAll(input);
        int finalResult = result.isEmpty()? maxValue+1 : Collections.min(result);
        return finalResult < 0 ? 1 : finalResult;*/
    }
}

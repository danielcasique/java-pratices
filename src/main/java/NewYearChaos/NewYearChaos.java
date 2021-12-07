package NewYearChaos;

import java.util.ArrayList;
import java.util.List;

public class NewYearChaos {

    static void minimumBribes2(int[] q) {
        int temp;
        int numberToMove;
        int indexNumberToMove;
        int sumBrides = 0;

        List<Integer> original = new ArrayList<>();

        for(int i=0; i<q.length; i++){
            original.add(i+1);
        }

        for(int i= 0; i<q.length-1; i++){
            if(original.get(i) != q[i]){
                indexNumberToMove = original.indexOf(q[i]);
                temp = indexNumberToMove - i;
                if(temp > 2){
                    System.out.println("Too chaotic");
                    return;
                }
                if(temp > 0) {
                    sumBrides += temp;
                }
                numberToMove = original.get(indexNumberToMove);
                original.remove(indexNumberToMove);
                original.add(i, numberToMove);
            }
        }

        System.out.println(sumBrides);
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int temp;
        int sumBrides = 0;
        boolean tooChaotic = false;
        for(int i=0; i<q.length; i++){
            temp = q[i] - (i+1);
            if(temp > 2){
                tooChaotic = true;
            }
            if(temp > 0) {
                sumBrides += temp;
            }
        }

        if(tooChaotic){
            System.out.println("Too chaotic");
        }else{
            System.out.println(sumBrides);
        }

    }

    public static void main(String[] args) {
        int []arr = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(arr);

    }
}
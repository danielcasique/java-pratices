package org.casique.MinimumSwaps2;

public class MinimumSwaps2 {

    static int processminimumSwaps(int[] arr, int min, int max, int steps){
        int localSteps = 0;
        int left = min;
        int right = max;
        int pivote = arr[(left + right)/2];
        int aux;
        do {
            while(left < max && arr[left]<=pivote) left++;
            while(right > min &&  arr[right]>pivote ) right--;
            if(left < right){
                System.out.println("cambio arr[" +left+"]=" + arr[left] + " arr[" + right + "]="+arr[right]);
                aux = arr[left];
                arr[left] = arr[right];
                arr[right] = aux;
                localSteps++;
                left++; right--;
            }
        }while(left <= right);
        if(min < right - 1){
            localSteps = processminimumSwaps(arr, min, right - 1, localSteps + steps);
        }
        if(right+1 < max){
            localSteps = processminimumSwaps(arr,  right + 1, max, localSteps + steps);
        }
        return localSteps;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        return processminimumSwaps(arr, 0, arr.length-1, 0);
    }
    public static void main(String[] args) {
        int []arr = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(minimumSwaps(arr));
    }

}
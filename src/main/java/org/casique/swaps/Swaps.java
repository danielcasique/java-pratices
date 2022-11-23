package org.casique.swaps;

public class Swaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int j = 0;
        int i = 0;
        int aux = 0;
        boolean cont = true;
        while(i < arr.length){
            if(arr[i] != i + 1){
                j = ((arr[i]-1)<(arr.length/2))? i+1 : arr.length /2 ;
                cont = true;
                while (j<arr.length && cont){
                    if(arr[i] > arr[j]){
                        aux = arr[i];
                        arr[i] = arr[j];
                        arr[j] = aux;
                        swaps++;
                        cont = false;
                    }else{
                        j++;
                    }
                }
            }else{
                i++;
            }
        }
        return swaps;
    }


    public static void main(String[] args)  {
        int []arr = {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
        System.out.println(Swaps.minimumSwaps(arr));
    }


}

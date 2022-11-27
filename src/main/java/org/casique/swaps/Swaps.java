package org.casique.swaps;

public class Swaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps1(int[] arr) {
        int swaps = 0;
        int j = 0;
        int i = 0;
        int aux = 0;
        boolean cont = true;
        while(i < arr.length){
            if(arr[i] != i + 1){
                j = ((arr[i]-1)<(arr.length/2))? i+1 : arr.length /2 ;
                j = (i>=j)? (i+1) : j;
                cont = true;
                while (j<arr.length && cont){
                    if(arr[i] > arr[j]){
                        System.out.printf("cambiando arr[%d]=%d por arr[%d]=%d \n",i, arr[i], j, arr[j]);
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

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        int j = 0;
        int aux = 0;
        while(i < arr.length){
            j = arr[i]-1;
            if(arr[i] != arr[j]){
                System.out.printf("cambiando arr[%d]=%d por arr[%d]=%d \n",i, arr[i], j, arr[j]);
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
                swaps++;
            }else{
                i++;
            }
        }
        return swaps;
    }


    public static void main(String[] args)  {
        //9
        int []arr = {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
        //5
        //int []arr = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(Swaps.minimumSwaps(arr));
    }


}

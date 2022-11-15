package org.casique.ReductorArray;
import java.util.List;

public class ReductorArray {

    /*
     * Complete the 'comparatorValue' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     *  3. INTEGER d
     */

    public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
        // Write your code here
        int comparatorValue = 0;

        for(Integer value: a){
            long temp = b.stream().filter(x -> Math.abs(value - x )>d).count();
            if(temp == b.size()){
                comparatorValue++;
            }
        }

        return comparatorValue;
    }
}

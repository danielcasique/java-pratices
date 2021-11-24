package restockingTheWarehouse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestockingTheWarehouse {

    /*
     * Complete the 'restock' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY itemCount
     *  2. INTEGER target
     */

    public static int restock(List<Integer> itemCount, int target) {
        // Write your code here
        boolean ok = true;
        int sum=0;
        for(int i=0; i<itemCount.size() && ok; i++){
            sum += itemCount.get(i);
            if(sum>=target){
                ok = false;
            }
        }
        return Math.abs(target - sum);
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40,15);
        System.out.println(restock(list, 80));
    }
}

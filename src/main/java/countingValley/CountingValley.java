package countingValley;

import java.util.Stack;

public class CountingValley {


    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        int stepsFromSea = 0;
        int valleysCounter = 0;
        boolean check = false;
        for(int i=0; i<path.length(); i++){

            Character c =  path.charAt(i);

            if(c.equals('U')){
                stepsFromSea++;
            }else{
                stepsFromSea--;
            }
            //in the valley
            if(stepsFromSea < 0 || !stack.isEmpty()){
                check = true;
                if(stack.isEmpty() || stack.lastElement().equals(c)){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }

            if(check && stack.isEmpty()){
                valleysCounter++;
                check = false;
            }

        }
        return valleysCounter;
    }

    public static void main (String argv[]) {
        System.out.println(countingValleys(8, "DDUUDDUDUUUD"));
    }

}

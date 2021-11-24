package jumpingOnTheClouds;

public class JumpingOnTheClouds {

    static int countSteps(int[] c, int currentPosition, int steps){

        int preTotalSteps = 0;
        int preTotalStepsAux = 0;

        if(currentPosition+1 == c.length - 1){
            return steps + 1;
        }
        if (c[currentPosition + 1] == 0) {
            preTotalSteps = countSteps(c, currentPosition + 1, steps + 1);
        }

        if(currentPosition+2 == c.length - 1){
            return steps + 1;
        }
        if (c[currentPosition + 2] == 0) {
            preTotalStepsAux = countSteps(c, currentPosition + 2, steps + 1);
            if(preTotalSteps != 0 && preTotalSteps > preTotalStepsAux){
                preTotalSteps = preTotalStepsAux;
            }else{
                preTotalSteps = preTotalStepsAux;
            }
        }

        return preTotalSteps;

    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int totalSteps =countSteps(c, 0, 0);
        return totalSteps;
    }

    public static void main (String argv[]) {
        int []input = {0,0,0,0,1,0};
        System.out.println(jumpingOnClouds(input));
    }
}
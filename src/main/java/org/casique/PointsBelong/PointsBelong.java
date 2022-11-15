package org.casique.PointsBelong;

import java.io.*;

import static java.util.stream.Collectors.joining;

public class PointsBelong {

    /*
     * Complete the 'pointsBelong' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER y1
     *  3. INTEGER x2
     *  4. INTEGER y2
     *  5. INTEGER x3
     *  6. INTEGER y3
     *  7. INTEGER xp
     *  8. INTEGER yp
     *  9. INTEGER xq
     *  10. INTEGER yq
     */

    public static double computePoints(int x1, int y1, int x2, int y2){
        Double result;
        if(x1 == x2 || y1 == y2){
            result = ((double) Math.abs(x1 - x2) + Math.abs(y1 - y2));
        }else{
            result = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
        }
        return result;
    }

    public static double Area(int x1, int y1, int x2, int y2, int x3, int y3){
        return (double) Math.abs((x1 *(y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
    }

    public static boolean isPointIn(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp){
        double areaTriangle = PointsBelong.Area(x1,y1,x2,y2,x3,y3);
        double areaP12 = PointsBelong.Area(xp,yp,x1,y1,x2,y2);
        double areaP23 = PointsBelong.Area(xp,yp,x2,y2,x3,y3);
        double areaP13 = PointsBelong.Area(xp,yp,x1,y1,x3,y3);
        return (areaP12 + areaP23 + areaP13) == areaTriangle;
    }

    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
        // Write your code here
        double ab = PointsBelong.computePoints(x1, y1, x2, y2);
        double bc = PointsBelong.computePoints(x2, y2, x3, y3);
        double ac = PointsBelong.computePoints(x1, y1, x3, y3);
        int result = 0;
        if((ab + bc) > ac && (bc + ac) > ab && (ab + ac) > bc){
            //it's a non-degenerate triangle
            boolean pointPIsIn = PointsBelong.isPointIn(x1, y1, x2, y2, x3, y3, xp, yp);
            boolean pointQisIn = PointsBelong.isPointIn(x1, y1, x2, y2, x3, y3, xq, yq);
            if(pointPIsIn && pointQisIn)    {
                result = 3;
            }else if(pointPIsIn){
                result = 1;
            }else if(pointQisIn){
                result = 2;
            }else{
                result = 4;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x1 = Integer.parseInt(bufferedReader.readLine().trim());

        int y1 = Integer.parseInt(bufferedReader.readLine().trim());

        int x2 = Integer.parseInt(bufferedReader.readLine().trim());

        int y2 = Integer.parseInt(bufferedReader.readLine().trim());

        int x3 = Integer.parseInt(bufferedReader.readLine().trim());

        int y3 = Integer.parseInt(bufferedReader.readLine().trim());

        int xp = Integer.parseInt(bufferedReader.readLine().trim());

        int yp = Integer.parseInt(bufferedReader.readLine().trim());

        int xq = Integer.parseInt(bufferedReader.readLine().trim());

        int yq = Integer.parseInt(bufferedReader.readLine().trim());

        int result = PointsBelong.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

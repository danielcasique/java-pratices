package org.casique.PointsBelong;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointsBelongTest {

    @Test
    public void case0(){
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        int x3 = 4;
        int y3 = 0;
        int xp = 2;
        int yp = 0;
        int xq = 4;
        int yq = 0;

        int expectedResult = 0;
        assertEquals(expectedResult, PointsBelong.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq));
    }

    @Test
    public void case1(){
        int x1 = 3;
        int y1 = 1;
        int x2 = 7;
        int y2 = 1;
        int x3 = 5;
        int y3 = 5;
        int xp = 3;
        int yp = 1;
        int xq = 0;
        int yq = 0;

        int expectedResult = 1;
        assertEquals(expectedResult, PointsBelong.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq));
    }

    @Test
    public void case2(){
        int x1 = 3;
        int y1 = 1;
        int x2 = 7;
        int y2 = 1;
        int x3 = 5;
        int y3 = 5;
        int xp = 1;
        int yp = 1;
        int xq = 4;
        int yq = 3;

        int expectedResult = 2;
        assertEquals(expectedResult, PointsBelong.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq));
    }

    @Test
    public void case3(){
        int x1 = 3;
        int y1 = 1;
        int x2 = 7;
        int y2 = 1;
        int x3 = 5;
        int y3 = 5;
        int xp = 5;
        int yp = 2;
        int xq = 6;
        int yq = 3;

        int expectedResult = 3;
        assertEquals(expectedResult, PointsBelong.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq));
    }

    @Test
    public void case4(){
        int x1 = 3;
        int y1 = 1;
        int x2 = 7;
        int y2 = 1;
        int x3 = 5;
        int y3 = 5;
        int xp = 1;
        int yp = 1;
        int xq = 2;
        int yq = 2;

        int expectedResult = 4;
        assertEquals(expectedResult, PointsBelong.pointsBelong(x1, y1, x2, y2, x3, y3, xp, yp, xq, yq));
    }
}

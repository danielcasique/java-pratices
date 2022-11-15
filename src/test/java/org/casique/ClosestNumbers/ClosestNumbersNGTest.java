package org.casique.ClosestNumbers;

import org.casique.ClosestNumbers.ClosestNumbers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ClosestNumbersNGTest {


    @Test(groups = {"Test001"})
    public void case0(){
        String expectedResult = "1 2 2 3 3 4";
        List<Integer> input = List.of(4, 2, 1, 3);
        String result = ClosestNumbers.closestNumbersV3(input);
        Assert.assertEquals(expectedResult, result);
    }
}

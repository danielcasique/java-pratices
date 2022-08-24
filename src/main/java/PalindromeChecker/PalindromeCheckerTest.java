package PalindromeChecker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeCheckerTest {

    @Test
    public void case0(){
        String s = "bcba";
        List<Integer> startIndex = List.of(1,2,1);
        List<Integer> endIndex = List.of(3,3,1);
        List<Integer> subs = List.of(2,0,0);
        String expectedResult = "101";
        assertEquals(expectedResult, PalindromeChecker.palindromeChecker(s,startIndex,endIndex,subs));
    }

    @Test
    public void case1(){
        String s = "cbac";
        List<Integer> startIndex = List.of(0,2,1);
        List<Integer> endIndex = List.of(3,3,3);
        List<Integer> subs = List.of(0,2,2);
        String expectedResult = "011";
        assertEquals(expectedResult, PalindromeChecker.palindromeChecker(s,startIndex,endIndex,subs));
    }

    @Test
    public void case2(){
        String s = "bcbab";
        List<Integer> startIndex = List.of(1,1,2);
        List<Integer> endIndex = List.of(4,3,3);
        List<Integer> subs = List.of(3,3,0);
        String expectedResult = "110";
        assertEquals(expectedResult, PalindromeChecker.palindromeChecker(s,startIndex,endIndex,subs));
    }

    @Test
    public void case3(){
        String s = "bcbab";
        List<Integer> startIndex = List.of(1,1,2);
        List<Integer> endIndex = List.of(4,3,3);
        List<Integer> subs = List.of(3,3,0);
        String expectedResult = "110";
        assertEquals(expectedResult, PalindromeChecker.palindromeChecker(s,startIndex,endIndex,subs));
    }

    @Test
    public void case4(){
        String s = "cdecd";
        List<Integer> startIndex = List.of(0,0,0,0);
        List<Integer> endIndex = List.of(0,1,2,3);
        List<Integer> subs = List.of(0,1,1,0);
        String expectedResult = "1110";
        assertEquals(expectedResult, PalindromeChecker.palindromeChecker(s,startIndex,endIndex,subs));
    }

    @Test
    public void case5(){
        String s = "xxdnssuqevu";
        List<Integer> startIndex = List.of(0);
        List<Integer> endIndex = List.of(10);
        List<Integer> subs = List.of(3);
        String expectedResult = "1";
        assertEquals(expectedResult, PalindromeChecker.palindromeChecker(s,startIndex,endIndex,subs));
    }

}

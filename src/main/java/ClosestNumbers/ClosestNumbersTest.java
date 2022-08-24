package ClosestNumbers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestNumbersTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
        public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void case0(){
        String expectedResult = "1 2\r\n2 3\r\n3 4";
        List<Integer> input = List.of(4, 2, 1, 3);
        outputStreamCaptor.reset();
        ClosestNumbers.closestNumbersV2(input);
        assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }

    @Test
    public void case1(){
        String expectedResult = "-2 -1\r\n3 4";
        List<Integer> input = List.of(4, -2, -1, 3);
        outputStreamCaptor.reset();
        ClosestNumbers.closestNumbersV2(input);
        assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }
}

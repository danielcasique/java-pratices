package ClosestNumbers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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
    public void testClosestNumbers(){
        List<List<Integer>> list = List.of(List.of(4, 2, 1, 3), List.of(4, -2, -1, 3));
        List<String> result = List.of("1 2\r\n2 3\r\n3 4\r\n","-2 -1\r\n3 4\r\n");

        for(int i=0; i<list.size(); i++){
            outputStreamCaptor.reset();
            ClosestNumbers.closestNumbersV2(list.get(i));
            assertEquals(result.get(i).trim(), outputStreamCaptor.toString().trim());
        }
    }
}

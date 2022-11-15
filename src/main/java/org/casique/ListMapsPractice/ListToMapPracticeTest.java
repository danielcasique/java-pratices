package org.casique.ListMapsPractice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ListToMapPracticeTest {

    @Test
    public void testGetMapBySize(){
        Map<Integer, List<String>> expectedResult = Map.of(1, List.of("a"),
                2, List.of("bb", "cc"),
                3, List.of("ddd"));
        List<String> list = List.of("a", "bb", "cc", "ddd");
        Map<Integer, List<String>> result = ListToMapPractice.getMapBySize(list);
        assertEquals(expectedResult, result);
    }
}

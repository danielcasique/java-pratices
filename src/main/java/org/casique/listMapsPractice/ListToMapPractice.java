package org.casique.listMapsPractice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You have List of Strings:
 * List<String> strings = List.of("a", "bb", "cc", "ddd");
 * Create a method that return Map<Integer, List<String>> where key is count of characters and value is List of Strings where length of the each string corresponds to the size of a key (“a” = 1, “bb” = 2, “ccc” = 3)
 * Result of presented list should be:
 * 1:{“a”},
 * 2:{“bb”, “cc”},
 * 3:{“ddd”};
 */
public class ListToMapPractice {

    public static Map<Integer, List<String>> getMapBySize(List<String> list){
        if(Objects.isNull(list)) return null;
        /*
        Map<Integer, List<String>> result1 = new HashMap<>();
        for(String value: list){
            if(result1.containsKey(value.trim().length())){
                result1.get(value.trim().length()).add(value);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(value);
                result1.put(value.trim().length(), newList);
            }
        }
        return result1;*/
        Map<Integer, List<String>> result2 =  list
                .stream()
                .collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.toCollection(ArrayList::new)));
        return result2;
    }

}

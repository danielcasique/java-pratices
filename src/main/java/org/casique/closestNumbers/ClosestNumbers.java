package org.casique.closestNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ClosestNumbers {
    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */
    //Version 1
    public static void closestNumbers(List<Integer> numbers) {
        // Write your code here
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i=0; i<sortedList.size(); i++){
            for(int j=i+1; j<sortedList.size(); j++){
                Integer minusResult = Math.abs(sortedList.get(i) - sortedList.get(j));
                List<String> list;
                if(Objects.isNull(map.get(minusResult))){
                    list = new ArrayList<>();
                }else{
                    list = map.get(minusResult);
                }
                list.add(sortedList.get(i) + " " + sortedList.get(j));
                map.put(minusResult, list);
            }
        }

        Optional<Integer> min = map.keySet().stream().min(Integer::compare);

        if(min.isPresent()){
            map.get(min.get()).stream().forEach(System.out::println);
        }

    }

    public static void closestNumbersV2(List<Integer> numbers) {
        // Write your code here
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        Integer minimum = sortedList.get(1) - sortedList.get(0) ;
        List<String> result = new ArrayList<>();
        for(int i=0; i<sortedList.size()-1; i++){
                Integer minusResult = Math.abs(sortedList.get(i+1) - sortedList.get(i));
                if(minimum.compareTo(minusResult)==0){
                    result.add(sortedList.get(i) + " " + sortedList.get(i+1));
                }
        }
        result.stream().forEach(System.out::println);
    }

    public static String closestNumbersV3(List<Integer> numbers) {
        // Write your code here
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        Integer minimum = sortedList.get(1) - sortedList.get(0) ;
        List<String> result = new ArrayList<>();
        for(int i=0; i<sortedList.size()-1; i++){
            Integer minusResult = Math.abs(sortedList.get(i+1) - sortedList.get(i));
            if(minimum.compareTo(minusResult)==0){
                result.add(sortedList.get(i) + " " + sortedList.get(i+1));
            }
        }
        return result.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        ClosestNumbers.closestNumbers(numbers);

        bufferedReader.close();
    }
}

package org.casique.SalesByMatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalesByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> arMap = new HashMap<>();
        int totalPairs;
        for(int i : ar){
            if(arMap.containsKey(i)){
                int value = arMap.get(i) + 1;
                arMap.put(i, value);
            }else{
                arMap.put(i, 1);
            }
        }
        totalPairs = arMap.values().stream().mapToInt(integer -> integer / 2).sum();
        return totalPairs;
    }
}

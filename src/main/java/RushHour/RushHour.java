package RushHour;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RushHour {

    /**
     * Posible list of values for the list input
     *  2022-01-01T00:00:01
     */

    public static String getRushHour(List<String> list){
        Optional<Map.Entry<String, Long>> result = list.parallelStream().map(x -> x.substring(11,13))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .parallelStream()
                .max((Map.Entry<String, Long> v1, Map.Entry<String, Long> v2) -> v1.getValue().compareTo(v2.getValue()));
        //Comparator.comparing(Map.Entry::getValue)
        return result.isPresent()? result.get().getKey() + " = " +  result.get().getValue() + " times": null;
    }

    public static void main(String[] args) {
        List<String> list = List.of("2022-01-01T00:00:01", "2022-01-01T01:00:01", "2022-01-01T02:00:01", "2022-01-01T01:00:01",
                "2022-01-01T03:00:01", "2022-01-01T00:00:01", "2022-01-01T04:00:01", "2022-01-01T00:00:01",
                "2022-01-01T03:00:01", "2022-01-01T04:00:01", "2022-01-01T05:00:01", "2022-01-01T05:00:01",
                "2022-01-01T05:00:01", "2022-01-01T05:00:01", "2022-01-01T05:00:01", "2022-01-01T05:00:01");
        System.out.println(RushHour.getRushHour(list));
    }
}

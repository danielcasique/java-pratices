package activeTraders;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ActiveTraders {

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     */

    private class TradersStats{
        int trades;
        int totalCustomers;

        public TradersStats(int trades, int totalCustomers){
            this.trades = trades;
            this.totalCustomers = totalCustomers;
        }

        public void setTrades(int trades){
            this.trades = trades;
        }

        public int getTrades(){
            return trades;
        }

        public float calculateStats(){
            return trades / totalCustomers;
        }
    }

    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        Map<String, Long> counted = customers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //5%
        float umbral = customers.size() * (0.05f);
        List<String> results = counted.entrySet().stream()
                .filter(x -> x.getValue() >= umbral)
                .map(x -> x.getKey())
                .collect(Collectors.toList());
        results.sort(String.CASE_INSENSITIVE_ORDER);
        return results;
    }

    public static void main(String[] args) {
        List<String> customers = Arrays.asList("Omega", "Alpha", "Omega", "Alpha", "Omega",
                "Alpha", "Omega", "Alpha", "Omega", "Alpha",
                "Omega", "Alpha", "Omega", "Alpha", "Omega",
                "Alpha", "Omega", "Alpha", "Omega", "Beta");
        System.out.println(ActiveTraders.mostActive(customers));
    }
}

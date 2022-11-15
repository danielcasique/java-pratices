package org.casique.RushHour;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RushHour {

    /**
     * Posible list of values for the list input
     *  2022-01-01T00:00:01
     */

    /*
    private List<DepositEntry> getDepositsByCreditCardAndCisPeriod(List<DepositEntry> succeededDeposits,
                                                                   List<RequisitesItem> requisites) {

        //Map <String> creditCardRequisites =	getCreditCardRequisites(requisites).collect(Collectors.toMap(x, Function.identity()));

        Set<String> creditCardRequisitesSet = getCreditCardRequisites(requisites);
        return succeededDeposits.stream()
                .filter(item -> item.getCreated().isAfter(LocalDateTime.now().minusDays(30)))
                .filter(item -> Objects.nonNull(creditCardRequisitesSet.contains(item.getRequisiteId())))
                .collect(Collectors.toList());
        //creditCardRequisites.contains(item.getRequisiteId())
    }

    private Set <String> getCreditCardRequisites(List<RequisitesItem> requisites) {
        return requisites.stream()
                .filter(requisite -> CREDIT_CARD.equalsIgnoreCase(requisite.getMethod()))
                .map(RequisitesItem::getId)
                .collect(Collectors.toSet());
    }*/
    /**
    succededDeposits : 100 items
    requisites: 50 items
    Iterations: 100 * 50 = 5000   => 150
     **/

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

package org.casique.commonStrings;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonStrings {

    public static void commonSubstring(List<String> a, List<String> b) {

        for(int i=0; i<a.size(); i++){
            Set<Character> setA = new TreeSet<Character>();
            for(int j = 0; j < a.get(i).length(); j++) {
                setA.add(a.get(i).charAt(j));
            }
            Set<Character> setB = new TreeSet<Character>();
            for(int j = 0; j < b.get(i).length(); j++) {
                setB.add(b.get(i).charAt(j));
            }
            setA.retainAll(setB);
            System.out.println(setA.size()>0? "YES" : "NO");
        }

        /*List<List<Character>> listA = a.parallelStream().map(x -> x.chars().mapToObj(e -> (char)e).collect(Collectors.toList())).collect(Collectors.toList());
        List<List<Character>> listB = b.parallelStream().map(x -> x.chars().mapToObj(e -> (char)e).collect(Collectors.toList())).collect(Collectors.toList());
        IntStream stream = IntStream.range(0, a.size());
        List<String> result = stream.parallel()
                .mapToObj( i -> {
                    listA.get(i).retainAll(listB.get(i));
                    return listA.get(i).size() > 0 ? "YES" : "NO";
                })
                .collect(Collectors.toList());
        result.stream().forEach(System.out::println);*/
        /*
        List<String> result =
                IntStream.range(0, a.size())
                        .mapToObj(i -> {
                            List<Character> listA = a.get(i).chars().mapToObj(e -> (char)e ).collect(Collectors.toList());
                            List<Character> listB = b.get(i).chars().mapToObj(e -> (char)e ).collect(Collectors.toList());
                            listA.retainAll(listB);
                            if(listA.size()>0){
                                return "YES";
                            }else{
                                return "NO";
                            }
                        })
                        .collect(Collectors.toList());

        result.stream().forEach(System.out::println);
    */
        /*
        List<List<Character>> listA = a.parallelStream().map(x -> x.chars().mapToObj(e -> (char)e).collect(Collectors.toList())).collect(Collectors.toList());
        List<List<Character>> listB = b.parallelStream().map(x -> x.chars().mapToObj(e -> (char)e).collect(Collectors.toList())).collect(Collectors.toList());
        for(int i=0; i<listA.size(); i++){
            listA.get(i).retainAll(listB.get(i));
            if(listA.get(i).size()>0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        */

        /*
        for(int i=0; i<a.size(); i++){
            List<Character> listA = a.get(i).chars().mapToObj(e -> (char)e ).collect(Collectors.toList());
            List<Character> listB = b.get(i).chars().mapToObj(e -> (char)e ).collect(Collectors.toList());
            listA.retainAll(listB);
            if(listA.size()>0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }*/
    }

    public static void main(String ...args){
        List<String> a = List.of("hello","hi");
        List<String> b = List.of("world","by");

        CommonStrings.commonSubstring(a, b);

    }
}

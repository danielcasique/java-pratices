package DistinctCharactersCount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * Create the Filter and Mapper classes here.
 */

class Filter{
    public static Predicate<String> nameStartingWithPrefix(String prefix){
        return (String s) -> s.startsWith(prefix);
    }
}

class Mapper implements Function<String, CharactersCount> {

    @Override
    public CharactersCount apply(String s) {
        return null;
    }

    public static CharactersCount getDistinctCharactersCount(String s) {
        return new CharactersCount(s, (int) Arrays.stream(s.split("")).distinct().count());
    }
}

class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

public class DistinctCharactersCount {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );

        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(new Function<String, CharactersCount>() {
                    @Override
                    public CharactersCount apply(String s) {
                        return new CharactersCount(s, (int) Arrays.stream(s.split("")).distinct().count());
                    }
                })
                .forEachOrdered(System.out::println);
    }
}
//Mapper.getDistinctCharactersCount()

/*
new Function<String, CharactersCount>() {
                    @Override
                    public CharactersCount apply(String s) {
                        return new CharactersCount(s, (int) Arrays.stream(s.split("")).distinct().count());
                    }
                }
 */

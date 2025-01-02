package org.example.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExercises2 {

    public static int findMaxValue(List<Integer> numbers) {
        // Implement this method to return the maximum value in the list
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        return max.orElse(Integer.MIN_VALUE);
    }

    public static <T> T findFirstMatch(List<T> items, Predicate<T> condition) {
        // Implement this method to return the first item that matches the condition
        Optional<T> first = items.stream().filter(condition).findFirst();
        return first.orElse(null);
    }


    public static List<Integer> reverseList(List<Integer> numbers) {
        // Implement this method to return the reversed list
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public static List<String> filterStringsByLength(List<String> strings, int n) {
        Predicate<String> lengthGreaterThanOrEqualToN = str -> str.length() >= n;
        return strings.stream()
                .filter(lengthGreaterThanOrEqualToN)
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return  strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, List<String>> groupByFirstLetter(List<String> words) {
        // Implement this method
        return words.stream().collect(Collectors.groupingBy(s -> String.valueOf(s.charAt(0))));
    }

}

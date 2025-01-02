package org.example.exercises;

import java.util.Comparator;
import java.util.function.Predicate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaExercises {

    public interface Adder {
        int add(int a, int b);
    }

    public interface Multiplier {
        int multiply(int a, int b);
    }

    public static Adder createAdder() {
        // Implement this method
        return (Integer::sum);
    }

    public static List<String> filterByStartingLetter(List<String> names, String letter) {
        // Implement this method
        return names.stream().filter(name -> name.startsWith(letter)).collect(Collectors.toList());
    }

    public static List<Integer> sortDescending(List<Integer> numbers) {
        // Implement this method
        return numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<String> toUpperCaseList(List<String> words) {
        // Implement this method
        return words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static List<Integer> filterWithPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        // Implement this method
        return numbers.stream().filter(predicate).collect(Collectors.toList());
    }

    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        // Implement this method
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static Multiplier createMultiplier() {
        // Implement this method
        return ((a, b) -> a*b);
    }

    public static int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        // Implement this method
//        return numbers.stream()
//                .filter(num -> num % 2 == 0)
//                .map(num -> num * num)
//                .mapToInt(Integer::intValue)
//                .sum();
        return numbers.stream()
                .filter(num -> num % 2 ==0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);
    }

    public static int factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (a,b) -> a*b);
    }
}

package org.example.exercises;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExercise3 {

    public static Map<Integer, Long> countOccurrences(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    }


    public static List<String> removeDuplicates(List<String> strings) {
        return strings.stream().distinct().toList();
    }

    public static Optional<Object> findFirstVowel(List<String> noVowelStrings) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'y');
        Predicate<String> charZero = s -> !s.isEmpty() && vowels.contains(s.charAt(0));
        return noVowelStrings.stream().filter(charZero).findFirst().map(Object.class::cast);
    }

    public static List<String> filterLongStrings(List<String> strings) {
        int maxLength = strings.stream().mapToInt(String::length).max().orElse(0);
        return strings.stream()
                .filter(s -> s.length() == maxLength)
                .collect(Collectors.toList());
    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        return numbers.stream().filter(isEven).reduce(0, Integer::sum);
    }

    public static List<Integer> stringLengths(List<String> strings) {
        return null;
    }

    public static boolean allEven(List<Integer> evenNumbers) {
        if (evenNumbers.isEmpty()) {
            return false;
        } else {
//            Predicate<Integer> isEven = n -> n % 2 == 0;
//            List<Integer> evenList = evenNumbers.stream().filter(isEven).toList();
//            return evenList.size() == evenNumbers.size();
            return  evenNumbers.stream().allMatch(n -> n % 2 == 0);
        }
    }
}

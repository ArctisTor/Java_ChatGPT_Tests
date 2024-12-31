package lambda_exercises.simple.exercise3;


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
        return null;
    }

    public static Optional<Object> findFirstVowel(List<String> noVowelStrings) {
        return null;
    }

    public static List<String> filterLongStrings(List<String> strings) {
        return null;
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

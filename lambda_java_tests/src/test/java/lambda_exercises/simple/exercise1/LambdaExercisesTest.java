package lambda_exercises.simple.exercise1;

import org.example.exercises.LambdaExercises;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExercisesTest {

    @Test
    void testAdder() {
        LambdaExercises.Adder adder = LambdaExercises.createAdder();
        assertEquals(8, adder.add(5, 3));
        assertEquals(15, adder.add(7, 8));
    }

    @Test
    void testFilterByStartingLetter() {
        List<String> names = Arrays.asList("Java", "Lambda", "JavaScript", "Python");
        List<String> result = LambdaExercises.filterByStartingLetter(names, "J");
        assertEquals(Arrays.asList("Java", "JavaScript"), result);
    }

    @Test
    void testSortDescending() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        List<Integer> result = LambdaExercises.sortDescending(numbers);
        assertEquals(Arrays.asList(9, 5, 4, 3, 1, 1), result);
    }

    @Test
    void testToUpperCaseList() {
        List<String> words = Arrays.asList("java", "lambda", "stream");
        List<String> result = LambdaExercises.toUpperCaseList(words);
        assertEquals(Arrays.asList("JAVA", "LAMBDA", "STREAM"), result);
    }

    @Test
    void testFilterWithPredicate() {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 15, 7);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> greaterThanTen = num -> num > 10;
        List<Integer> result = LambdaExercises.filterWithPredicate(numbers, isEven.and(greaterThanTen));
        assertEquals(Arrays.asList(12, 20), result);
    }

    @Test
    void testGroupByLength() {
        List<String> words = Arrays.asList("Java", "Lambda", "Stream", "API");
        Map<Integer, List<String>> result = LambdaExercises.groupByLength(words);
        assertEquals(Arrays.asList("API"), result.get(3));
        assertEquals(Arrays.asList("Java"), result.get(4));
        assertEquals(Arrays.asList("Lambda", "Stream"), result.get(6));
    }

    @Test
    void testMultiplier() {
        LambdaExercises.Multiplier multiplier = LambdaExercises.createMultiplier();
        assertEquals(20, multiplier.multiply(4, 5));
        assertEquals(50, multiplier.multiply(10, 5));
    }

    @Test
    void testSumOfSquaresOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 8, 3, 7);
        int result = LambdaExercises.sumOfSquaresOfEvenNumbers(numbers);
        assertEquals(104, result); // 6*6 + 8*8
    }

    @Test
    void testFactorial() {
        assertEquals(120, LambdaExercises.factorial(5)); // 5 * 4 * 3 * 2 * 1
        assertEquals(1, LambdaExercises.factorial(0));  // 0! = 1
    }
}


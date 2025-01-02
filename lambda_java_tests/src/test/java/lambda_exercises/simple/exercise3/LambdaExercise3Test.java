package lambda_exercises.simple.exercise3;

import org.example.exercises.LambdaExercise3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LambdaExercise3Test {

    @Test
    void testCountOccurrences() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        Map<Integer, Long> result = LambdaExercise3.countOccurrences(numbers);

        assertEquals(1, result.get(1));
        assertEquals(2, result.get(2));
        assertEquals(3, result.get(3));
        assertEquals(1, result.get(4));
    }

    @Test
    void testAllEven() {
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);
        List<Integer> mixedNumbers = Arrays.asList(1, 2, 4, 6, 8);

        assertTrue(LambdaExercise3.allEven(evenNumbers));
        assertFalse(LambdaExercise3.allEven(mixedNumbers));
    }


    @Test
    void testStringLengths() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<Integer> result = LambdaExercise3.stringLengths(strings);

        assertEquals(5, result.get(0));
        assertEquals(6, result.get(1));
        assertEquals(6, result.get(2));
    }

    @Test
    void testSumEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 8, 3, 7);

        assertEquals(16, LambdaExercise3.sumEvenNumbers(numbers));
    }

    @Test
    void testFilterLongStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "fig");
        List<String> result = LambdaExercise3.filterLongStrings(strings);

        assertEquals(2, result.size());
        assertTrue(result.contains("banana"));
        assertTrue(result.contains("cherry"));
    }

    @Test
    void testFindFirstVowel() {
        List<String> strings = Arrays.asList("cat", "apple", "banana", "orange");
        List<String> noVowelStrings = Arrays.asList("cat", "dog", "fish");

        assertTrue(LambdaExercise3.findFirstVowel(strings).isPresent());
        assertEquals("apple", LambdaExercise3.findFirstVowel(strings).get());

        assertFalse(LambdaExercise3.findFirstVowel(noVowelStrings).isPresent());
    }

    @Test
    void testRemoveDuplicates() {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        List<String> result = LambdaExercise3.removeDuplicates(strings);

        assertEquals(3, result.size());
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("banana"));
        assertTrue(result.contains("cherry"));
    }
}

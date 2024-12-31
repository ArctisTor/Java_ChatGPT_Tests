package lambda_exercises.simple.exercise2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LambdaExercises2Test {

    @Test
    void testFindMaxValue() {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 3, 8, 4);
        int result = LambdaExercises2.findMaxValue(numbers);
        assertEquals(8, result); // 8 is the maximum value in the list
    }

    @Test
    void testFindMaxValueSingleElement() {
        List<Integer> numbers = List.of(42);
        int result = LambdaExercises2.findMaxValue(numbers);
        assertEquals(42, result); // Only one element, so it's the max
    }

    @Test
    void testFindMaxValueEmptyList() {
        List<Integer> numbers = List.of();
        int result = LambdaExercises2.findMaxValue(numbers);
        assertEquals(Integer.MIN_VALUE, result); // In case of empty list, should return minimum value (or handle edge case in your code)
    }

    @Test
    void testFindFirstMatch() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        int result = LambdaExercises2.findFirstMatch(numbers, isEven);
        assertEquals(2, result); // The first even number in the list is 2
    }

    @Test
    void testFindFirstMatchNoMatch() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Integer result = LambdaExercises2.findFirstMatch(numbers, isEven);
        assertNull(result); // No even numbers, so it returns null
    }

    @Test
    void testFindFirstMatchEmptyList() {
        List<Integer> numbers = Arrays.asList();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Integer result = LambdaExercises2.findFirstMatch(numbers, isEven);
        assertNull(result); // Empty list, so it returns null
    }

    @Test
    void testReverseList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = LambdaExercises2.reverseList(numbers);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), result); // List should be reversed
    }

    @Test
    void testReverseListSingleElement() {
        List<Integer> numbers = List.of(42);
        List<Integer> result = LambdaExercises2.reverseList(numbers);
        assertEquals(List.of(42), result); // Single element list, so it's the same
    }

    @Test
    void testReverseListEmpty() {
        List<Integer> numbers = List.of();
        List<Integer> result = LambdaExercises2.reverseList(numbers);
        assertEquals(List.of(), result); // Empty list should remain empty
    }

    @Test
    void testFilterStringsByLength() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "grape");
        int lengthThreshold = 5;
        List<String> result = LambdaExercises2.filterStringsByLength(strings, lengthThreshold);
        assertEquals(Arrays.asList("apple", "banana"), result);
    }

    @Test
    void testSortByLength() {
        List<String> strings = Arrays.asList("apple", "kiwi", "banana", "grape");
        List<String> result = LambdaExercises2.sortByLength(strings);
        assertEquals(Arrays.asList("kiwi", "grape", "apple", "banana"), result);
    }

    @Test
    void testGroupByFirstLetter() {
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "cherry", "blueberry");
        Map<String, List<String>> result = LambdaExercises2.groupByFirstLetter(strings);

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("a", Arrays.asList("apple", "avocado"));
        expected.put("b", Arrays.asList("banana", "blueberry"));
        expected.put("c", List.of("cherry"));

        assertEquals(expected, result);
    }

}

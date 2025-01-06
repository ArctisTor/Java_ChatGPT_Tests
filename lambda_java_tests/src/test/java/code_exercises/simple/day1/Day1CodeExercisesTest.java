package code_exercises.simple.day1;

import org.code.exercises.simple.day1.Day1CodeExercise;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1CodeExercisesTest {


    @Test
    public void testFindPairWithSum_Found() {
        List<Integer> numbers = Arrays.asList(2, 7, 11, 15);
        int target = 9;
        List<Integer> result = Day1CodeExercise.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(2, 7), result);
    }

    @Test
    public void testFindPairWithSum_NotFound() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int target = 8;
        List<Integer> result = Day1CodeExercise.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(), result); // Empty list for no pair
    }

    @Test
    public void testFindPairWithSum_EmptyList() {
        List<Integer> numbers = Arrays.asList();
        int target = 5;
        List<Integer> result = Day1CodeExercise.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(), result); // Empty list for no pair
    }

    @Test
    public void testFindPairWithSum_SingleElement() {
        List<Integer> numbers = Arrays.asList(5);
        int target = 5;
        List<Integer> result = Day1CodeExercise.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(), result); // Single element, no pair
    }

    @Test
    public void testFindPairWithSum_NegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, 3, 4);
        int target = 2;
        List<Integer> result = Day1CodeExercise.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(-1, 3), result); // Pair that sums to 2
    }


    @Test
    void testCommonElementsWithOverlap() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> expected = Arrays.asList(3, 4, 5);
        assertEquals(expected, Day1CodeExercise.findCommonElements(list1, list2));
    }

    @Test
    void testNoCommonElements() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, Day1CodeExercise.findCommonElements(list1, list2));
    }

    @Test
    void testEmptyLists() {
        List<Integer> list1 = Collections.emptyList();
        List<Integer> list2 = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, Day1CodeExercise.findCommonElements(list1, list2));
    }

    @Test
    void testOneEmptyList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, Day1CodeExercise.findCommonElements(list1, list2));
    }

    @Test
    void testDuplicatesInInput() {
        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 2, 4, 4, 6);
        List<Integer> expected = Arrays.asList(2, 4);
        assertEquals(expected, Day1CodeExercise.findCommonElements(list1, list2));
    }

    @Test
    void testFilterAndTransformWithMatches() {
        List<String> names = Arrays.asList("Alice", "Anna", "Bob", "Amanda", "Charlie");
        char letter = 'A';
        List<String> expected = Arrays.asList("ALICE", "AMANDA", "ANNA");
        assertEquals(expected, Day1CodeExercise.filterAndTransformNames(names, letter));
    }

    @Test
    void testFilterAndTransformNoMatches() {
        List<String> names = Arrays.asList("Bob", "Charlie", "David");
        char letter = 'A';
        List<String> expected = Collections.emptyList();
        assertEquals(expected, Day1CodeExercise.filterAndTransformNames(names, letter));
    }

    @Test
    void testEmptyList() {
        List<String> names = Collections.emptyList();
        char letter = 'A';
        List<String> expected = Collections.emptyList();
        assertEquals(expected, Day1CodeExercise.filterAndTransformNames(names, letter));
    }

    @Test
    void testCaseInsensitiveFiltering() {
        List<String> names = Arrays.asList("alice", "ALAN", "Amanda", "bob");
        char letter = 'A';
        List<String> expected = Arrays.asList("ALAN", "ALICE", "AMANDA");
        assertEquals(expected, Day1CodeExercise.filterAndTransformNames(names, letter));
    }

    @Test
    void testFilterWithSpecialCharacters() {
        List<String> names = Arrays.asList("@Amanda", "#Alice", "Anna", "Bob");
        char letter = 'A';
        List<String> expected = Arrays.asList("ANNA");
        assertEquals(expected, Day1CodeExercise.filterAndTransformNames(names, letter));
    }
}

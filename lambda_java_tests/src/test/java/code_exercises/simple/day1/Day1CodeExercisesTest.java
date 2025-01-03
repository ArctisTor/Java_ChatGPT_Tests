package code_exercises.simple.day1;

import org.code.exercises.simple.day1.Day1CodeExerices;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1CodeExercisesTest {


    @Test
    public void testFindPairWithSum_Found() {
        List<Integer> numbers = Arrays.asList(2, 7, 11, 15);
        int target = 9;
        List<Integer> result = Day1CodeExerices.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(2, 7), result);
    }

    @Test
    public void testFindPairWithSum_NotFound() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int target = 8;
        List<Integer> result = Day1CodeExerices.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(), result); // Empty list for no pair
    }

    @Test
    public void testFindPairWithSum_EmptyList() {
        List<Integer> numbers = Arrays.asList();
        int target = 5;
        List<Integer> result = Day1CodeExerices.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(), result); // Empty list for no pair
    }

    @Test
    public void testFindPairWithSum_SingleElement() {
        List<Integer> numbers = Arrays.asList(5);
        int target = 5;
        List<Integer> result = Day1CodeExerices.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(), result); // Single element, no pair
    }

    @Test
    public void testFindPairWithSum_NegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, 3, 4);
        int target = 2;
        List<Integer> result = Day1CodeExerices.findPairWithSum(numbers, target);
        assertEquals(Arrays.asList(-1, 3), result); // Pair that sums to 2
    }
}

package org.example.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6JavaExercisesTest {

    @Test
    public void testWithUniqueCharacter() {
        assertEquals('w', Day6JavaExercises.firstNonRepeatingChar("swiss"));
    }

    @Test
    public void testWithAllRepeatingCharacters() {
        assertEquals(' ', Day6JavaExercises.firstNonRepeatingChar("aabbcc"));
    }

    @Test
    public void testWithEmptyString() {
        assertEquals(' ', Day6JavaExercises.firstNonRepeatingChar(""));
    }

    @Test
    public void testWithNonRepeatingCharacterAtStart() {
        assertEquals('u', Day6JavaExercises.firstNonRepeatingCharNoLambda("success"));
    }

    @Test
    public void testWithSingleCharacter() {
        assertEquals('x', Day6JavaExercises.firstNonRepeatingChar("x"));
    }

    @Test
    public void testWithMultipleNonRepeatingCharacters() {
        assertEquals('d', Day6JavaExercises.firstNonRepeatingChar("abcdabc"));
    }

    @Test
    public void testFindKthLargest1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        assertEquals(5, Day6JavaExercises.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargest2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        assertEquals(4, Day6JavaExercises.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestEdgeCase() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        assertEquals(5, Day6JavaExercises.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestSingleElement() {
        int[] nums = {10};
        int k = 1;
        assertEquals(10, Day6JavaExercises.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestLargeArray() {
        int[] nums = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int k = 500000;
        assertEquals(500001, Day6JavaExercises.findKthLargest(nums, k));
    }
}

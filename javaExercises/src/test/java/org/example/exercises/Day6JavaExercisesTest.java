package org.example.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6}; //[6,5,5,4,3,3,2,2,1]
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


    @Test
    void testSingleOccurrence() {
        String input = "hello";
        char x = 'h';
        assertEquals(1, Day6JavaExercises.occurrenceOfCharStringer(input, x));
    }

    @Test
    void testMultipleOccurrences() {
        String input = "banana";
        char x = 'a';
        assertEquals(3, Day6JavaExercises.occurrenceOfCharStringer(input, x));
    }

    @Test
    void testNoOccurrences() {
        String input = "apple";
        char x = 'z';
        assertEquals(0, Day6JavaExercises.occurrenceOfCharStringer(input, x));
    }

    @Test
    void testEmptyString() {
        String input = "";
        char x = 'a';
        assertEquals(0, Day6JavaExercises.occurrenceOfCharStringer(input, x));
    }

    @Test
    void testNullString() {
        String input = null;
        char x = 'a';
        assertThrows(NullPointerException.class, () -> {
            Day6JavaExercises.occurrenceOfCharStringer(input, x);
        });
    }

    @Test
    void testCaseSensitivity() {
        String input = "Hello";
        char x = 'h';
        assertEquals(0, Day6JavaExercises.occurrenceOfCharStringer(input, x));
    }

    @Test
    void testSpecialCharacters() {
        String input = "a!@#a$a%";
        char x = 'a';
        assertEquals(3, Day6JavaExercises.occurrenceOfCharStringer(input, x));
    }

}

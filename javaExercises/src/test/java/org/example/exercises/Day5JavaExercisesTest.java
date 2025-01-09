package org.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5JavaExercisesTest {

    @Test
    public void testExampleCase() {
        assertEquals("bcbbbbcccb", Day5JavaExercises.longestSubstringWithTwoDistinct("abcbbbbcccbdddadacb"));
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals("a", Day5JavaExercises.longestSubstringWithTwoDistinct("a"));
    }

    @Test
    public void testAllDistinctCharacters() {
        assertEquals("ab", Day5JavaExercises.longestSubstringWithTwoDistinct("abcdef"));
    }

    @Test
    public void testAllSameCharacters() {
        assertEquals("aaaa", Day5JavaExercises.longestSubstringWithTwoDistinct("aaaa"));
    }

    @Test
    public void testMixedCase() {
        assertEquals("cccccbbbbb", Day5JavaExercises.longestSubstringWithTwoDistinct("aacccccbbbbb"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", Day5JavaExercises.longestSubstringWithTwoDistinct(""));
    }

    @Test
    public void testLongestUniqueSubstring() {
        // Test case 1: Expected output is 3 ("abc")
        assertEquals(3, Day5JavaExercises.longestUniqueSubstring("abcabcbb"));

        // Test case 2: Expected output is 1 ("b")
        assertEquals(1, Day5JavaExercises.longestUniqueSubstring("bbbbb"));

        // Test case 3: Expected output is 3 ("wke")
        assertEquals(3, Day5JavaExercises.longestUniqueSubstring("pwwkew"));

        // Test case 4: Expected output is 0 (empty string)
        assertEquals(0, Day5JavaExercises.longestUniqueSubstring(""));

        // Test case 5: Expected output is 6 ("abcdef")
        assertEquals(6, Day5JavaExercises.longestUniqueSubstring("abcdef"));

        // Test case 6: Expected output is 3 ("abc")
        assertEquals(3, Day5JavaExercises.longestUniqueSubstring("abccba"));

        // Test case 7: Expected output is 4 ("abcd")
        assertEquals(4, Day5JavaExercises.longestUniqueSubstring("abcdabcda"));
    }

    @Test
    public void testFindAnagrams() {
        // Test case 1: Expected output is [0, 6]
        assertEquals(List.of(0, 6), Day5JavaExercises.findAnagrams("cbaebabacd", "abc"));

        // Test case 2: Expected output is [0, 1, 2]
        assertEquals(List.of(0, 1, 2), Day5JavaExercises.findAnagrams("abab", "ab"));

        // Test case 3: Expected output is [] (no anagrams)
        assertEquals(List.of(), Day5JavaExercises.findAnagrams("abcd", "xyz"));

        // Test case 4: Expected output is [0, 1]
        assertEquals(List.of(1), Day5JavaExercises.findAnagrams("aab", "ab"));

        // Test case 5: Edge case with empty strings. Expected output is []
        assertEquals(List.of(), Day5JavaExercises.findAnagrams("", "ab"));

        // Test case 6: Case where p is larger than s. Expected output is []
        assertEquals(List.of(), Day5JavaExercises.findAnagrams("a", "abc"));
    }

    @Test
    public void testPositiveNumbers() {
        assertEquals(9, Day5JavaExercises.maxSumSubarray(new int[]{2, 1, 5, 1, 3, 2}, 3),
                "The maximum sum of a subarray of size 3 is incorrect.");
    }

    @Test
    public void testIncreasingNumbers() {
        assertEquals(9, Day5JavaExercises.maxSumSubarray(new int[]{1, 2, 3, 4, 5}, 2),
                "The maximum sum of a subarray of size 2 is incorrect.");
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-6, Day5JavaExercises.maxSumSubarray(new int[]{-1, -2, -3, -4, -5}, 3),
                "The maximum sum of a subarray of size 3 with negative numbers is incorrect.");
    }

    @Test
    public void testEqualNumbers() {
        assertEquals(1, Day5JavaExercises.maxSumSubarray(new int[]{1, 1, 1, 1, 1}, 1),
                "The maximum sum of a subarray of size 1 is incorrect.");
    }

    @Test
    public void testSingleElementArray() {
        assertEquals(5, Day5JavaExercises.maxSumSubarray(new int[]{5}, 1),
                "The maximum sum of a single-element array is incorrect.");
    }

    @Test
    public void testKEqualsArrayLength() {
        assertEquals(10, Day5JavaExercises.maxSumSubarray(new int[]{2, 3, 5}, 3),
                "The maximum sum when k equals the array length is incorrect.");
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, Day5JavaExercises.maxSumSubarray(new int[]{}, 1),
                "The maximum sum for an empty array should be 0.");
    }

    @Test
    public void testInvalidK() {
        assertEquals(0, Day5JavaExercises.maxSumSubarray(new int[]{1, 2, 3}, 0),
                "The maximum sum for k=0 should be 0.");
    }
}

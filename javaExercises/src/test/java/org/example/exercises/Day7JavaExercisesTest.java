package org.example.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7JavaExercisesTest {

    @Test
    void testSlidingWindowMaximum() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, Day7JavaExercises.slidingWindowMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{11}, Day7JavaExercises.slidingWindowMaximum(new int[]{9, 11}, 2));
        assertArrayEquals(new int[]{4, 2, 12, 11, -5}, Day7JavaExercises.slidingWindowMaximum(new int[]{4, 2, 12, 11, -5}, 1));
        assertArrayEquals(new int[]{3, 3}, Day7JavaExercises.slidingWindowMaximum(new int[]{3, 3, 3}, 2));
        assertArrayEquals(new int[]{}, Day7JavaExercises.slidingWindowMaximum(new int[]{}, 1));
    }

    @Test
    void testEdgeCases_1() {
        assertArrayEquals(new int[]{-1}, Day7JavaExercises.slidingWindowMaximum(new int[]{-1}, 1));
        assertArrayEquals(new int[]{5, 5}, Day7JavaExercises.slidingWindowMaximum(new int[]{5, 5, 5}, 2));
    }

    @Test
    void testLengthOfLongestSubstring() {
        assertEquals(3, Day7JavaExercises.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, Day7JavaExercises.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, Day7JavaExercises.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, Day7JavaExercises.lengthOfLongestSubstring(""));
        assertEquals(5, Day7JavaExercises.lengthOfLongestSubstring("abcde"));
    }

    @Test
    void testEdgeCases() {
        assertEquals(2, Day7JavaExercises.lengthOfLongestSubstring("aab"));
        assertEquals(7, Day7JavaExercises.lengthOfLongestSubstring("abcdefg"));
        assertEquals(5, Day7JavaExercises.lengthOfLongestSubstring("abcddefgh"));
    }

    @Test
    void testMixedCase() {
        assertEquals(7, Day7JavaExercises.lengthOfLongestSubstring("aAbBcCd"));
        assertEquals(7, Day7JavaExercises.lengthOfLongestSubstring("AbCdEfG"));
    }
}

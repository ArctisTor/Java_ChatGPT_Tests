package code_exercises.simple.day2;

import org.code.exercises.simple.day2.Day2CodeExercise;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2CodeExerciseTest {

    @Test
    public void testCountVowels() {
        assertEquals(3, Day2CodeExercise.countVowels("Hello World!"));
        assertEquals(0, Day2CodeExercise.countVowels("bcd"));
        assertEquals(2, Day2CodeExercise.countVowels("Java"));
        assertEquals(11, Day2CodeExercise.countVowels("The quick brown fox jumps over the lazy dog"));
        assertEquals(0, Day2CodeExercise.countVowels("12345"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, Day2CodeExercise.countVowels(""));
    }

    @Test
    public void testOnlyVowels() {
        assertEquals(5, Day2CodeExercise.countVowels("aeiou"));
    }

    @Test
    public void testUppercaseVowels() {
        assertEquals(5, Day2CodeExercise.countVowels("AEIOU"));
    }

    @Test
    public void testSumEvenNumbers() {
        assertEquals(12, Day2CodeExercise.sumEvenNumbers(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(0, Day2CodeExercise.sumEvenNumbers(new int[]{1, 3, 5, 7, 9}));
        assertEquals(20, Day2CodeExercise.sumEvenNumbers(new int[]{2, 4, 6, 8}));
        assertEquals(6, Day2CodeExercise.sumEvenNumbers(new int[]{0, 1, 2, 3, 4}));
        assertEquals(0, Day2CodeExercise.sumEvenNumbers(new int[]{}));
    }

    @Test
    public void testArrayWithNoEvenNumbers() {
        assertEquals(0, Day2CodeExercise.sumEvenNumbers(new int[]{1, 3, 5}));
    }

    @Test
    public void testArrayWithAllEvenNumbers() {
        assertEquals(30, Day2CodeExercise.sumEvenNumbers(new int[]{2, 4, 6, 8, 10}));
    }

    @Test
    public void testSingleEvenNumber() {
        assertEquals(4, Day2CodeExercise.sumEvenNumbers(new int[]{4}));
    }

    @Test
    public void testSingleOddNumber() {
        assertEquals(0, Day2CodeExercise.sumEvenNumbers(new int[]{5}));
    }

    @Test
    public void testLongestSubstringWithoutRepeatingChars() {
        assertEquals("abc", Day2CodeExercise.longestSubstringWithoutRepeatingChars("abcabcbb"));
        assertEquals("b", Day2CodeExercise.longestSubstringWithoutRepeatingChars("bbbbb"));  // Corrected expected result
        assertEquals("wke", Day2CodeExercise.longestSubstringWithoutRepeatingChars("pwwkew"));
        assertEquals("a", Day2CodeExercise.longestSubstringWithoutRepeatingChars("a"));
        assertEquals("abc", Day2CodeExercise.longestSubstringWithoutRepeatingChars("abcabcabc"));
        assertEquals("", Day2CodeExercise.longestSubstringWithoutRepeatingChars(""));
        assertEquals("abcdef", Day2CodeExercise.longestSubstringWithoutRepeatingChars("abcdef"));
        assertEquals("a@b#c", Day2CodeExercise.longestSubstringWithoutRepeatingChars("a@b#ca@"));
    }



    @Test
    public void testEmptyString_1() {
        assertEquals("", Day2CodeExercise.longestSubstringWithoutRepeatingChars(""));
    }

    @Test
    public void testStringWithAllUniqueChars() {
        assertEquals("abcdef", Day2CodeExercise.longestSubstringWithoutRepeatingChars("abcdef"));
    }

    @Test
    public void testStringWithSingleRepeatingChar() {
        assertEquals("a", Day2CodeExercise.longestSubstringWithoutRepeatingChars("aaaa"));
    }

    @Test
    public void testStringWithMultipleSubstrings() {
        assertEquals("bca", Day2CodeExercise.longestSubstringWithoutRepeatingChars("abcabcabcba"));
    }

    @Test
    public void testCountAnagramPairs() {
        List<String> words1 = Arrays.asList("listen", "silent", "enlist", "hello", "world");
        assertEquals(3, Day2CodeExercise.countAnagramPairs(words1));  // "listen", "silent", "enlist" are anagram pairs

        List<String> words2 = Arrays.asList("abc", "cba", "bca", "xyz");
        assertEquals(3, Day2CodeExercise.countAnagramPairs(words2));  // "abc", "cba", "bca" are anagram pairs

        List<String> words3 = Arrays.asList("aaa", "aab", "aba", "abb");
        assertEquals(1, Day2CodeExercise.countAnagramPairs(words3));  // Only "aaa" and "aab" are anagrams

        List<String> words4 = Arrays.asList("dog", "god", "odg", "cat", "tac");
        assertEquals(4, Day2CodeExercise.countAnagramPairs(words4));  // 4 anagram pairs: "dog", "god", "odg", "cat", "tac"

        List<String> words5 = Arrays.asList("apple", "pale", "papel", "hello", "world");
        assertEquals(1, Day2CodeExercise.countAnagramPairs(words5));  // Only "apple" and "pale" are anagrams

        List<String> words6 = Arrays.asList("abc", "def", "ghi");
        assertEquals(0, Day2CodeExercise.countAnagramPairs(words6));  // No anagram pairs
    }

}

package org.example.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5JavaExercises {

    /*
    Write a Java method to find the longest substring in a given string that contains at most two distinct characters.
    If there are multiple substrings with the same length, return the first one that appears.
     */
    public static String longestSubstringWithTwoDistinct(String s) {
        int leftWindow = 0;
        int rightWindow = 0;
        String subString = "";
        String longestSubstring = "";

        while (rightWindow < s.length()) {
            rightWindow++;
            subString = s.substring(leftWindow, rightWindow);

            // If more than 2 distinct characters, shrink the window from the left
            while (hasMoreThan2DistinctCharacters(subString)) {
                leftWindow++;
                subString = s.substring(leftWindow, rightWindow);
            }

            // Check and update the longest substring
            if (subString.length() > longestSubstring.length()) {
                longestSubstring = subString;
            }
        }

        return longestSubstring;
    }

    /*
    Given a string s, find the length of the longest substring without repeating characters.
     */
    public static int longestUniqueSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int leftWindow = 0, rightWindow = 0;
        String longestUniqueSubstring = "";
        String subString;
        while(rightWindow < s.length()) {
            rightWindow++;
            subString = s.substring(leftWindow, rightWindow);
            while (!hasOnlyDistinctCharacters(subString)) {
                leftWindow++;
                subString = s.substring(leftWindow, rightWindow);
            }

            if (subString.length() > longestUniqueSubstring.length()) {
                longestUniqueSubstring = subString;
            }
        }
        return longestUniqueSubstring.length();
    }

    /*
    Given a string s and a string p, find all the starting indices of p's anagrams in s.
    The substring of s starting at any of these indices is an anagram of p.
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexPoints = new ArrayList<>();
        if (s.isEmpty() || (p.length() > s.length())) {
            return List.of();
        }
        int window = p.length();
        int cursor = 0;
        String subString;
        while ( (cursor+ window) <= s.length()) {
            subString = s.substring(cursor, (cursor + window));
            if (isAnagrams(subString, p)) {
                indexPoints.add(cursor);
            }
            cursor++;
        }
        return indexPoints;
    }

    /*
    Given an array of integers nums and an integer k, return the maximum sum of a contiguous subarray of size k.
     */
    public static int maxSumSubarray(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return 0;
        }
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        int sum;
        int maxSum = Integer.MIN_VALUE;
        for (int cursor = 0; (cursor + k) <= numsList.size(); cursor++) {
            sum = numsList.subList(cursor, (cursor + k)).stream().reduce(0, Integer::sum);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }


    private static boolean isAnagrams(String s, String pattern) {
        return (s.length() == pattern.length()) && (
                pattern.chars().allMatch(c -> s.indexOf(c) >= 0)
        );
    }


    private static boolean hasOnlyDistinctCharacters(String subString) {
        return subString.chars().distinct().count() == subString.length();
    }

    private static boolean hasMoreThan2DistinctCharacters(String subString) {
        return subString.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .count() > 2;
    }

}

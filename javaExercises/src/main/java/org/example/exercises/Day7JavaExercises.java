package org.example.exercises;

import java.util.*;

public class Day7JavaExercises {

    /*
        Write a method that takes an array of integers and a window size k,
         and returns an array of the maximum values for each sliding window of size k
         as it moves from left to right in the input array.
        The window slides one element at a time.
        Assume the input array has at least one element and 1 <= k <= nums.length.
        Optimize for performance.
     */
    public static int[] slidingWindowMaximum(int[] nums, int k) {
        List<Integer> sumList = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .toList();
        for (int cursor = 0; (cursor + k) <= numList.size(); cursor++) {
            int sum = numList.subList(cursor, (cursor + k))
                    .stream()
                    .max(Integer::compareTo)
                    .orElse(Integer.MIN_VALUE);
            sumList.add(sum);
        }
        return sumList.stream()
                .mapToInt(c -> c)
                .toArray();
    }

    /*
    Write a method that takes a string as input and
     returns the length of the longest substring that contains no repeating characters.
     A substring is a contiguous sequence of characters in a string.
     The method should handle both lowercase and uppercase letters as distinct characters.
     If the input string is empty, return 0.
     You may use a sliding window or any efficient approach.
     */
    public static int lengthOfLongestSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Map<String, Integer> subStringMap = new LinkedHashMap<>();
        String longestUniqueSubstring = "";
        int left = 0;
        int right = 0;
        String subString = "";
        while (right < input.length()) {
            right++;
            subString = input.substring(left, right);  // Substring from left to right (inclusive)
            boolean notAdded = false;
            while (!hasOnlyDistinctCharacters(subString)) {
                if (!notAdded) {
                    String tempString = input.substring(left, (right-1));
                    subStringMap.put(tempString, tempString.length());
                    notAdded = true;
                }
                left++;
                subString = input.substring(left, right);
            }

            if (subString.length() > longestUniqueSubstring.length()) {
                longestUniqueSubstring = subString;
            }
        }

        if (!subString.isEmpty() &&
                hasOnlyDistinctCharacters(subString) &&
                !subStringMap.containsKey(subString)) {
            subStringMap.put(subString, subString.length());
        }

        int longestLength = subStringMap.values().stream()
                .max(Integer::compareTo)
                .stream()
                .findFirst()
                .orElse(0);


        return longestUniqueSubstring.length();
    }

    private static boolean hasOnlyDistinctCharacters(String subString) {
        return subString.chars().distinct().count() == subString.length();
    }


}

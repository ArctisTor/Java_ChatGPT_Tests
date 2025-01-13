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

        // Track substrings and their lengths
        Map<String, Integer> subStringMap = new LinkedHashMap<>();
        int left = 0;
        int right = 0;

        // Sliding window: Iterate with right pointer expanding the window
        while (right < input.length()) {
            String subString = input.substring(left, right + 1);  // Substring from left to right (inclusive)
            int distinctLength = (int) subString.chars().distinct().count(); // Count distinct chars

            if (distinctLength != subString.length()) { // Found a duplicate
                String validSubstring = input.substring(left, right); // Valid substring without duplicate
                subStringMap.put(validSubstring, validSubstring.length());
                left++;
            } else {
                right++;
            }
        }

        if (left < input.length()) {
            String finalSubstring = input.substring(left, right);
            subStringMap.put(finalSubstring, finalSubstring.length());
        }

        return subStringMap.values().stream().max(Integer::compareTo).orElse(0);
    }


}

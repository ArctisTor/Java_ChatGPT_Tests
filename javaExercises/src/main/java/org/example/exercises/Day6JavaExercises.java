package org.example.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Day6JavaExercises {

    /*
    Write a method that takes a string as input and returns the first non-repeating character.
     A non-repeating character is one that appears only once in the string.
     If all characters repeat or the string is empty, return a space character ' '.
      You are expected to solve the problem efficiently, using time complexity of O(n).
     */
    public static char firstNonRepeatingChar(String input) {
        if (input.isEmpty()) {
            return  ' ';
        }

        Map<Character, Long> grouped = input.chars()
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(
                        c -> c, // Group by the character itself
                        LinkedHashMap::new,
                        Collectors.counting() // Count occurrences of each character
                ));
        for (Character c: grouped.keySet()) {
            int count = Math.toIntExact(grouped.get(c));
            if (count == 1) {
                return c;
            }
        }

        return ' ';
    }

    public static char firstNonRepeatingCharNoLambda(String input) {
        if (input.isEmpty()) {
         return  ' ';
        }

        //Have to use LinkedHashMap to maintain order
        Map<Character, Integer> grouped = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            grouped.compute(c, (_, value) -> value == null ? 1 : value + 1);
        }

        for (Character c: grouped.keySet()) {
            int counter = grouped.get(c);
            if (counter == 1) {
                return c;
            }
        }

        return ' ';
    }

    /*
    You are tasked with implementing a method that finds the k-th largest element in an unsorted array of integers.
    The method should return the element at the k-th largest position when the array is sorted in descending order.
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length || k <= 0) {
            throw new IllegalArgumentException("Bad method parameters.");
        }

        // Convert the primitive int array to a Stream of Integer
        Integer[] sortedInts = Arrays.stream(nums)          // Stream of primitive ints
                .boxed()                                    // Convert to Stream<Integer>
                .sorted(Comparator.reverseOrder())           // Sort in reverse (descending order)
                .toArray(Integer[]::new);                    // Collect into Integer[] array
        return sortedInts[k-1];
    }



}

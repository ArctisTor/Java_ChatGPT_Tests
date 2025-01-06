package org.example.exercises;

import java.util.Comparator;
import java.util.List;

public class Day3JavaExercises {

    /*
    Write a method that takes a list of integers and returns the second largest number in the list.
    If the list contains fewer than two unique numbers,
    the method should throw an IllegalArgumentException with a descriptive message.
    The solution should handle edge cases, such as lists with duplicate values or null/empty lists.
     */
    public static int findSecondLargest(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("with a descriptive message");
        }
        List<Integer> sortedList = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
        if (sortedList.size() < 2) {
            throw new IllegalArgumentException("with a descriptive message");
        }
        return sortedList.get(1);
    }

}

package org.example.exercises;

import java.util.ArrayList;
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

    /*
    Description: Write a method that takes two sorted lists of integers and merges them into a single sorted list.
    The resulting list should maintain the order and include all elements from both input lists.
    If either list is empty, return the other list as is.
    You are not allowed to use built-in methods like Collections.sort to sort the final list.
    You should merge them manually by iterating through the lists.
     */
    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> sortedList = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both lists and add the smaller element to the result list
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                sortedList.add(list1.get(i));
                i++;
            } else if (list2.get(j) < list1.get(i)) {
                sortedList.add(list2.get(j));
                j++;
            } else {
                sortedList.add(list1.get(i));
                sortedList.add(list2.get(j));
                i++;
                j++;
            }
        }

        if (i < list1.size()) {
            sortedList.addAll(list1.subList(i, list1.size()));
        }

        if (j < list2.size()) {
            sortedList.addAll(list2.subList(j, list2.size()));
        }

        return sortedList;
    }

    public static List<Integer> mergeBuiltInSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> combinedList = new ArrayList<>(list1);
        combinedList.addAll(list2);
        combinedList.sort(Comparator.naturalOrder());
        return combinedList;
    }


}

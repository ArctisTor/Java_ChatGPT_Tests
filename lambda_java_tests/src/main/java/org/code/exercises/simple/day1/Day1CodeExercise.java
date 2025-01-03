package org.code.exercises.simple.day1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1CodeExercise {

    /*
    Problem Statement: Write a method that takes a list of integers and returns the two numbers from the list that sum up to a target value.
    If no such pair exists, return an empty list. The method should have a time complexity of O(n).
     */
    public static List<Integer> findPairWithSum(List<Integer> numbers, int target) {
        if (numbers.isEmpty()) {
            return List.of();
        }
//        try {
//            for (int i = 0; i < numbers.size(); i++) {
//                for (int j = (i+1); j < numbers.size(); j++) {
//                    Integer iElement = numbers.get(i);
//                    Integer jElement = numbers.get(j);
//                    if (Integer.sum(iElement, jElement)  == target) {
//                        return List.of(iElement, jElement);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        Set<Integer> seen = new HashSet<>();
        for (Integer num: numbers) {
            int difference = target - num;
            if (seen.contains(difference)) {
                return List.of(difference, num);
            }
            seen.add(num);
        }

        return List.of();
    }

    /**
     * Finds the common elements between two lists of integers.
     *
     * @param list1 the first list of integers
     * @param list2 the second list of integers
     * @return a list of integers that are common to both lists, in sorted order
     */
    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        if (list1.isEmpty() || list2.isEmpty()) {
            return List.of();
        }

//        Set<Integer> unionSet = new HashSet<>();
//        for (Integer numList1: list1) {
//            if (list2.contains(numList1)) {
//                unionSet.add(numList1);
//            }
//        }
//
//        return unionSet.stream().sorted(Comparator.naturalOrder()).toList();

        Set<Integer> setList2 = new HashSet<>(list2);
        return list1.stream()
                .filter(setList2::contains)
                .sorted()
                .toList();
    }

    /**
     * Filters a list of strings to include only names that start with a given letter,
     * and transforms them into uppercase.
     *
     * @param names the list of names
     * @param letter the starting letter to filter names
     * @return a list of names that start with the given letter, converted to uppercase, sorted alphabetically
     */
    public static List<String> filterAndTransformNames(List<String> names, char letter) {
        if (names.isEmpty()) {
            return List.of();
        }
        return names.stream()
                .filter(name -> !name.isEmpty() && Character.toUpperCase(name.charAt(0)) == Character.toUpperCase(letter))
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .toList();
    }



}

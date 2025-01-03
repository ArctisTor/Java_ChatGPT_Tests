package org.code.exercises.simple.day1;

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

}

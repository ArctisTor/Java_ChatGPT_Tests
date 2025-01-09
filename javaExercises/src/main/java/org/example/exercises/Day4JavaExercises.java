package org.example.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Day4JavaExercises {

    /*
    Write a method that removes all duplicate characters from a
    string while preserving the order of the first occurrence of each character.
     */
    public static String removeDuplicates(String input) {
        List<Character> charList = input.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .toList();

        return charList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


}

package org.code.exercises.simple.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day2CodeExercise {

    /*
    Write a method that takes a string input and returns the number of vowels (a, e, i, o, u) present in the string.
     The string may contain both uppercase and lowercase letters, and you should count vowels regardless of case.
     Ignore non-alphabetic characters.
     */
    public static int countVowels(String input) {
        List<String> vowels = List.of("A", "a", "E", "e", "I", "i", "O", "o", "U", "u");
        return (int) input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> vowels.contains(String.valueOf(c)))
                .count();
    }

    /*
    Write a method that takes an array of integers numbers and returns the sum of all even numbers in the array.
    If there are no even numbers, return 0.
     */
    public static int sumEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    /*
    Write a method that takes a string input and returns the longest substring without repeating characters.
    If there are multiple substrings with the same length, return the one that appears first.
    The method should return the substring, not the length.
     */
    public static String longestSubstringWithoutRepeatingChars(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        Map<Integer, String> subStringMap = new HashMap<>();
        StringBuilder currentSubString = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (currentSubString.toString().contains(String.valueOf(c))) {
                subStringMap.put(currentSubString.length(), String.valueOf(currentSubString));
                currentSubString = new StringBuilder(); // or handle this differently based on your logic
            }
            currentSubString.append(c);
        }

        subStringMap.put(currentSubString.length(), String.valueOf(currentSubString));
        Integer lastKey = (Integer) subStringMap.keySet().toArray(new Object[0])[subStringMap.size() - 1];
        return subStringMap.get(lastKey);

    }


    /*
    Write a method that takes a list of words and returns the number of pairs of anagrams.
     Two words are considered anagrams if they can be rearranged to form each other (ignoring case).
     For example, "listen" and "silent" are anagrams.
     The method should return the count of unique pairs of anagrams in the list.
     */
    public static int countAnagramPairs(List<String> words) {

        Map<String, Integer> anagramCounter = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            anagramCounter.put(sorted, anagramCounter.getOrDefault(sorted, 0) + 1);
        }

        return anagramCounter.values()
                .stream()
                .filter(count -> count > 1)
                .map(count -> count == 2 ? 1 : count)
                .reduce(0, Integer::sum); // Directly sum up counts

//        anagramCounter.values() .stream()
//                .filter(count -> count > 1)
//                .mapToInt(count -> count * (count - 1) / 2) // Calculate pairs for each group
//                .sum(); // Sum the total pairs
    }



}

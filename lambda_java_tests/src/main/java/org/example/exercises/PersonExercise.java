package org.example.exercises;

import org.example.objects.Person;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonExercise {

    public static List<Person> filterByAge(List<Person> people, int i) {
        Predicate<Person> olderThanI = person -> person.getAge() > i;
        return people.stream().filter(olderThanI).toList();
    }

    public static List<Person> sortByAge(List<Person> people) {
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        return people.stream().sorted(ageComparator).toList();
    }

    public static List<String> mapToFullNames(List<Person> people) {
        return people.stream()
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .toList();
    }

    public static Map<Integer, List<Person>> groupByAge(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    public static boolean anyPersonHasAge(List<Person> people, int i) {
        Predicate<Person> hasAge = p -> p.getAge() == i;
        return people.stream().anyMatch(hasAge);
    }

    public static long countByAge(List<Person> people, int i) {
        return people.stream()
                .mapToInt(Person::getAge)
                .filter(age -> age == i)
                .count();
    }

    public static Person findOldestPerson(List<Person> people) {
        int oldestPersonAge = people.stream().mapToInt(Person::getAge).max().orElse(0);
        return people.stream().filter(p -> p.getAge() == oldestPersonAge).findFirst().orElse(null);
    }

    public static long countLastNamesStartingWith(List<Person> people, char letter) {
        return people.stream()
                .filter(person -> person.getLastName().startsWith(String.valueOf(letter)))
                .count();
    }

    public static Map<Integer, List<Person>> groupByFirstNameLength(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(person -> person.getFirstName().length()));
    }

    public static List<Integer> getDistinctAges(List<Person> people) {
        return people.stream()
                .mapToInt(Person::getAge)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean areAllOlderThan(List<Person> people, int age) {
        return people.stream().allMatch(p -> p.getAge() > age);
    }

    public static String sequenceOfNumbers(String sequence) {
        StringBuilder sequenceString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new StringReader(sequence))) {
            String line = reader.readLine(); // Read the entire sequence (only one line)
            if (line != null) {
                String[] numbers = line.split("\\s+");  // Split the input by whitespace

                int occurance = 1; // Start with 1 occurrence for the first number
                int targetNumber = Integer.parseInt(numbers[0]); // The first number in the sequence

                // Loop through the numbers starting from the second element
                for (int i = 1; i < numbers.length; i++) {
                    int num = Integer.parseInt(numbers[i]);

                    if (num == targetNumber) {
                        occurance++;  // Increment the occurrence if it's the same number
                    } else {
                        // Append the current count and number to the result
                        sequenceString.append(occurance).append(" ").append(targetNumber).append(" ");

                        // Update target number and reset occurrence
                        targetNumber = num;
                        occurance = 1;
                    }
                }

                // Append the final sequence (for the last group of numbers)
                sequenceString.append(occurance).append(" ").append(targetNumber);
            }
        }  catch (Exception e) {

        }
        return sequenceString.toString();
    }



}

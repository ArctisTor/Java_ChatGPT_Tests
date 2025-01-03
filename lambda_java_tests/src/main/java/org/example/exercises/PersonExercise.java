package org.example.exercises;

import org.example.objects.Person;

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

    public static double getAverageAge(List<Person> people) {
        return people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }



}

package org.example.exercises;

import org.example.objects.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
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
}

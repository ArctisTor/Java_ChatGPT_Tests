package lambda_exercises.simple.personExercise;

import org.example.exercises.PersonExercise;
import org.example.objects.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PersonExerciseTest {

    @Test
    public void testFilterByAge() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35),
                new Person("Bob", "Brown", 20)
        );

        List<Person> result = PersonExercise.filterByAge(people, 25);

        List<Person> expected = Arrays.asList(
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35)
        );

        assertEquals(expected, result);
    }

    @Test
    public void testSortByAge() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 20),
                new Person("Bob", "Brown", 35)
        );

        List<Person> result = PersonExercise.sortByAge(people);

        List<Person> expected = Arrays.asList(
                new Person("Alice", "Johnson", 20),
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Bob", "Brown", 35)
        );

        assertEquals(expected, result);
    }

    @Test
    public void testMapToFullNames() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35)
        );

        List<String> result = PersonExercise.mapToFullNames(people);

        List<String> expected = Arrays.asList(
                "John Doe",
                "Jane Smith",
                "Alice Johnson"
        );

        assertEquals(expected, result);
    }

    @Test
    public void testGroupByAge() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 25),
                new Person("Bob", "Brown", 30)
        );

        Map<Integer, List<Person>> result = PersonExercise.groupByAge(people);

        assertTrue(result.containsKey(25));
        assertTrue(result.containsKey(30));

        assertEquals(2, result.get(25).size());
        assertEquals(2, result.get(30).size());
    }

    @Test
    public void testAnyPersonHasAge() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35)
        );

        boolean result = PersonExercise.anyPersonHasAge(people, 30);

        assertTrue(result);
    }

    @Test
    public void testAnyPersonHasAge_NoMatch() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35)
        );

        boolean result = PersonExercise.anyPersonHasAge(people, 40);

        assertFalse(result);
    }


    @Test
    public void testCountByAge() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 25),
                new Person("Bob", "Brown", 30)
        );

        long count = PersonExercise.countByAge(people, 25);

        assertEquals(2, count);
    }

    @Test
    public void testFindOldestPerson() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 45),
                new Person("Alice", "Johnson", 30)
        );

        Person result = PersonExercise.findOldestPerson(people);

        assertEquals(new Person("Jane", "Smith", 45), result);
    }

    @Test
    public void testCountLastNamesStartingWith() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35),
                new Person("Bob", "Brown", 40)
        );

        long result = PersonExercise.countLastNamesStartingWith(people, 'S');

        assertEquals(1, result);
    }

    @Test
    public void testGroupByFirstNameLength() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35),
                new Person("Bob", "Brown", 40)
        );

        Map<Integer, List<Person>> result = PersonExercise.groupByFirstNameLength(people);

        assertTrue(result.containsKey(4)); // John and Jane
        assertTrue(result.containsKey(3)); // Bob
        assertTrue(result.containsKey(5)); // Alice

        assertEquals(2, result.get(4).size()); // John and Jane
        assertEquals(1, result.get(3).size()); // Bob
        assertEquals(1, result.get(5).size()); // Alice
    }

    @Test
    public void testGetDistinctAges() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 25),
                new Person("Bob", "Brown", 40)
        );

        List<Integer> result = PersonExercise.getDistinctAges(people);

        assertEquals(Arrays.asList(25, 30, 40), result);
    }


    @Test
    public void testAreAllOlderThan() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35)
        );

        boolean result = PersonExercise.areAllOlderThan(people, 20);
        assertTrue(result);

        boolean resultFalse = PersonExercise.areAllOlderThan(people, 30);
        assertFalse(resultFalse);
    }


    @Test
    public void testGetAverageAge() {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Alice", "Johnson", 35)
        );

        double result = PersonExercise.getAverageAge(people);

        assertEquals(30.0, result, 0.01);
    }
}

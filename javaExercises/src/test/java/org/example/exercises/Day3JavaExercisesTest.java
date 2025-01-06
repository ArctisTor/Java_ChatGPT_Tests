package org.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Day3JavaExercisesTest {


    @Test
    public void testFindSecondLargest_ValidInput() {
        assertEquals(8, Day3JavaExercises.findSecondLargest(Arrays.asList(10, 8, 6, 4, 2)));
        assertEquals(5, Day3JavaExercises.findSecondLargest(Arrays.asList(1, 2, 3, 4, 5, 5, 6)));
        assertEquals(9, Day3JavaExercises.findSecondLargest(Arrays.asList(10, 9)));
        assertEquals(3, Day3JavaExercises.findSecondLargest(Arrays.asList(4, 4, 4, 2, 3, 4)));
        assertEquals(3, Day3JavaExercises.findSecondLargest(Arrays.asList(4, 4, 4, 2, 3, 4))); // Second largest
        assertEquals(10, Day3JavaExercises.findSecondLargest(Arrays.asList(20, 10, 10, 5, 2))); // Second largest
        assertThrows(IllegalArgumentException.class, ()-> Day3JavaExercises.findSecondLargest(Arrays.asList(15, 15, 15, 15, 15, 15)));// Exception expected
    }

    @Test()
    public void testFindSecondLargest_EmptyList() {
        assertThrows(IllegalArgumentException.class, ()-> Day3JavaExercises.findSecondLargest(List.of()));
    }

    @Test()
    public void testFindSecondLargest_NullList() {
        assertThrows(IllegalArgumentException.class, ()-> Day3JavaExercises.findSecondLargest(null));
    }

    @Test()
    public void testFindSecondLargest_OnlyOneUniqueNumber() {
        assertThrows(IllegalArgumentException.class, ()-> Day3JavaExercises.findSecondLargest(Arrays.asList(5, 5, 5, 5)));
    }

    @Test
    public void testMergeSortedLists_BothNonEmpty() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(expected, Day3JavaExercises.mergeSortedLists(list1, list2));
    }

    @Test
    public void testMergeSortedLists_OneListEmpty() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Collections.emptyList();
        List<Integer> expected = Arrays.asList(1, 3, 5);
        assertEquals(expected, Day3JavaExercises.mergeSortedLists(list1, list2));
    }

    @Test
    public void testMergeSortedLists_BothEmpty() {
        List<Integer> list1 = Collections.emptyList();
        List<Integer> list2 = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, Day3JavaExercises.mergeSortedLists(list1, list2));
    }

    @Test
    public void testMergeSortedLists_WithDuplicates() {
        List<Integer> list1 = Arrays.asList(1, 2, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 2, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 2, 3, 4, 5);
        assertEquals(expected, Day3JavaExercises.mergeSortedLists(list1, list2));
    }

    @Test
    public void testMergeSortedLists_SingleElementLists() {
        List<Integer> list1 = Arrays.asList(1);
        List<Integer> list2 = Arrays.asList(2);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, Day3JavaExercises.mergeSortedLists(list1, list2));
    }

}

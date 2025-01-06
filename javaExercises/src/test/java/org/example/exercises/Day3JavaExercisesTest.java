package org.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

}

package org.example.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4JavaExercisesTest {

    @Test
    public void testRemoveDuplicates() {
        assertEquals("progamin", Day4JavaExercises.removeDuplicates("programming"));
        assertEquals("helo wrd", Day4JavaExercises.removeDuplicates("hello world"));
        assertEquals("abc", Day4JavaExercises.removeDuplicates("aabbcc"));
        assertEquals("", Day4JavaExercises.removeDuplicates(""));
        assertEquals("a", Day4JavaExercises.removeDuplicates("aaaaa"));
        assertEquals("abc", Day4JavaExercises.removeDuplicates("abcabcabc"));
    }
}

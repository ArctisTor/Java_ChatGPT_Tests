package org.fearless.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipherProblemTest {

    @Test
    public void testSimpleShift() {
        String correctText = "The quick brown fox";
        String testText = CipherProblem.cipherText("Ymj vznhp gwtbs ktc", "fox");
        assertEquals(correctText, testText);
    }

    @Test
    public void testAttackAtDawn() {
        String correctText = "Attack at Dawn";
        String testText = CipherProblem.cipherText("Nggnpx ng Qnja", "at");
        assertEquals(correctText, testText);
    }

    @Test
    public void testHelloWorld() {
        String correctText = "Hello, World!";
        String testText = CipherProblem.cipherText("Khoor, Zruog!", "World!");
        assertEquals(correctText, testText);
    }
}

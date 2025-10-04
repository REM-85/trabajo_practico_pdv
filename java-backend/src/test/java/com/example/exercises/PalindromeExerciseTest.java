package com.example.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeExerciseTest {

    private final PalindromeExercise exercise = new PalindromeExercise();

    @Test
    void detectsPalindromeIgnoringCaseAndSpaces() {
        assertTrue(exercise.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void detectsNonPalindrome() {
        assertFalse(exercise.isPalindrome("Hello"));
    }

    @Test
    void rejectsNullInput() {
        assertThrows(IllegalArgumentException.class, () -> exercise.isPalindrome(null));
    }
}

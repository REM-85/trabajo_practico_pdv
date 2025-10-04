package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyExerciseTest {

    private final WordFrequencyExercise exercise = new WordFrequencyExercise();

    @Test
    void countsWords() {
        Map<String, Long> result = exercise.countWordOccurrences("Hello hello world");
        assertEquals(2L, result.get("hello"));
        assertEquals(1L, result.get("world"));
    }

    @Test
    void handlesEmptyString() {
        Map<String, Long> result = exercise.countWordOccurrences("");
        assertTrue(result.isEmpty());
    }

    @Test
    void rejectsNullInput() {
        assertThrows(IllegalArgumentException.class, () -> exercise.countWordOccurrences(null));
    }
}

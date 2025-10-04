package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateFormattingExerciseTest {

    private final DateFormattingExercise exercise = new DateFormattingExercise();

    @Test
    void formatsValidDates() {
        List<String> output = exercise.formatDates(List.of("01/01/2024", "15/08/2023"));
        assertEquals(2, output.size());
        assertTrue(output.get(0).contains("Monday"));
    }

    @Test
    void rejectsInvalidDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> exercise.formatDates(List.of("2024-01-01")));
        assertTrue(exception.getMessage().contains("Invalid date format"));
    }

    @Test
    void rejectsNullList() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> exercise.formatDates(null));
        assertEquals("Date list cannot be null", exception.getMessage());
    }
}

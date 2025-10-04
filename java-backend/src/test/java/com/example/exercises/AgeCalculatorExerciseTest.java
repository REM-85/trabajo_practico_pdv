package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AgeCalculatorExerciseTest {

    private final AgeCalculatorExercise exercise = new AgeCalculatorExercise();

    @Test
    void calculatesAgesCorrectly() {
        Map<String, Integer> ages = exercise.calculateAges(
                Map.of("Test", LocalDate.of(2000, 1, 1)),
                LocalDate.of(2024, 1, 1));
        assertEquals(24, ages.get("Test"));
    }

    @Test
    void rejectsFutureBirthDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> exercise.calculateAges(Map.of("Future", LocalDate.now().plusDays(1)), LocalDate.now()));
        assertTrue(exception.getMessage().contains("cannot be in the future"));
    }

    @Test
    void rejectsNullInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> exercise.calculateAges(null, LocalDate.now()));
        assertEquals("Birth dates and reference date must not be null", exception.getMessage());
    }
}

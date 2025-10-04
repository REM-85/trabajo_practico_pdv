package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AverageCalculatorExerciseTest {

    private final AverageCalculatorExercise exercise = new AverageCalculatorExercise();

    @Test
    void calculatesAverage() {
        double average = exercise.average(List.of(2, 4, 6, 8));
        assertEquals(5.0, average);
    }

    @Test
    void rejectsEmptyList() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> exercise.average(List.of()));
        assertEquals("Numbers collection must not be empty", exception.getMessage());
    }

    @Test
    void rejectsNullEntry() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> exercise.average(List.of(1, null, 3)));
        assertEquals("Numbers collection cannot contain null values", exception.getMessage());
    }
}

package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterExerciseTest {

    private final TemperatureConverterExercise exercise = new TemperatureConverterExercise();

    @Test
    void convertsTemperatures() {
        List<Double> result = exercise.convertCelsiusToFahrenheit(List.of(0.0, 100.0));
        assertEquals(List.of(32.0, 212.0), result);
    }

    @Test
    void rejectsNullList() {
        assertThrows(IllegalArgumentException.class, () -> exercise.convertCelsiusToFahrenheit(null));
    }

    @Test
    void rejectsNullEntry() {
        assertThrows(IllegalArgumentException.class, () -> exercise.convertCelsiusToFahrenheit(List.of(0.0, null)));
    }
}

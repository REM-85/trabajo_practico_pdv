package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTrackerExerciseTest {

    private final InventoryTrackerExercise exercise = new InventoryTrackerExercise();

    @Test
    void mergesInventories() {
        Map<String, Integer> updated = exercise.applyRestock(
                Map.of("ItemA", 2),
                Map.of("ItemA", 3, "ItemB", 4));
        assertEquals(5, updated.get("ItemA"));
        assertEquals(4, updated.get("ItemB"));
    }

    @Test
    void removesZeroOrNegativeQuantities() {
        Map<String, Integer> updated = exercise.applyRestock(
                Map.of("ItemA", 0),
                Map.of());
        assertTrue(updated.isEmpty());
    }

    @Test
    void rejectsNegativeQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> exercise.applyRestock(Map.of(), Map.of("ItemA", -1)));
    }
}

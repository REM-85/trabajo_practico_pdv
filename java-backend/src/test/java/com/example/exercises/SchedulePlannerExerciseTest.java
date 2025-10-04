package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchedulePlannerExerciseTest {

    private final SchedulePlannerExercise exercise = new SchedulePlannerExercise();

    @Test
    void filtersAndSortsFutureEvents() {
        LocalDateTime base = LocalDateTime.of(2024, 1, 1, 10, 0);
        List<LocalDateTime> events = List.of(
                base.minusHours(1),
                base.plusHours(2),
                base.plusHours(1)
        );
        List<LocalDateTime> sorted = exercise.sortUpcomingEvents(events, base);
        assertEquals(2, sorted.size());
        assertEquals(base.plusHours(1), sorted.get(0));
        assertEquals(base.plusHours(2), sorted.get(1));
    }

    @Test
    void rejectsNullList() {
        LocalDateTime base = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () -> exercise.sortUpcomingEvents(null, base));
    }

    @Test
    void rejectsNullEventEntry() {
        LocalDateTime base = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () -> exercise.sortUpcomingEvents(List.of(base, null), base));
    }
}

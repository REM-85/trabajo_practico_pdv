package com.example.exercises;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class SchedulePlannerExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(SchedulePlannerExercise.class.getName());

    public List<LocalDateTime> sortUpcomingEvents(List<LocalDateTime> events, LocalDateTime from) {
        if (events == null || from == null) {
            throw new IllegalArgumentException("Events list and reference time must not be null");
        }
        List<LocalDateTime> filtered = new ArrayList<>();
        for (LocalDateTime event : events) {
            if (event == null) {
                throw new IllegalArgumentException("Event times must not be null");
            }
            if (!event.isBefore(from)) {
                filtered.add(event);
            }
        }
        filtered.sort(Comparator.naturalOrder());
        return filtered;
    }

    @Override
    public String getName() {
        return "Schedule Planner";
    }

    @Override
    public String run() {
        LocalDateTime base = LocalDateTime.now();
        List<LocalDateTime> events = List.of(
                base.minusDays(1),
                base.plusHours(3),
                base.plusDays(2),
                base.plusHours(1)
        );
        List<LocalDateTime> sorted = sortUpcomingEvents(events, base);
        LOGGER.info(() -> "Sorted " + sorted.size() + " upcoming events");
        StringBuilder builder = new StringBuilder();
        sorted.forEach(event -> builder.append(event).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}

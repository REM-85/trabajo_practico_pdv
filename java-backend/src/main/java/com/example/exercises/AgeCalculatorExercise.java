package com.example.exercises;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AgeCalculatorExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(AgeCalculatorExercise.class.getName());

    public Map<String, Integer> calculateAges(Map<String, LocalDate> birthDates, LocalDate referenceDate) {
        if (birthDates == null || referenceDate == null) {
            throw new IllegalArgumentException("Birth dates and reference date must not be null");
        }
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, LocalDate> entry : birthDates.entrySet()) {
            String name = entry.getKey();
            LocalDate birthDate = entry.getValue();
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Names must not be null or blank");
            }
            if (birthDate == null) {
                throw new IllegalArgumentException("Birth date for " + name + " must not be null");
            }
            if (birthDate.isAfter(referenceDate)) {
                throw new IllegalArgumentException("Birth date for " + name + " cannot be in the future");
            }
            int age = Period.between(birthDate, referenceDate).getYears();
            result.put(name, age);
        }
        return result;
    }

    @Override
    public String getName() {
        return "Age Calculator";
    }

    @Override
    public String run() {
        Map<String, LocalDate> birthDates = Map.of(
                "Alice", LocalDate.of(1990, 5, 12),
                "Bob", LocalDate.of(1985, 1, 30),
                "Clara", LocalDate.of(2000, 12, 1)
        );
        LocalDate referenceDate = LocalDate.now();
        Map<String, Integer> ages = calculateAges(birthDates, referenceDate);
        LOGGER.info(() -> "Calculated ages for " + ages.size() + " people");
        StringBuilder builder = new StringBuilder();
        ages.forEach((name, age) -> builder.append(name).append(": ").append(age).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}

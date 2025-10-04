package com.example.exercises;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.logging.Logger;

public class AverageCalculatorExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(AverageCalculatorExercise.class.getName());

    public <T extends Number> double average(Collection<T> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers collection must not be null");
        }
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Numbers collection must not be empty");
        }
        DoubleSummaryStatistics stats = numbers.stream()
                .map(number -> {
                    if (number == null) {
                        throw new IllegalArgumentException("Numbers collection cannot contain null values");
                    }
                    return number.doubleValue();
                })
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();
        return stats.getAverage();
    }

    @Override
    public String getName() {
        return "Average Calculator";
    }

    @Override
    public String run() {
        double value = average(java.util.List.of(4, 8, 15, 16, 23, 42));
        LOGGER.info(() -> String.format("Computed average: %.2f", value));
        return String.format("Average: %.2f", value);
    }
}

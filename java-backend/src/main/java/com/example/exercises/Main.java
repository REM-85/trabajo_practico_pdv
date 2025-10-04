package com.example.exercises;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ConsoleExercise> exercises = List.of(
                new DateFormattingExercise(),
                new AgeCalculatorExercise(),
                new AverageCalculatorExercise(),
                new PalindromeExercise(),
                new WordFrequencyExercise(),
                new TemperatureConverterExercise(),
                new InventoryTrackerExercise(),
                new SchedulePlannerExercise()
        );

        exercises.forEach(exercise -> {
            System.out.println("==== " + exercise.getName() + " ====");
            System.out.println(exercise.run());
            System.out.println();
        });
    }
}

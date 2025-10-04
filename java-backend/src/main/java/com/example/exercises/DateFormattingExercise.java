package com.example.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class DateFormattingExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(DateFormattingExercise.class.getName());
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("EEEE, MMMM d, uuuu", Locale.ENGLISH);

    public List<String> formatDates(List<String> inputs) {
        if (inputs == null) {
            throw new IllegalArgumentException("Date list cannot be null");
        }
        List<String> result = new ArrayList<>();
        for (String input : inputs) {
            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("Date values cannot be null or blank");
            }
            try {
                LocalDate parsed = LocalDate.parse(input.trim(), INPUT_FORMATTER);
                result.add(parsed.format(OUTPUT_FORMATTER));
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("Invalid date format: " + input, ex);
            }
        }
        return result;
    }

    @Override
    public String getName() {
        return "Date Formatting";
    }

    @Override
    public String run() {
        List<String> inputs = List.of("01/01/2024", "29/02/2024", "15/08/2023");
        List<String> formatted = formatDates(inputs);
        LOGGER.info(() -> "Formatted " + formatted.size() + " dates");
        return String.join(System.lineSeparator(), formatted);
    }
}

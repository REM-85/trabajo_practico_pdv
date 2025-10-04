package com.example.exercises;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordFrequencyExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(WordFrequencyExercise.class.getName());

    public Map<String, Long> countWordOccurrences(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null");
        }
        return Arrays.stream(text.split("\\W+"))
                .map(token -> token.toLowerCase(Locale.ROOT))
                .filter(token -> !token.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public String getName() {
        return "Word Frequency";
    }

    @Override
    public String run() {
        String sentence = "To be or not to be, that is the question";
        Map<String, Long> frequencies = countWordOccurrences(sentence);
        LOGGER.info(() -> "Counted " + frequencies.size() + " distinct words");
        return frequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

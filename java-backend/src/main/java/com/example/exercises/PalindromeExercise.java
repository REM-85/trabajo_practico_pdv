package com.example.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;
import java.util.logging.Logger;

public class PalindromeExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(PalindromeExercise.class.getName());

    public boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        String normalized = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        if (normalized.isEmpty()) {
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Palindrome Checker";
    }

    @Override
    public String run() {
        String sample = "Never odd or even";
        boolean palindrome = isPalindrome(sample);
        LOGGER.info(() -> "Checked palindrome for sample text");
        return String.format("\"%s\" is palindrome: %s", sample, palindrome);
    }
}

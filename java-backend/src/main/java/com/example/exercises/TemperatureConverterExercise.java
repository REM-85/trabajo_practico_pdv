package com.example.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TemperatureConverterExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(TemperatureConverterExercise.class.getName());

    public List<Double> convertCelsiusToFahrenheit(List<Double> celsiusValues) {
        if (celsiusValues == null) {
            throw new IllegalArgumentException("Temperature list must not be null");
        }
        List<Double> result = new ArrayList<>(celsiusValues.size());
        for (Double value : celsiusValues) {
            if (value == null) {
                throw new IllegalArgumentException("Temperature values must not be null");
            }
            result.add(value * 9 / 5 + 32);
        }
        return result;
    }

    @Override
    public String getName() {
        return "Temperature Converter";
    }

    @Override
    public String run() {
        List<Double> fahrenheit = convertCelsiusToFahrenheit(List.of(-10.0, 0.0, 21.5, 37.0));
        LOGGER.info(() -> "Converted " + fahrenheit.size() + " temperature values");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fahrenheit.size(); i++) {
            builder.append(String.format("Value %d: %.1f°F", i + 1, fahrenheit.get(i)))
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}

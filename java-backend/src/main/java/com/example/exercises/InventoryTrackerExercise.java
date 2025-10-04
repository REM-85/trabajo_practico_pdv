package com.example.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class InventoryTrackerExercise implements ConsoleExercise {
    private static final Logger LOGGER = Logger.getLogger(InventoryTrackerExercise.class.getName());

    public Map<String, Integer> applyRestock(Map<String, Integer> currentInventory, Map<String, Integer> restock) {
        if (currentInventory == null || restock == null) {
            throw new IllegalArgumentException("Inventory maps must not be null");
        }
        Map<String, Integer> updated = new LinkedHashMap<>(currentInventory);
        for (Map.Entry<String, Integer> entry : restock.entrySet()) {
            String item = entry.getKey();
            Integer quantity = entry.getValue();
            if (item == null || item.isBlank()) {
                throw new IllegalArgumentException("Item names must not be null or blank");
            }
            if (quantity == null || quantity < 0) {
                throw new IllegalArgumentException("Quantities must not be null or negative");
            }
            updated.merge(item, quantity, Integer::sum);
        }
        updated.values().removeIf(qty -> qty <= 0);
        return updated;
    }

    @Override
    public String getName() {
        return "Inventory Tracker";
    }

    @Override
    public String run() {
        Map<String, Integer> current = Map.of("Apples", 5, "Bananas", 0, "Oranges", 12);
        Map<String, Integer> restock = Map.of("Apples", 3, "Bananas", 7, "Pears", 4);
        Map<String, Integer> updated = applyRestock(current, restock);
        LOGGER.info(() -> "Updated inventory for " + updated.size() + " items");
        StringBuilder builder = new StringBuilder();
        updated.forEach((item, quantity) -> builder.append(item).append(": ").append(quantity).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}

package com.blendedlogic.spike.bdd;

/**
 * Simple calculator.
 */
public class SimpleCalculator {
    private int total;

    public SimpleCalculator() {
    }

    public void add(final int number) {
        total += number;
    }

    public int getTotal() {
        return total;
    }

    public void clear() {
        total = 0;
    }
}

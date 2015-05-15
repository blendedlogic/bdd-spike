package com.blendedlogic.spike.bdd.given;

import com.blendedlogic.spike.bdd.SimpleCalculator;

/**
 * Clear calculator given command.
 */
public class GivenAClearCalculator implements Given {
    private final SimpleCalculator calculator;

    private GivenAClearCalculator(final SimpleCalculator calculator) {
        this.calculator = calculator;
    }

    public static GivenAClearCalculator theCalculatorIsCleared(final SimpleCalculator calculator) {
        return new GivenAClearCalculator(calculator);
    }

    @Override
    public void execute() {
        calculator.clear();
    }
}

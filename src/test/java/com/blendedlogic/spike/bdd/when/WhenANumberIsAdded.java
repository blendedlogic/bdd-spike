package com.blendedlogic.spike.bdd.when;

import com.blendedlogic.spike.bdd.SimpleCalculator;

/**
 * .
 */
public class WhenANumberIsAdded implements When {
    private final SimpleCalculator calculator;
    private int number;

    private WhenANumberIsAdded(final SimpleCalculator calculator) {
        this.calculator = calculator;
    }

    public static WhenANumberIsAdded theCalculatorIsUsed(final SimpleCalculator calculator) {
        return new WhenANumberIsAdded(calculator);
    }

    public WhenANumberIsAdded andThisNumberIsAddedToTheTotal(final int number) {
        this.number = number;

        return this;
    }

    @Override
    public void execute() {
        calculator.add(number);
    }
}

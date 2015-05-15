package com.blendedlogic.spike.bdd.then;

import com.blendedlogic.spike.bdd.SimpleCalculator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 */
public class ThenTotalCheck implements Then {
    private final SimpleCalculator calculator;
    private int expectedTotal;

    private ThenTotalCheck(final SimpleCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        assertThat(calculator.getTotal(), is(equalTo(expectedTotal)));
    }

    public static ThenTotalCheck theCalculator(SimpleCalculator calculator) {
        return new ThenTotalCheck(calculator);
    }

    public ThenTotalCheck totalShouldBe(int expectedTotal) {
        this.expectedTotal = expectedTotal;

        return this;
    }
}

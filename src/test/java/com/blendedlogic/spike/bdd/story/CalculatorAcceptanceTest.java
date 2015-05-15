package com.blendedlogic.spike.bdd.story;

import com.blendedlogic.spike.bdd.SimpleCalculator;
import org.junit.Test;

import static com.blendedlogic.spike.bdd.given.GivenAClearCalculator.theCalculatorIsCleared;
import static com.blendedlogic.spike.bdd.given.GivenInvoker.given;
import static com.blendedlogic.spike.bdd.then.ThenInvoker.then;
import static com.blendedlogic.spike.bdd.then.ThenTotalCheck.theCalculator;
import static com.blendedlogic.spike.bdd.when.AndWhen.andWhen;
import static com.blendedlogic.spike.bdd.when.WhenANumberIsAdded.theCalculatorIsUsed;
import static com.blendedlogic.spike.bdd.when.WhenInvoker.when;

/**
 * Calculator acceptance tests.
 */
public class CalculatorAcceptanceTest {
    @Test
    public void clearAddAndCheckTotal() {
        final int number1 = 5;
        final int number2 = 7;
        final int expectedTotal = number1 + (number2 * 2);

        final SimpleCalculator calculator = new SimpleCalculator();

        given(
                theCalculatorIsCleared(calculator)
        );

        when(
                theCalculatorIsUsed(calculator)
                        .andThisNumberIsAddedToTheTotal(number1),

                andWhen(theCalculatorIsUsed(calculator)
                        .andThisNumberIsAddedToTheTotal(number2)),

                andWhen(theCalculatorIsUsed(calculator)
                        .andThisNumberIsAddedToTheTotal(number2))
        );

        then(
                theCalculator(calculator)
                        .totalShouldBe(expectedTotal)
        );
    }
}

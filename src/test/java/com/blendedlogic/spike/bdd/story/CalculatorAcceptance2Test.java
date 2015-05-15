package com.blendedlogic.spike.bdd.story;

import com.blendedlogic.spike.bdd.SimpleCalculator;
import com.blendedlogic.spike.bdd.given.Given;
import org.junit.Test;

import static com.blendedlogic.spike.bdd.given.GivenInvoker.given;
import static com.blendedlogic.spike.bdd.then.ThenInvoker.then;
import static com.blendedlogic.spike.bdd.then.ThenTotalCheck.theCalculator;
import static com.blendedlogic.spike.bdd.when.AndWhen.andWhen;
import static com.blendedlogic.spike.bdd.when.WhenANumberIsAdded.theCalculatorIsUsed;
import static com.blendedlogic.spike.bdd.when.WhenInvoker.when;

/**
 * Calculator acceptance tests.
 */
public class CalculatorAcceptance2Test {
    @Test
    public void clearAddAndCheckTotal() {
        final int number1 = 5;
        final int number2 = 7;
        final int expectedTotal = number1 + (number2 * 2);

        final SimpleCalculator calculator = new SimpleCalculator();

        given(
                new Given() {
                    @Override
                    public void execute() throws Exception {
                        calculator.clear();

                    }
                }
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

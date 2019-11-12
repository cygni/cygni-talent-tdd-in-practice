package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testNull() {
        assertThat(calculator.sumAll(null)).isEmpty();
    }

    @Test
    public void testEmpty() {
        assertThat(calculator.sumAll().get()).isEqualTo(0);
    }

    @Test
    public void testValues() {
        assertThat(calculator.sumAll(1,2).get()).isEqualTo(3);
    }


}
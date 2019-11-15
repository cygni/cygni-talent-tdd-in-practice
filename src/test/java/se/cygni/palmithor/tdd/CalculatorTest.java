package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll().get()).isEqualTo(0);
        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty());
        assertThat(calculator.sumAll(1, 2)).isEqualTo(Optional.of(3));
    }
}
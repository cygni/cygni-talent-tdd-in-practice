package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test()
    {
        assertThat(calculator.sumAll(1).get()).isEqualTo(1);
        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty());
        assertThat(calculator.sumAll().get()).isEqualTo(0);
        assertThat(calculator.sumAll(1, 2, 3).get()).isEqualTo(6);
        assertThat(calculator.sumAll(-1, -2, -3).get()).isEqualTo(-6);
        assertThat(calculator.sumAll(-1, null, -3).get()).isEqualTo(-4);
    }
}
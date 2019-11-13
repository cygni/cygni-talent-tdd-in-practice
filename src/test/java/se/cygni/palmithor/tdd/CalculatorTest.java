package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void sumAll() {
        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty());
        assertThat(calculator.sumAll()).isEqualTo(Optional.of(0));
        assertThat(calculator.sumAll(0, 1)).isEqualTo(Optional.of(1));
        assertThat(calculator.sumAll(-1, 1, 2, 3)).isEqualTo(Optional.of(5));
        assertThat(calculator.sumAll(null, 1, 2, null, 3)).isEqualTo(Optional.of(6));
        assertThat(calculator.sumAll(Integer.MAX_VALUE, 1)).isEqualTo(Optional.of(Integer.MIN_VALUE));
    }


}
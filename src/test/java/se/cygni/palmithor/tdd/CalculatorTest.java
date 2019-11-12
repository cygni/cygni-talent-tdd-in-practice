package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll()).isEqualTo(Optional.of(0));
        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty());
    }


}
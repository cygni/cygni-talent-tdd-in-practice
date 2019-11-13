package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll().get()).isEqualTo(0);
        assertThat(calculator.sumAll(null).isEmpty()).isTrue();
        assertThat(calculator.sumAll(1, null, 0, 3).get()).isEqualTo(4);
        assertThat(calculator.sumAll(1, 0, null, -5, -2).get()).isEqualTo(-6);

    }


}
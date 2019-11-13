package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll(1).get()).isEqualTo(1);
        assertThat(calculator.sumAll(1,3).get()).isEqualTo(4);
        assertThat(calculator.sumAll(5,5).get()).isNotEqualTo(9);
        assertThat(calculator.sumAll(null).isEmpty()).isTrue();
        assertThat(calculator.sumAll().get()).isEqualTo(0);
    }


}
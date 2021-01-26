package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll(0,1).get()).isEqualTo(1);
        assertThat(calculator.sumAll(null).isEmpty());
        assertThat(calculator.sumAll().get()).isEqualTo(0);
        assertThat(calculator.sumAll(2,5,3,1,-5).get()).isEqualTo(6);
    }


}
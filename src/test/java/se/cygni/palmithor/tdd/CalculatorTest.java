package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll(-1,2,3).get()).isEqualTo(4);
        assertThat(calculator.sumAll(1,2,3).get()).isEqualTo(6);
        // what should the program do if overflow
        assertThat(calculator.sumAll(Integer.MAX_VALUE, 1).get()).isEqualTo(-2147483648);
        assertThat(calculator.sumAll(null,1,2).get()).isEqualTo(3);
        assertThat(calculator.sumAll(0).get()).isEqualTo(0);
        assertThat(calculator.sumAll().get()).isEqualTo(0);
    }


}
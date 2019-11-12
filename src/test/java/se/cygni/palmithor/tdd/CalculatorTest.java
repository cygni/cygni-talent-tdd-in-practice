package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {

        assertThat(calculator.sumAll(1).get()).isEqualTo(1); // TODO failing on purpose please fix
        assertThat(calculator.sumAll(1,2,3,4).get()).isEqualTo(10);
        assertThat(calculator.sumAll(null).isEmpty()).isEqualTo(true);
        assertThat(calculator.sumAll().get()).isEqualTo(0);
    }


}
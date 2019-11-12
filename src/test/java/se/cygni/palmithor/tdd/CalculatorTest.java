package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll().get()).isEqualTo(0); // TODO failing on purpose please fix
        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty()); // TODO failing on purpose please fix
        assertThat(calculator.sumAll(1,2,3,4).get()).isEqualTo(10); // TODO failing on purpose please fix
        assertThat(calculator.sumAll(-1,2,-1).get()).isEqualTo(0); // TODO failing on purpose please fix
    }


}

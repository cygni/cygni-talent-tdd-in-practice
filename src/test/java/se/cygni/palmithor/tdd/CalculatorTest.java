package se.cygni.palmithor.tdd;


import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertThat(calculator.sumAll().get()).isEqualTo(0); // TODO failing on purpose please fix
        assertThat(calculator.sumAll(1)).isEqualTo(Optional.of(1));
        assertThat(calculator.sumAll(0, 0)).isEqualTo(Optional.of(0));
        assertThat(calculator.sumAll(1, 1)).isEqualTo(Optional.of(2));
        assertThat(calculator.sumAll(-1, 1)).isEqualTo(Optional.of(0));
        assertThat(calculator.sumAll(-1, -1)).isEqualTo(Optional.of(-2));
        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty());
    }


}

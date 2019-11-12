package se.cygni.palmithor.tdd;


import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testEmptyParamList() {

        assertThat(calculator.sumAll().get()).isEqualTo(0); // TODO failing on purpose please fix

    }

    @Test
    public void testNullParamList() {

        assertThat(calculator.sumAll(null)).isEqualTo(Optional.empty()); // TODO failing on purpose please fix

    }

    @Test
    public void testParamListWithOneParam() {

        assertThat(calculator.sumAll(5).get()).isEqualTo(5); // TODO failing on purpose please fix

    }

    @Test
    public void testParamListWithThreeParams() {

        assertThat(calculator.sumAll(5, 1, 2).get()).isEqualTo(8); // TODO failing on purpose please fix

    }

    @Test
    public void testParamListWithNegativeParam() {

        assertThat(calculator.sumAll(-5, -1, 3).get()).isEqualTo(-3); // TODO failing on purpose please fix

    }

    @Test
    public void testParamListWithIntegerParam() {

        assertThat(calculator.sumAll(Integer.parseInt("5")).get()).isEqualTo(5); // TODO failing on purpose please fix

    }
    @Test
    public void testParamListWithMaxIntParam() {

        assertThat(calculator.sumAll(Integer.MAX_VALUE).get()).isEqualTo(Integer.MAX_VALUE); // TODO failing on purpose please fix
    }

    @Test
    @Ignore
    public void testParamListWithParam() {

        assertThat(calculator.sumAll(Integer.MAX_VALUE, Integer.MAX_VALUE).get()).isEqualTo(Integer.MAX_VALUE); // TODO failing on purpose please fix

    }
}
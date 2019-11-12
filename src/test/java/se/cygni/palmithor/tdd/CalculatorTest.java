package se.cygni.palmithor.tdd;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
  public void test() {
    assertThat(calculator.sumAll(-1, -1).get()).isEqualTo(-2);
    assertThat(calculator.sumAll(1).get()).isEqualTo(1);
    assertThat(calculator.sumAll(1, 2).get()).isEqualTo(3);
    assertThat(calculator.sumAll(-1, 0).get()).isEqualTo(-1);
  }
}

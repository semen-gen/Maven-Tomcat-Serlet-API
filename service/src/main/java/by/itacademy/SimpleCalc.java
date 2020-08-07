package by.itacademy;

import java.math.BigDecimal;

public class SimpleCalc {

  public BigDecimal sum(BigDecimal a, BigDecimal b) {
    return a.add(b);
  }

  public BigDecimal minus(BigDecimal a, BigDecimal b) {
    return a.add(b.negate());
  }

  public BigDecimal mul(BigDecimal a, BigDecimal b) {
    return a.multiply(b);
  }

  public BigDecimal div(BigDecimal a, BigDecimal b) {
    return a.divide(b);
  }

}

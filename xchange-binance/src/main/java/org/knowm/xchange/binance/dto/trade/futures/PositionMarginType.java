package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PositionMarginType {
  ADD(1),
  REDUCE(2);

  private int code;

  PositionMarginType(int i) {}

  @JsonCreator
  public static PositionMarginType getMargineType(String s) {
    try {
      return PositionMarginType.valueOf(s);
    } catch (Exception e) {
      throw new RuntimeException("Unknown order status " + s + ".");
    }
  }

  public int getCode() {
    return code;
  }
}

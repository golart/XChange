package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MarginType {
  ISOLATED,
  CROSSED;

  @JsonCreator
  public static MarginType getMargineType(String s) {
    try {
      return MarginType.valueOf(s);
    } catch (Exception e) {
      throw new RuntimeException("Unknown order status " + s + ".");
    }
  }
}

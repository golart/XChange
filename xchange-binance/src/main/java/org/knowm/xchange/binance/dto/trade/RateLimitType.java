package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/** @author VKozlov */
public enum RateLimitType {
  REQUEST_WEIGHT,
  ORDERS;

  @JsonCreator
  public static RateLimitType getRateLimit(String s) {
    try {
      return RateLimitType.valueOf(s);
    } catch (Exception e) {
      throw new RuntimeException("Unknown order side " + s + ".");
    }
  }
}

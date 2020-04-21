package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/** @author VKozlov */
public enum RateLimitInterval {
  SECOND,
  MINUTE,
  DAY;

  @JsonCreator
  public static RateLimitInterval getRateLimitInterval(String s) {
    try {
      return RateLimitInterval.valueOf(s);
    } catch (Exception e) {
      throw new RuntimeException("Unknown order side " + s + ".");
    }
  }
}

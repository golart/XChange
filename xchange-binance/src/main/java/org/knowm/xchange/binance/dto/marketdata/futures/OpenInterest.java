package org.knowm.xchange.binance.dto.marketdata.futures;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class OpenInterest {

  private final String openInterest;
  private final String symbol;

  public OpenInterest(
      @JsonProperty("openInterest") String openInterest, @JsonProperty("symbol") String symbol) {
    this.openInterest = openInterest;
    this.symbol = symbol;
  }

  public String getOpenInterest() {
    return openInterest;
  }

  public String getSymbol() {
    return symbol;
  }
}

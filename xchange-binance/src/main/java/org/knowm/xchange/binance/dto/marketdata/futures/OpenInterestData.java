package org.knowm.xchange.binance.dto.marketdata.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public final class OpenInterestData {

  private final String symbol;
  private final BigDecimal sumOpenInterest;
  private final BigDecimal sumOpenInterestValue;
  private final long timestamp;

  public OpenInterestData(
      @JsonProperty("sumOpenInterest") BigDecimal sumOpenInterest,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("sumOpenInterestValue") BigDecimal sumOpenInterestValue,
      @JsonProperty("timestamp") long timestamp) {
    this.sumOpenInterest = sumOpenInterest;
    this.sumOpenInterestValue = sumOpenInterestValue;
    this.timestamp = timestamp;
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getSumOpenInterest() {
    return sumOpenInterest;
  }

  public BigDecimal getSumOpenInterestValue() {
    return sumOpenInterestValue;
  }

  public long getTimestamp() {
    return timestamp;
  }
}

package org.knowm.xchange.binance.dto.marketdata.futures;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class BinanceFundingRate {

  private final long timestamp;
  private final long fundingTime;
  private final long fundingRate;
  public final String symbol;

  public BinanceFundingRate(
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("fundingTime") long fundingTime,
      @JsonProperty("fundingRate") long fundingRate,
      @JsonProperty("symbol") String symbol) {
    this.timestamp = timestamp;
    this.fundingTime = fundingTime;
    this.fundingRate = fundingRate;
    this.symbol = symbol;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public long getFundingTime() {
    return fundingTime;
  }

  public long getFundingRate() {
    return fundingRate;
  }

  public String getSymbol() {
    return symbol;
  }
}

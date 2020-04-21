package org.knowm.xchange.binance.dto.marketdata.futures;

import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFutureLongShortRatio {

  private final String symbol;
  private final BigDecimal longShortRatio;
  private final BigDecimal longAccount;
  private final BigDecimal shortAccount;
  private final long timestamp;

  public BinanceFutureLongShortRatio(
      String symbol,
      BigDecimal longShortRatio,
      BigDecimal longAccount,
      BigDecimal shortAccount,
      long timestamp) {
    this.symbol = symbol;
    this.longShortRatio = longShortRatio;
    this.longAccount = longAccount;
    this.shortAccount = shortAccount;
    this.timestamp = timestamp;
  }

  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getLongShortRatio() {
    return longShortRatio;
  }

  public BigDecimal getLongAccount() {
    return longAccount;
  }

  public BigDecimal getShortAccount() {
    return shortAccount;
  }

  public long getTimestamp() {
    return timestamp;
  }
}

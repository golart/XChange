package org.knowm.xchange.binance.dto.marketdata.futures;

import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFuturesLeverageBracket {

  public final long bracket;
  public final long initialLeverage;
  public final BigDecimal notionalCap;
  public final BigDecimal notionalFloor;
  public final BigDecimal maintMarginRatio;

  public BinanceFuturesLeverageBracket(
      long bracket,
      long initialLeverage,
      BigDecimal notionalCap,
      BigDecimal notionalFloor,
      BigDecimal maintMarginRatio) {
    this.bracket = bracket;
    this.initialLeverage = initialLeverage;
    this.notionalCap = notionalCap;
    this.notionalFloor = notionalFloor;
    this.maintMarginRatio = maintMarginRatio;
  }

  public long getBracket() {
    return bracket;
  }

  public long getInitialLeverage() {
    return initialLeverage;
  }

  public BigDecimal getNotionalCap() {
    return notionalCap;
  }

  public BigDecimal getNotionalFloor() {
    return notionalFloor;
  }

  public BigDecimal getMaintMarginRatio() {
    return maintMarginRatio;
  }
}

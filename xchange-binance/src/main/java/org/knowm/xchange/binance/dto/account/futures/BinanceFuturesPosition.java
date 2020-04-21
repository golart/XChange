package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFuturesPosition {

  private final boolean isolated;
  private final long leverage;
  private final BigDecimal initialMargin;
  private final BigDecimal maintMargin;
  private final BigDecimal openOrderInitialMargin;
  private final BigDecimal positionInitialMargin;
  private final String symbol;
  private final BigDecimal unrealizedProfit;

  public BinanceFuturesPosition(
      @JsonProperty("isolated") boolean isolated,
      @JsonProperty("leverage") long leverage,
      @JsonProperty("initialMargin") BigDecimal initialMargin,
      @JsonProperty("maintMargin") BigDecimal maintMargin,
      @JsonProperty("openOrderInitialMargin") BigDecimal openOrderInitialMargin,
      @JsonProperty("positionInitialMargin") BigDecimal positionInitialMargin,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("unrealizedProfit") BigDecimal unrealizedProfit) {
    this.isolated = isolated;
    this.leverage = leverage;
    this.initialMargin = initialMargin;
    this.maintMargin = maintMargin;
    this.openOrderInitialMargin = openOrderInitialMargin;
    this.positionInitialMargin = positionInitialMargin;
    this.symbol = symbol;
    this.unrealizedProfit = unrealizedProfit;
  }

  public boolean isIsolated() {
    return isolated;
  }

  public long getLeverage() {
    return leverage;
  }

  public BigDecimal getInitialMargin() {
    return initialMargin;
  }

  public BigDecimal getMaintMargin() {
    return maintMargin;
  }

  public BigDecimal getOpenOrderInitialMargin() {
    return openOrderInitialMargin;
  }

  public BigDecimal getPositionInitialMargin() {
    return positionInitialMargin;
  }

  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getUnrealizedProfit() {
    return unrealizedProfit;
  }
}

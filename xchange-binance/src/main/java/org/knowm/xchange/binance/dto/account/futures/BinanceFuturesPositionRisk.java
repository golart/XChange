package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFuturesPositionRisk {

  private final BigDecimal entryPrice;
  private final String marginType;
  private final boolean isAutoAddMargin;
  private final BigDecimal isolatedMargin;
  private final BigDecimal liquidationPrice;
  private final BigDecimal markPrice;
  private final BigDecimal maxNotionalValue;
  private final BigDecimal positionAmt;
  private final String symbol;
  private final BigDecimal unRealizedProfit;
  private final long leverage;

  public BinanceFuturesPositionRisk(
      @JsonProperty("entryPrice") BigDecimal entryPrice,
      @JsonProperty("marginType") String marginType,
      @JsonProperty("isAutoAddMargin") boolean isAutoAddMargin,
      @JsonProperty("isolatedMargin") BigDecimal isolatedMargin,
      @JsonProperty("liquidationPrice") BigDecimal liquidationPrice,
      @JsonProperty("markPrice") BigDecimal markPrice,
      @JsonProperty("maxNotionalValue") BigDecimal maxNotionalValue,
      @JsonProperty("positionAmt") BigDecimal positionAmt,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("unRealizedProfit") BigDecimal unRealizedProfit,
      @JsonProperty("leverage") long leverage) {
    this.entryPrice = entryPrice;
    this.marginType = marginType;
    this.isAutoAddMargin = isAutoAddMargin;
    this.isolatedMargin = isolatedMargin;
    this.liquidationPrice = liquidationPrice;
    this.markPrice = markPrice;
    this.maxNotionalValue = maxNotionalValue;
    this.positionAmt = positionAmt;
    this.symbol = symbol;
    this.unRealizedProfit = unRealizedProfit;
    this.leverage = leverage;
  }

  public BigDecimal getEntryPrice() {
    return entryPrice;
  }

  public String getMarginType() {
    return marginType;
  }

  public boolean isAutoAddMargin() {
    return isAutoAddMargin;
  }

  public BigDecimal getIsolatedMargin() {
    return isolatedMargin;
  }

  public BigDecimal getLiquidationPrice() {
    return liquidationPrice;
  }

  public BigDecimal getMarkPrice() {
    return markPrice;
  }

  public BigDecimal getMaxNotionalValue() {
    return maxNotionalValue;
  }

  public BigDecimal getPositionAmt() {
    return positionAmt;
  }

  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getUnRealizedProfit() {
    return unRealizedProfit;
  }

  public long getLeverage() {
    return leverage;
  }
}

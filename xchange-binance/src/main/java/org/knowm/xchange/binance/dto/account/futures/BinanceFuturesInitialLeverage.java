package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFuturesInitialLeverage {

  private final long leverage;
  private final BigDecimal maxNotionalValue;
  private final String symbol;

  public BinanceFuturesInitialLeverage(
      @JsonProperty("leverage") long leverage,
      @JsonProperty("maxNotionalValue") BigDecimal maxNotionalValue,
      @JsonProperty("symbol") String symbol) {
    this.leverage = leverage;
    this.maxNotionalValue = maxNotionalValue;
    this.symbol = symbol;
  }

  public long getLeverage() {
    return leverage;
  }

  public BigDecimal getMaxNotionalValue() {
    return maxNotionalValue;
  }

  public String getSymbol() {
    return symbol;
  }
}

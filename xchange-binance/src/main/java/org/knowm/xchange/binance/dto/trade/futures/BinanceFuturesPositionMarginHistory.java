package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;

/** @author VKozlov */
public class BinanceFuturesPositionMarginHistory {

  private final BigDecimal amount;
  private final String asset;
  private final String symbol;
  private final long time;
  private final long type;

  public BinanceFuturesPositionMarginHistory(
      @JsonProperty("amount") BigDecimal amount,
      @JsonProperty("asset") String asset,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("time") long time,
      @JsonProperty("type") long type) {
    this.amount = amount;
    this.asset = asset;
    this.symbol = symbol;
    this.time = time;
    this.type = type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getAsset() {
    return asset;
  }

  public String getSymbol() {
    return symbol;
  }

  public Date getTime() {
    return new Date(time);
  }

  public long getType() {
    return type;
  }
}

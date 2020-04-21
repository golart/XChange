package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.IncomeType;

/** @author VKozlov */
public class BinanceFuturesIncome {

  private final String symbol;
  private final String asset;
  private final String info;
  private final long time;
  private final IncomeType incomeType;
  private final BigDecimal income;

  public BinanceFuturesIncome(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("asset") String asset,
      @JsonProperty("info") String info,
      @JsonProperty("time") long time,
      @JsonProperty("incomeType") IncomeType incomeType,
      @JsonProperty("income") BigDecimal income) {
    this.symbol = symbol;
    this.asset = asset;
    this.info = info;
    this.time = time;
    this.incomeType = incomeType;
    this.income = income;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getAsset() {
    return asset;
  }

  public String getInfo() {
    return info;
  }

  public long getTime() {
    return time;
  }

  public IncomeType getIncomeType() {
    return incomeType;
  }

  public BigDecimal getIncome() {
    return income;
  }
}

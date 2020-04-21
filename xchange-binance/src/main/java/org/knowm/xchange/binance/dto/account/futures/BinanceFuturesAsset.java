package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFuturesAsset {

  private final String asset;
  private final BigDecimal initialMargin;
  private final BigDecimal maintMargin;
  private final BigDecimal marginBalance;
  private final BigDecimal maxWithdrawAmount;
  private final BigDecimal openOrderInitialMargin;
  private final BigDecimal positionInitialMargin;
  private final BigDecimal unrealizedProfit;
  private final BigDecimal walletBalance;

  public BinanceFuturesAsset(
      @JsonProperty("asset") String asset,
      @JsonProperty("initialMargin") BigDecimal initialMargin,
      @JsonProperty("maintMargin") BigDecimal maintMargin,
      @JsonProperty("marginBalance") BigDecimal marginBalance,
      @JsonProperty("maxWithdrawAmount") BigDecimal maxWithdrawAmount,
      @JsonProperty("openOrderInitialMargin") BigDecimal openOrderInitialMargin,
      @JsonProperty("positionInitialMargin") BigDecimal positionInitialMargin,
      @JsonProperty("unrealizedProfit") BigDecimal unrealizedProfit,
      @JsonProperty("walletBalance") BigDecimal walletBalance) {
    this.asset = asset;
    this.initialMargin = initialMargin;
    this.maintMargin = maintMargin;
    this.marginBalance = marginBalance;
    this.maxWithdrawAmount = maxWithdrawAmount;
    this.openOrderInitialMargin = openOrderInitialMargin;
    this.positionInitialMargin = positionInitialMargin;
    this.unrealizedProfit = unrealizedProfit;
    this.walletBalance = walletBalance;
  }

  public String getAsset() {
    return asset;
  }

  public BigDecimal getInitialMargin() {
    return initialMargin;
  }

  public BigDecimal getMaintMargin() {
    return maintMargin;
  }

  public BigDecimal getMarginBalance() {
    return marginBalance;
  }

  public BigDecimal getMaxWithdrawAmount() {
    return maxWithdrawAmount;
  }

  public BigDecimal getOpenOrderInitialMargin() {
    return openOrderInitialMargin;
  }

  public BigDecimal getPositionInitialMargin() {
    return positionInitialMargin;
  }

  public BigDecimal getUnrealizedProfit() {
    return unrealizedProfit;
  }

  public BigDecimal getWalletBalance() {
    return walletBalance;
  }
}

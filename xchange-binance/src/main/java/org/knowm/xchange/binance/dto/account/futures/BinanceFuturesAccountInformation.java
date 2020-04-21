package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** @author VKozlov */
public class BinanceFuturesAccountInformation {

  private final List<BinanceFuturesAsset> assets;
  private final List<BinanceFuturesPosition> positions;
  private final boolean canDeposit;
  private final boolean canTrade;
  private final boolean canWithdraw;
  private final long feeTier;
  private final BigDecimal maxWithdrawAmount;
  private final BigDecimal totalInitialMargin;
  private final BigDecimal totalMaintMargin;
  private final BigDecimal totalMarginBalance;
  private final BigDecimal totalOpenOrderInitialMargin;
  private final BigDecimal totalPositionInitialMargin;
  private final BigDecimal totalUnrealizedProfit;
  private final BigDecimal totalWalletBalance;
  private final long updateTime;

  public BinanceFuturesAccountInformation(
      @JsonProperty("assets") List<BinanceFuturesAsset> assets,
      @JsonProperty("positions") List<BinanceFuturesPosition> positions,
      @JsonProperty("canDeposit") boolean canDeposit,
      @JsonProperty("canTrade") boolean canTrade,
      @JsonProperty("canWithdraw") boolean canWithdraw,
      @JsonProperty("feeTier") long feeTier,
      @JsonProperty("maxWithdrawAmount") BigDecimal maxWithdrawAmount,
      @JsonProperty("totalInitialMargin") BigDecimal totalInitialMargin,
      @JsonProperty("totalMaintMargin") BigDecimal totalMaintMargin,
      @JsonProperty("totalMarginBalance") BigDecimal totalMarginBalance,
      @JsonProperty("totalOpenOrderInitialMargin") BigDecimal totalOpenOrderInitialMargin,
      @JsonProperty("totalPositionInitialMargin") BigDecimal totalPositionInitialMargin,
      @JsonProperty("totalUnrealizedProfit") BigDecimal totalUnrealizedProfit,
      @JsonProperty("totalWalletBalance") BigDecimal totalWalletBalance,
      @JsonProperty("updateTime") long updateTime) {
    this.assets = assets;
    this.positions = positions;
    this.canDeposit = canDeposit;
    this.canTrade = canTrade;
    this.canWithdraw = canWithdraw;
    this.feeTier = feeTier;
    this.maxWithdrawAmount = maxWithdrawAmount;
    this.totalInitialMargin = totalInitialMargin;
    this.totalMaintMargin = totalMaintMargin;
    this.totalMarginBalance = totalMarginBalance;
    this.totalOpenOrderInitialMargin = totalOpenOrderInitialMargin;
    this.totalPositionInitialMargin = totalPositionInitialMargin;
    this.totalUnrealizedProfit = totalUnrealizedProfit;
    this.totalWalletBalance = totalWalletBalance;
    this.updateTime = updateTime;
  }

  public List<BinanceFuturesAsset> getAssets() {
    return assets;
  }

  public List<BinanceFuturesPosition> getPositions() {
    return positions;
  }

  public boolean isCanDeposit() {
    return canDeposit;
  }

  public boolean isCanTrade() {
    return canTrade;
  }

  public boolean isCanWithdraw() {
    return canWithdraw;
  }

  public long getFeeTier() {
    return feeTier;
  }

  public BigDecimal getMaxWithdrawAmount() {
    return maxWithdrawAmount;
  }

  public BigDecimal getTotalInitialMargin() {
    return totalInitialMargin;
  }

  public BigDecimal getTotalMaintMargin() {
    return totalMaintMargin;
  }

  public BigDecimal getTotalMarginBalance() {
    return totalMarginBalance;
  }

  public BigDecimal getTotalOpenOrderInitialMargin() {
    return totalOpenOrderInitialMargin;
  }

  public BigDecimal getTotalPositionInitialMargin() {
    return totalPositionInitialMargin;
  }

  public BigDecimal getTotalUnrealizedProfit() {
    return totalUnrealizedProfit;
  }

  public BigDecimal getTotalWalletBalance() {
    return totalWalletBalance;
  }

  public long getUpdateTime() {
    return updateTime;
  }
}

package org.knowm.xchange.binance.dto.account.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** @author VKozlov */
public class BinanceFuturesBalance {

  private final String accountAlias;
  private final String asset;
  private final BigDecimal balance;
  private final BigDecimal withdrawAvailable;

  public BinanceFuturesBalance(
      @JsonProperty("accountAlias") String accountAlias,
      @JsonProperty("asset") String asset,
      @JsonProperty("balance") BigDecimal balance,
      @JsonProperty("withdrawAvailable") BigDecimal withdrawAvailable) {
    this.accountAlias = accountAlias;
    this.asset = asset;
    this.balance = balance;
    this.withdrawAvailable = withdrawAvailable;
  }

  public String getAccountAlias() {
    return accountAlias;
  }

  public String getAsset() {
    return asset;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public BigDecimal getWithdrawAvailable() {
    return withdrawAvailable;
  }
}

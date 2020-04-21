//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.currency.Currency;

public class RepayRecord {
  private BigDecimal amount;
  private Currency asset;
  private BigDecimal interest;
  private BigDecimal principal;
  private LoanStatus status;
  private Long timestamp;
  private Long txId;

  public RepayRecord(
      @JsonProperty("amount") final BigDecimal amount,
      @JsonProperty("asset") final String asset,
      @JsonProperty("interest") final BigDecimal interest,
      @JsonProperty("principal") final BigDecimal principal,
      @JsonProperty("status") final String status,
      @JsonProperty("timestamp") final Long timestamp,
      @JsonProperty("txId") final Long txId) {
    this.amount = amount;
    this.asset = Currency.getInstance(asset);
    this.interest = interest;
    this.principal = principal;
    this.status = LoanStatus.valueOf(status);
    this.timestamp = timestamp;
    this.txId = txId;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public Currency getAsset() {
    return this.asset;
  }

  public void setAsset(final Currency asset) {
    this.asset = asset;
  }

  public BigDecimal getInterest() {
    return this.interest;
  }

  public void setInterest(final BigDecimal interest) {
    this.interest = interest;
  }

  public BigDecimal getPrincipal() {
    return this.principal;
  }

  public void setPrincipal(final BigDecimal principal) {
    this.principal = principal;
  }

  public LoanStatus getStatus() {
    return this.status;
  }

  public void setStatus(final LoanStatus status) {
    this.status = status;
  }

  public Long getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(final Long timestamp) {
    this.timestamp = timestamp;
  }

  public Long getTxId() {
    return this.txId;
  }

  public void setTxId(final Long txId) {
    this.txId = txId;
  }
}

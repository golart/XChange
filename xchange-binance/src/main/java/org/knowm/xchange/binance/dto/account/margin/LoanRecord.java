//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.currency.Currency;

public class LoanRecord {
  private Currency asset;
  private BigDecimal principal;
  private Long timestamp;
  private LoanStatus status;

  public LoanRecord(
      @JsonProperty("asset") final String asset,
      @JsonProperty("principal") final BigDecimal principal,
      @JsonProperty("timestamp") final Long timestamp,
      @JsonProperty("status") final String status) {
    this.asset = Currency.getInstance(asset);
    this.principal = principal;
    this.timestamp = timestamp;
    this.status = LoanStatus.valueOf(status);
  }

  public Currency getAsset() {
    return this.asset;
  }

  public void setAsset(final Currency asset) {
    this.asset = asset;
  }

  public BigDecimal getPrincipal() {
    return this.principal;
  }

  public void setPrincipal(final BigDecimal principal) {
    this.principal = principal;
  }

  public Long getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(final Long timestamp) {
    this.timestamp = timestamp;
  }

  public LoanStatus getStatus() {
    return this.status;
  }

  public void setStatus(final LoanStatus status) {
    this.status = status;
  }
}

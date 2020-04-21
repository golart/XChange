//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.currency.Currency;

public class MarginAssetBalance {
  private Currency asset;
  private BigDecimal borrowed;
  private BigDecimal free;
  private BigDecimal interest;
  private BigDecimal locked;
  private BigDecimal netAsset;

  public MarginAssetBalance(
      @JsonProperty("asset") final String asset,
      @JsonProperty("borrowed") final BigDecimal borrowed,
      @JsonProperty("free") final BigDecimal free,
      @JsonProperty("interest") final BigDecimal interest,
      @JsonProperty("locked") final BigDecimal locked,
      @JsonProperty("netAsset") final BigDecimal netAsset) {
    this.asset = Currency.getInstance(asset);
    this.borrowed = borrowed;
    this.free = free;
    this.interest = interest;
    this.locked = locked;
    this.netAsset = netAsset;
  }

  public Currency getAsset() {
    return this.asset;
  }

  public void setAsset(final Currency asset) {
    this.asset = asset;
  }

  public BigDecimal getBorrowed() {
    return this.borrowed;
  }

  public void setBorrowed(final BigDecimal borrowed) {
    this.borrowed = borrowed;
  }

  public BigDecimal getFree() {
    return this.free;
  }

  public void setFree(final BigDecimal free) {
    this.free = free;
  }

  public BigDecimal getInterest() {
    return this.interest;
  }

  public void setInterest(final BigDecimal interest) {
    this.interest = interest;
  }

  public BigDecimal getLocked() {
    return this.locked;
  }

  public void setLocked(final BigDecimal locked) {
    this.locked = locked;
  }

  public BigDecimal getNetAsset() {
    return this.netAsset;
  }

  public void setNetAsset(final BigDecimal netAsset) {
    this.netAsset = netAsset;
  }
}

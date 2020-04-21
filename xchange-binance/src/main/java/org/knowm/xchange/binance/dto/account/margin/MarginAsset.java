//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class MarginAsset {
  private String assetFullName;
  private String assetName;
  private Boolean isBorrowable;
  private Boolean isMortgageable;
  private BigDecimal userMinBorrow;
  private BigDecimal userMinRepay;

  public MarginAsset(
      @JsonProperty("assetFullName") final String assetFullName,
      @JsonProperty("assetName") final String assetName,
      @JsonProperty("isBorrowable") final Boolean isBorrowable,
      @JsonProperty("isMortgageable") final Boolean isMortgageable,
      @JsonProperty("userMinBorrow") final BigDecimal userMinBorrow,
      @JsonProperty("userMinRepay") final BigDecimal userMinRepay) {
    this.assetFullName = assetFullName;
    this.assetName = assetName;
    this.isBorrowable = isBorrowable;
    this.isMortgageable = isMortgageable;
    this.userMinBorrow = userMinBorrow;
    this.userMinRepay = userMinRepay;
  }

  public String getAssetFullName() {
    return this.assetFullName;
  }

  public void setAssetFullName(final String assetFullName) {
    this.assetFullName = assetFullName;
  }

  public String getAssetName() {
    return this.assetName;
  }

  public void setAssetName(final String assetName) {
    this.assetName = assetName;
  }

  public Boolean getBorrowable() {
    return this.isBorrowable;
  }

  public void setBorrowable(final Boolean borrowable) {
    this.isBorrowable = borrowable;
  }

  public Boolean getMortgageable() {
    return this.isMortgageable;
  }

  public void setMortgageable(final Boolean mortgageable) {
    this.isMortgageable = mortgageable;
  }

  public BigDecimal getUserMinBorrow() {
    return this.userMinBorrow;
  }

  public void setUserMinBorrow(final BigDecimal userMinBorrow) {
    this.userMinBorrow = userMinBorrow;
  }

  public BigDecimal getUserMinRepay() {
    return this.userMinRepay;
  }

  public void setUserMinRepay(final BigDecimal userMinRepay) {
    this.userMinRepay = userMinRepay;
  }
}

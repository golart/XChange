//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.currency.CurrencyPair;

public class ShortMarginOrder {
  private Long id;
  private BigDecimal price;
  private BigDecimal qty;
  private BigDecimal quoteQty;
  private CurrencyPair symbol;
  private Long time;

  public ShortMarginOrder(
      @JsonProperty("id") final Long id,
      @JsonProperty("price") final BigDecimal price,
      @JsonProperty("qty") final BigDecimal qty,
      @JsonProperty("quoteQty") final BigDecimal quoteQty,
      @JsonProperty("symbol") final String symbol,
      @JsonProperty("time") final Long time) {
    this.id = id;
    this.price = price;
    this.qty = qty;
    this.quoteQty = quoteQty;
    this.symbol = BinanceAdapters.adaptSymbol(symbol);
    this.time = time;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getQty() {
    return this.qty;
  }

  public void setQty(final BigDecimal qty) {
    this.qty = qty;
  }

  public BigDecimal getQuoteQty() {
    return this.quoteQty;
  }

  public void setQuoteQty(final BigDecimal quoteQty) {
    this.quoteQty = quoteQty;
  }

  public CurrencyPair getSymbol() {
    return this.symbol;
  }

  public void setSymbol(final CurrencyPair symbol) {
    this.symbol = symbol;
  }

  public Long getTime() {
    return this.time;
  }

  public void setTime(final Long time) {
    this.time = time;
  }
}

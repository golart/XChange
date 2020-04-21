//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

public class MarginPair {
  private Long id;
  private CurrencyPair symbol;
  private Currency base;
  private Currency quote;
  private Boolean isMarginTrade;
  private Boolean isBuyAllowed;
  private Boolean isSellAllowed;

  public MarginPair(
      @JsonProperty("id") final Long id,
      @JsonProperty("symbol") final String symbol,
      @JsonProperty("base") final String base,
      @JsonProperty("quote") final String quote,
      @JsonProperty("isMarginTrade") final Boolean isMarginTrade,
      @JsonProperty("isBuyAllowed") final Boolean isBuyAllowed,
      @JsonProperty("isSellAllowed") final Boolean isSellAllowed) {
    this.id = id;
    this.symbol = BinanceAdapters.adaptSymbol(symbol);
    this.base = Currency.getInstance(base);
    this.quote = Currency.getInstance(quote);
    this.isMarginTrade = isMarginTrade;
    this.isBuyAllowed = isBuyAllowed;
    this.isSellAllowed = isSellAllowed;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public CurrencyPair getSymbol() {
    return this.symbol;
  }

  public void setSymbol(final CurrencyPair symbol) {
    this.symbol = symbol;
  }

  public Currency getBase() {
    return this.base;
  }

  public void setBase(final Currency base) {
    this.base = base;
  }

  public Currency getQuote() {
    return this.quote;
  }

  public void setQuote(final Currency quote) {
    this.quote = quote;
  }

  public Boolean getMarginTrade() {
    return this.isMarginTrade;
  }

  public void setMarginTrade(final Boolean marginTrade) {
    this.isMarginTrade = marginTrade;
  }

  public Boolean getBuyAllowed() {
    return this.isBuyAllowed;
  }

  public void setBuyAllowed(final Boolean buyAllowed) {
    this.isBuyAllowed = buyAllowed;
  }

  public Boolean getSellAllowed() {
    return this.isSellAllowed;
  }

  public void setSellAllowed(final Boolean sellAllowed) {
    this.isSellAllowed = sellAllowed;
  }
}

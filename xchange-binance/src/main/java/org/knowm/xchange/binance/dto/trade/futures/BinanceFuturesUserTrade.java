package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.trade.OrderSide;
import org.knowm.xchange.currency.CurrencyPair;

/** @author VKozlov */
public class BinanceFuturesUserTrade {

  public final boolean buyer;
  public final BigDecimal commission;
  public final String commissionAsset;
  public final Long id;
  public final Long orderId;
  public final boolean maker;
  public final BigDecimal price;
  public final BigDecimal qty;
  public final BigDecimal quoteQty;
  public final BigDecimal realizedPnl;
  public final OrderSide side;
  public final CurrencyPair symbol;
  public final long time;

  public BinanceFuturesUserTrade(
      @JsonProperty("buyer") boolean buyer,
      @JsonProperty("commission") BigDecimal commission,
      @JsonProperty("commissionAsset") String commissionAsset,
      @JsonProperty("id") Long id,
      @JsonProperty("orderId") Long orderId,
      @JsonProperty("maker") boolean maker,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("qty") BigDecimal qty,
      @JsonProperty("quoteQty") BigDecimal quoteQty,
      @JsonProperty("realizedPnl") BigDecimal realizedPnl,
      @JsonProperty("side") OrderSide side,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("time") long time) {
    this.buyer = buyer;
    this.commission = commission;
    this.commissionAsset = commissionAsset;
    this.id = id;
    this.orderId = orderId;
    this.maker = maker;
    this.price = price;
    this.qty = qty;
    this.quoteQty = quoteQty;
    this.realizedPnl = realizedPnl;
    this.side = side;
    this.symbol = BinanceAdapters.adaptSymbol(symbol);
    this.time = time;
  }

  public boolean isBuyer() {
    return buyer;
  }

  public BigDecimal getCommission() {
    return commission;
  }

  public String getCommissionAsset() {
    return commissionAsset;
  }

  public Long getId() {
    return id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public boolean isMaker() {
    return maker;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public BigDecimal getQuoteQty() {
    return quoteQty;
  }

  public BigDecimal getRealizedPnl() {
    return realizedPnl;
  }

  public OrderSide getSide() {
    return side;
  }

  public CurrencyPair getSymbol() {
    return symbol;
  }

  public Date getTime() {
    return new Date(time);
  }
}

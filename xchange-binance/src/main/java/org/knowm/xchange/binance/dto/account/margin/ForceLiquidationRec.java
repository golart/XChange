//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.trade.OrderSide;
import org.knowm.xchange.binance.dto.trade.TimeInForce;
import org.knowm.xchange.currency.CurrencyPair;

public class ForceLiquidationRec {
  private BigDecimal avgPrice;
  private BigDecimal executedQty;
  private Long orderId;
  private BigDecimal price;
  private BigDecimal qty;
  private OrderSide side;
  private CurrencyPair symbol;
  private TimeInForce timeInForce;
  private Long updatedTime;

  public ForceLiquidationRec(
      @JsonProperty("avgPrice") final BigDecimal avgPrice,
      @JsonProperty("executedQty") final BigDecimal executedQty,
      @JsonProperty("orderId") final Long orderId,
      @JsonProperty("price") final BigDecimal price,
      @JsonProperty("qty") final BigDecimal qty,
      @JsonProperty("side") final String side,
      @JsonProperty("symbol") final String symbol,
      @JsonProperty("timeInForce") final String timeInForce,
      @JsonProperty("updatedTime") final Long updatedTime) {
    this.avgPrice = avgPrice;
    this.executedQty = executedQty;
    this.orderId = orderId;
    this.price = price;
    this.qty = qty;
    this.side = OrderSide.valueOf(side);
    this.symbol = BinanceAdapters.adaptSymbol(symbol);
    this.timeInForce = TimeInForce.valueOf(timeInForce);
    this.updatedTime = updatedTime;
  }

  public BigDecimal getAvgPrice() {
    return this.avgPrice;
  }

  public void setAvgPrice(final BigDecimal avgPrice) {
    this.avgPrice = avgPrice;
  }

  public BigDecimal getExecutedQty() {
    return this.executedQty;
  }

  public void setExecutedQty(final BigDecimal executedQty) {
    this.executedQty = executedQty;
  }

  public Long getOrderId() {
    return this.orderId;
  }

  public void setOrderId(final Long orderId) {
    this.orderId = orderId;
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

  public OrderSide getSide() {
    return this.side;
  }

  public void setSide(final OrderSide side) {
    this.side = side;
  }

  public CurrencyPair getSymbol() {
    return this.symbol;
  }

  public void setSymbol(final CurrencyPair symbol) {
    this.symbol = symbol;
  }

  public TimeInForce getTimeInForce() {
    return this.timeInForce;
  }

  public void setTimeInForce(final TimeInForce timeInForce) {
    this.timeInForce = timeInForce;
  }

  public Long getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(final Long updatedTime) {
    this.updatedTime = updatedTime;
  }
}

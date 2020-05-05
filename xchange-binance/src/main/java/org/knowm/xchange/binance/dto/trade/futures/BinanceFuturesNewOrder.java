package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.trade.*;
import org.knowm.xchange.currency.CurrencyPair;

public final class BinanceFuturesNewOrder {

  public final CurrencyPair symbol;
  public final long orderId;
  public final String clientOrderId;
  public final long transactTime;
  public final BigDecimal price;
  public final BigDecimal origQty;
  public final BigDecimal executedQty;
  public final BigDecimal cummulativeQuoteQty;
  public final org.knowm.xchange.binance.dto.trade.OrderStatus status;
  public final TimeInForce timeInForce;
  public final org.knowm.xchange.binance.dto.trade.OrderType type;
  public final OrderSide side;
  public final BigDecimal stopPrice;
  public final BigDecimal cumQuote;
  public final BigDecimal activatePrice;
  public final boolean reduceOnly;
  public final BigDecimal priceRate;
  public final long updateTime;
  public final WorkingType workingType;

  public BinanceFuturesNewOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("orderId") long orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("transactTime") long transactTime,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("origQty") BigDecimal origQty,
      @JsonProperty("executedQty") BigDecimal executedQty,
      @JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQty,
      @JsonProperty("status") org.knowm.xchange.binance.dto.trade.OrderStatus status,
      @JsonProperty("timeInForce") TimeInForce timeInForce,
      @JsonProperty("type") org.knowm.xchange.binance.dto.trade.OrderType type,
      @JsonProperty("side") OrderSide side,
      @JsonProperty("stopPrice") BigDecimal stopPrice,
      @JsonProperty("cumQuote") BigDecimal cumQuote,
      @JsonProperty("activatePrice") BigDecimal activatePrice,
      @JsonProperty("priceRate") BigDecimal priceRate,
      @JsonProperty("updateTime") Long updateTime,
      @JsonProperty("workingType") WorkingType workingType,
      @JsonProperty("reduceOnly") boolean reduceOnly) {
    this.symbol = BinanceAdapters.adaptSymbol(symbol);
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.transactTime = transactTime;
    this.price = price;
    this.origQty = origQty;
    this.executedQty = executedQty;
    this.status = status;
    this.timeInForce = timeInForce;
    this.type = type;
    this.side = side;
    this.cummulativeQuoteQty = cummulativeQuoteQty;
    this.workingType = workingType;
    this.reduceOnly = reduceOnly;
    this.updateTime = updateTime;
    this.priceRate = priceRate;
    this.activatePrice = activatePrice;
    this.cumQuote = cumQuote;
    this.stopPrice = stopPrice;
  }

  public CurrencyPair getSymbol() {
    return symbol;
  }

  public long getOrderId() {
    return orderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public long getTransactTime() {
    return transactTime;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getOrigQty() {
    return origQty;
  }

  public BigDecimal getExecutedQty() {
    return executedQty;
  }

  public BigDecimal getCummulativeQuoteQty() {
    return cummulativeQuoteQty;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public OrderType getType() {
    return type;
  }

  public OrderSide getSide() {
    return side;
  }

  public BigDecimal getStopPrice() {
    return stopPrice;
  }

  public BigDecimal getCumQuote() {
    return cumQuote;
  }

  public BigDecimal getActivatePrice() {
    return activatePrice;
  }

  public boolean isReduceOnly() {
    return reduceOnly;
  }

  public BigDecimal getPriceRate() {
    return priceRate;
  }

  public long getUpdateTime() {
    return updateTime;
  }

  public WorkingType getWorkingType() {
    return workingType;
  }
}

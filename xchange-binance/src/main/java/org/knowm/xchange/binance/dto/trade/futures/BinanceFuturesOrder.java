package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.*;

public final class BinanceFuturesOrder {

  public final String symbol;
  public final long orderId;
  public final String clientOrderId;
  public final BigDecimal price;
  public final BigDecimal origQty;
  public final BigDecimal executedQty;
  public final BigDecimal cummulativeQuoteQty;
  public final OrderStatus status;
  public final TimeInForce timeInForce;
  public final OrderType type;
  public final OrderSide side;
  public final BigDecimal stopPrice;
  public final BigDecimal icebergQty;
  public final BigDecimal avgPrice;
  public final BigDecimal cumQuote;
  public final BigDecimal activatePrice;
  public final BigDecimal priceRate;
  public final boolean reduceOnly;
  public final WorkingType workingType;
  public final long time;

  public BinanceFuturesOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("avgPrice") BigDecimal avgPrice,
      @JsonProperty("cumQuote") BigDecimal cumQuote,
      @JsonProperty("activatePrice") BigDecimal activatePrice,
      @JsonProperty("priceRate") BigDecimal priceRate,
      @JsonProperty("reduceOnly") boolean reduceOnly,
      @JsonProperty("orderId") long orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("origQty") BigDecimal origQty,
      @JsonProperty("executedQty") BigDecimal executedQty,
      @JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQty,
      @JsonProperty("status") OrderStatus status,
      @JsonProperty("timeInForce") TimeInForce timeInForce,
      @JsonProperty("type") OrderType type,
      @JsonProperty("side") OrderSide side,
      @JsonProperty("stopPrice") BigDecimal stopPrice,
      @JsonProperty("icebergQty") BigDecimal icebergQty,
      @JsonProperty("workingType") WorkingType workingType,
      @JsonProperty("time") long time) {
    this.symbol = symbol;
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.price = price;
    this.origQty = origQty;
    this.executedQty = executedQty;
    this.cummulativeQuoteQty = cummulativeQuoteQty;
    this.status = status;
    this.timeInForce = timeInForce;
    this.type = type;
    this.side = side;
    this.stopPrice = stopPrice;
    this.icebergQty = icebergQty;
    this.time = time;
    this.avgPrice = avgPrice;
    this.cumQuote = cumQuote;
    this.reduceOnly = reduceOnly;
    this.activatePrice = activatePrice;
    this.priceRate = priceRate;
    this.workingType = workingType;
  }

  public String getSymbol() {
    return symbol;
  }

  public long getOrderId() {
    return orderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
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

  public BigDecimal getIcebergQty() {
    return icebergQty;
  }

  public BigDecimal getAvgPrice() {
    return avgPrice;
  }

  public BigDecimal getCumQuote() {
    return cumQuote;
  }

  public BigDecimal getActivatePrice() {
    return activatePrice;
  }

  public BigDecimal getPriceRate() {
    return priceRate;
  }

  public boolean isReduceOnly() {
    return reduceOnly;
  }

  public WorkingType getWorkingType() {
    return workingType;
  }

  public long getTime() {
    return time;
  }
}

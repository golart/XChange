package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public final class BinanceNewOrder {

  public final String symbol;
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

  public BinanceNewOrder(
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
      @JsonProperty("side") OrderSide side) {
    this.symbol = symbol;
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
  }
}

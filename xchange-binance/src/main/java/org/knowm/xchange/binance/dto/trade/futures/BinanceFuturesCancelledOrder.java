package org.knowm.xchange.binance.dto.trade.futures;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.*;

public final class BinanceFuturesCancelledOrder {

  public final String symbol;
  public final String origClientOrderId;
  public final long orderId;
  public final String clientOrderId;
  public final BigDecimal cumQty;
  public final BigDecimal cumQuote;
  public final BigDecimal executedQty;
  public final BigDecimal origQty;
  public final OrderType origType;
  public final Boolean reduceOnly;
  public final OrderSide side;
  public final String positionSide;
  public final OrderStatus status;
  public final BigDecimal stopPrice;
  public final TimeInForce timeInForce;
  public final OrderType type;
  public final BigDecimal activatePrice;
  public final BigDecimal priceRate;
  public final long updateTime;
  public final WorkingType workingType;

  public BinanceFuturesCancelledOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("origClientOrderId") String origClientOrderId,
      @JsonProperty("orderId") long orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("cumQty") BigDecimal cumQty,
      @JsonProperty("cumQuote") BigDecimal cumQuote,
      @JsonProperty("executedQty") BigDecimal executedQty,
      @JsonProperty("origQty") BigDecimal origQty,
      @JsonProperty("origType") OrderType origType,
      @JsonProperty("reduceOnly") Boolean reduceOnly,
      @JsonProperty("side") OrderSide side,
      @JsonProperty("positionSide") String positionSide,
      @JsonProperty("status") OrderStatus status,
      @JsonProperty("stopPrice") BigDecimal stopPrice,
      @JsonProperty("timeInForce") TimeInForce timeInForce,
      @JsonProperty("type") OrderType type,
      @JsonProperty("activatePrice") BigDecimal activatePrice,
      @JsonProperty("priceRate") BigDecimal priceRate,
      @JsonProperty("updateTime") long updateTime,
      @JsonProperty("workingType") WorkingType workingType) {
    super();
    this.symbol = symbol;
    this.origClientOrderId = origClientOrderId;
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.cumQty = cumQty;
    this.cumQuote = cumQuote;
    this.executedQty = executedQty;
    this.origQty = origQty;
    this.origType = origType;
    this.reduceOnly = reduceOnly;
    this.side = side;
    this.positionSide = positionSide;
    this.status = status;
    this.stopPrice = stopPrice;
    this.timeInForce = timeInForce;
    this.type = type;
    this.activatePrice = activatePrice;
    this.priceRate = priceRate;
    this.updateTime = updateTime;
    this.workingType = workingType;
  }
}

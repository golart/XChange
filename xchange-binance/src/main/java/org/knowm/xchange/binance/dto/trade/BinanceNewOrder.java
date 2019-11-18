// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import java.util.Date;
import org.knowm.xchange.binance.BinanceAdapters;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.dto.trade.LimitOrder;

public final class BinanceNewOrder extends LimitOrder
{
    public final String symbol;
    public final long orderId;
    public final String clientOrderId;
    public final long transactTime;
    public final BigDecimal price;
    public final BigDecimal origQty;
    public final BigDecimal executedQty;
    public final BinanceOrderStatus bStatus;
    public final TimeInForce timeInForce;
    public final BinanceOrderType bType;
    public final OrderSide side;
    
    public BinanceNewOrder(@JsonProperty("symbol") final String symbol, @JsonProperty("orderId") final long orderId, @JsonProperty("clientOrderId") final String clientOrderId, @JsonProperty("transactTime") final long transactTime, @JsonProperty("price") final BigDecimal price, @JsonProperty("origQty") final BigDecimal origQty, @JsonProperty("executedQty") final BigDecimal executedQty, @JsonProperty("status") final BinanceOrderStatus status, @JsonProperty("timeInForce") final TimeInForce timeInForce, @JsonProperty("type") final BinanceOrderType type, @JsonProperty("side") final OrderSide side) {
        super(BinanceAdapters.convert(side), origQty, BinanceAdapters.adaptSymbol(symbol), Long.toString(orderId), new Date(transactTime), price);
        this.symbol = symbol;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.transactTime = transactTime;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.bStatus = status;
        this.timeInForce = timeInForce;
        this.bType = type;
        this.side = side;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import org.knowm.xchange.binance.BinanceAdapters;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.dto.trade.OrderType;
import org.knowm.xchange.binance.dto.trade.TimeInForce;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.binance.dto.trade.OrderStatus;
import org.knowm.xchange.binance.dto.trade.OrderSide;
import java.math.BigDecimal;

public class MarginOrder
{
    private String clientOrderId;
    private BigDecimal cummulativeQuoteQty;
    private BigDecimal executedQty;
    private BigDecimal icebergQty;
    private Boolean isWorking;
    private Long orderId;
    private BigDecimal origQty;
    private BigDecimal price;
    private OrderSide side;
    private OrderStatus status;
    private BigDecimal stopPrice;
    private CurrencyPair symbol;
    private Long time;
    private Long transactTime;
    private TimeInForce timeInForce;
    private OrderType type;
    private Long updateTime;
    
    public MarginOrder(@JsonProperty("clientOrderId") final String clientOrderId, @JsonProperty("cummulativeQuoteQty") final BigDecimal cummulativeQuoteQty, @JsonProperty("executedQty") final BigDecimal executedQty, @JsonProperty("icebergQty") final BigDecimal icebergQty, @JsonProperty("isWorking") final Boolean isWorking, @JsonProperty("orderId") final Long orderId, @JsonProperty("origQty") final BigDecimal origQty, @JsonProperty("price") final BigDecimal price, @JsonProperty("side") final String side, @JsonProperty("status") final String status, @JsonProperty("stopPrice") final BigDecimal stopPrice, @JsonProperty("symbol") final String symbol, @JsonProperty("time") final Long time, @JsonProperty("transactTime") final Long transactTime, @JsonProperty("timeInForce") final String timeInForce, @JsonProperty("type") final String type, @JsonProperty("updateTime") final Long updateTime) {
        this.clientOrderId = clientOrderId;
        this.cummulativeQuoteQty = cummulativeQuoteQty;
        this.executedQty = executedQty;
        this.icebergQty = icebergQty;
        this.isWorking = isWorking;
        this.orderId = orderId;
        this.origQty = origQty;
        this.price = price;
        this.side = OrderSide.valueOf(side);
        this.status = OrderStatus.valueOf(status);
        this.stopPrice = stopPrice;
        this.symbol = BinanceAdapters.adaptSymbol(symbol);
        this.time = time;
        this.transactTime = transactTime;
        this.timeInForce = TimeInForce.valueOf(timeInForce);
        this.type = OrderType.valueOf(type);
        this.updateTime = updateTime;
    }
    
    public String getClientOrderId() {
        return this.clientOrderId;
    }
    
    public void setClientOrderId(final String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }
    
    public BigDecimal getCummulativeQuoteQty() {
        return this.cummulativeQuoteQty;
    }
    
    public void setCummulativeQuoteQty(final BigDecimal cummulativeQuoteQty) {
        this.cummulativeQuoteQty = cummulativeQuoteQty;
    }
    
    public BigDecimal getExecutedQty() {
        return this.executedQty;
    }
    
    public void setExecutedQty(final BigDecimal executedQty) {
        this.executedQty = executedQty;
    }
    
    public BigDecimal getIcebergQty() {
        return this.icebergQty;
    }
    
    public void setIcebergQty(final BigDecimal icebergQty) {
        this.icebergQty = icebergQty;
    }
    
    public Boolean getWorking() {
        return this.isWorking;
    }
    
    public void setWorking(final Boolean working) {
        this.isWorking = working;
    }
    
    public Long getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }
    
    public BigDecimal getOrigQty() {
        return this.origQty;
    }
    
    public void setOrigQty(final BigDecimal origQty) {
        this.origQty = origQty;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
    
    public OrderSide getSide() {
        return this.side;
    }
    
    public void setSide(final OrderSide side) {
        this.side = side;
    }
    
    public Long getTransactTime() {
        return this.transactTime;
    }
    
    public void setTransactTime(final Long transactTime) {
        this.transactTime = transactTime;
    }
    
    public OrderStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(final OrderStatus status) {
        this.status = status;
    }
    
    public BigDecimal getStopPrice() {
        return this.stopPrice;
    }
    
    public void setStopPrice(final BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
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
    
    public TimeInForce getTimeInForce() {
        return this.timeInForce;
    }
    
    public void setTimeInForce(final TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }
    
    public OrderType getType() {
        return this.type;
    }
    
    public void setType(final OrderType type) {
        this.type = type;
    }
    
    public Long getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(final Long updateTime) {
        this.updateTime = updateTime;
    }
}

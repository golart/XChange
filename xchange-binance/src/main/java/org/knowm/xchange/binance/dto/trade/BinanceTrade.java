// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import java.util.Date;
import org.knowm.xchange.binance.BinanceAdapters;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.currency.Currency;
import java.math.BigDecimal;

public final class BinanceTrade
{
    public final long id;
    public final long orderId;
    public final BigDecimal price;
    public final BigDecimal qty;
    public final BigDecimal commission;
    public final Currency commissionAsset;
    public final long time;
    public final boolean isBuyer;
    public final boolean isMaker;
    public final boolean isBestMatch;
    public final CurrencyPair symbol;
    
    public BinanceTrade(@JsonProperty("id") final long id, @JsonProperty("orderId") final long orderId, @JsonProperty("price") final BigDecimal price, @JsonProperty("qty") final BigDecimal qty, @JsonProperty("commission") final BigDecimal commission, @JsonProperty("commissionAsset") final String commissionAsset, @JsonProperty("time") final long time, @JsonProperty("isBuyer") final boolean isBuyer, @JsonProperty("isMaker") final boolean isMaker, @JsonProperty("isBestMatch") final boolean isBestMatch, @JsonProperty("symbol") final String symbol) {
        this.id = id;
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
        this.commission = commission;
        this.commissionAsset = Currency.getInstance(commissionAsset);
        this.time = time;
        this.isBuyer = isBuyer;
        this.isMaker = isMaker;
        this.isBestMatch = isBestMatch;
        this.symbol = BinanceAdapters.adaptSymbol(symbol);
    }
    
    public Date getTime() {
        return new Date(this.time);
    }
    
    public long getId() {
        return this.id;
    }
    
    public long getOrderId() {
        return this.orderId;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public BigDecimal getQty() {
        return this.qty;
    }
    
    public BigDecimal getCommission() {
        return this.commission;
    }
    
    public Currency getCommissionAsset() {
        return this.commissionAsset;
    }
    
    public boolean isBuyer() {
        return this.isBuyer;
    }
    
    public boolean isMaker() {
        return this.isMaker;
    }
    
    public boolean isBestMatch() {
        return this.isBestMatch;
    }
    
    public CurrencyPair getSymbol() {
        return this.symbol;
    }
}

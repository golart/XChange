// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import org.knowm.xchange.binance.BinanceAdapters;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.CurrencyPair;
import java.math.BigDecimal;

public class MarginPriceIndex
{
    private Long calcTime;
    private BigDecimal price;
    private CurrencyPair symbol;
    
    public MarginPriceIndex(@JsonProperty("calcTime") final Long calcTime, @JsonProperty("price") final BigDecimal price, @JsonProperty("symbol") final String symbol) {
        this.calcTime = calcTime;
        this.price = price;
        this.symbol = BinanceAdapters.adaptSymbol(symbol);
    }
    
    public Long getCalcTime() {
        return this.calcTime;
    }
    
    public void setCalcTime(final Long calcTime) {
        this.calcTime = calcTime;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
    
    public CurrencyPair getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(final CurrencyPair symbol) {
        this.symbol = symbol;
    }
}

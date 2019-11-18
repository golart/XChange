// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.meta.exchangeinfo;

public class BinanceExchangeInfo
{
    private String timezone;
    private Symbol[] symbols;
    private String serverTime;
    private RateLimit[] rateLimits;
    private String[] exchangeFilters;
    
    public String getTimezone() {
        return this.timezone;
    }
    
    public void setTimezone(final String timezone) {
        this.timezone = timezone;
    }
    
    public Symbol[] getSymbols() {
        return this.symbols;
    }
    
    public void setSymbols(final Symbol[] symbols) {
        this.symbols = symbols;
    }
    
    public String getServerTime() {
        return this.serverTime;
    }
    
    public void setServerTime(final String serverTime) {
        this.serverTime = serverTime;
    }
    
    public RateLimit[] getRateLimits() {
        return this.rateLimits;
    }
    
    public void setRateLimits(final RateLimit[] rateLimits) {
        this.rateLimits = rateLimits;
    }
    
    public String[] getExchangeFilters() {
        return this.exchangeFilters;
    }
    
    public void setExchangeFilters(final String[] exchangeFilters) {
        this.exchangeFilters = exchangeFilters;
    }
    
    @Override
    public String toString() {
        return "ClassPojo [timezone = " + this.timezone + ", symbols = " + this.symbols + ", serverTime = " + this.serverTime + ", rateLimits = " + this.rateLimits + ", exchangeFilters = " + this.exchangeFilters + "]";
    }
}

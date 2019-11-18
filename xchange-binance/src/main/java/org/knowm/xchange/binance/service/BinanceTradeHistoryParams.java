// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.params.TradeHistoryParamsIdSpan;
import org.knowm.xchange.service.trade.params.TradeHistoryParamLimit;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrencyPair;

public class BinanceTradeHistoryParams implements TradeHistoryParamCurrencyPair, TradeHistoryParamLimit, TradeHistoryParamsIdSpan
{
    private CurrencyPair currencyPair;
    private Integer limit;
    private String startId;
    private String endId;
    
    public BinanceTradeHistoryParams(final CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }
    
    public BinanceTradeHistoryParams() {
    }
    
    public CurrencyPair getCurrencyPair() {
        return this.currencyPair;
    }
    
    public void setCurrencyPair(final CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }
    
    public Integer getLimit() {
        return this.limit;
    }
    
    public void setLimit(final Integer limit) {
        this.limit = limit;
    }
    
    public String getStartId() {
        return this.startId;
    }
    
    public void setStartId(final String startId) {
        this.startId = startId;
    }
    
    public String getEndId() {
        return this.endId;
    }
    
    public void setEndId(final String endId) {
        this.endId = endId;
    }
}

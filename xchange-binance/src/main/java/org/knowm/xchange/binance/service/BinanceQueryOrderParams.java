// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.params.orders.OrderQueryParamCurrencyPair;

public class BinanceQueryOrderParams implements OrderQueryParamCurrencyPair
{
    private String orderId;
    private CurrencyPair pair;
    
    public BinanceQueryOrderParams() {
    }
    
    public BinanceQueryOrderParams(final CurrencyPair pair, final String orderId) {
        this.pair = pair;
        this.orderId = orderId;
    }
    
    public CurrencyPair getCurrencyPair() {
        return this.pair;
    }
    
    public void setCurrencyPair(final CurrencyPair pair) {
        this.pair = pair;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }
}

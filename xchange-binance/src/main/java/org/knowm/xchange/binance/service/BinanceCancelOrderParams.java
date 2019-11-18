// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.params.CancelOrderByCurrencyPair;
import org.knowm.xchange.service.trade.params.CancelOrderByIdParams;

public class BinanceCancelOrderParams implements CancelOrderByIdParams, CancelOrderByCurrencyPair
{
    private final String orderId;
    private final CurrencyPair pair;
    
    public BinanceCancelOrderParams(final CurrencyPair pair, final String orderId) {
        this.pair = pair;
        this.orderId = orderId;
    }
    
    public CurrencyPair getCurrencyPair() {
        return this.pair;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
}

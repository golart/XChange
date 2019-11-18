// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BinanceListenKey
{
    private String listenKey;
    
    public BinanceListenKey(@JsonProperty("listenKey") final String listenKey) {
        this.listenKey = listenKey;
    }
    
    public String getListenKey() {
        return this.listenKey;
    }
    
    public void setListenKey(final String listenKey) {
        this.listenKey = listenKey;
    }
}

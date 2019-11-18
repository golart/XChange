// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class BinanceCancelledOrder
{
    public final String symbol;
    public final String origClientOrderId;
    public final long orderId;
    public final String clientOrderId;
    
    public BinanceCancelledOrder(@JsonProperty("symbol") final String symbol, @JsonProperty("origClientOrderId") final String origClientOrderId, @JsonProperty("orderId") final long orderId, @JsonProperty("clientOrderId") final String clientOrderId) {
        this.symbol = symbol;
        this.origClientOrderId = origClientOrderId;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BinanceOrderStatus
{
    NEW, 
    PARTIALLY_FILLED, 
    FILLED, 
    CANCELED, 
    PENDING_CANCEL, 
    REJECTED, 
    EXPIRED;
    
    @JsonCreator
    public static BinanceOrderStatus getOrderStatus(final String s) {
        try {
            return valueOf(s);
        }
        catch (Exception e) {
            throw new RuntimeException("Unknown order status " + s + ".");
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderSide
{
    BUY, 
    SELL;
    
    @JsonCreator
    public static OrderSide getOrderSide(final String s) {
        try {
            return valueOf(s);
        }
        catch (Exception e) {
            throw new RuntimeException("Unknown order side " + s + ".");
        }
    }
}

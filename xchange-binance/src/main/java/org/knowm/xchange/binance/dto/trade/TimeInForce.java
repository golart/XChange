// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.knowm.xchange.dto.Order;

public enum TimeInForce implements Order.IOrderFlags
{
    GTC, 
    FOK, 
    IOC;
    
    @JsonCreator
    public static TimeInForce getTimeInForce(final String s) {
        try {
            return valueOf(s);
        }
        catch (Exception e) {
            throw new RuntimeException("Unknown ordtime in force " + s + ".");
        }
    }
}

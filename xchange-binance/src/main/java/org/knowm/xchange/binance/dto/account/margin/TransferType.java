// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

public enum TransferType
{
    TO_MARGIN(1), 
    FROM_MARGIN(2);
    
    private final int code;
    
    private TransferType(final int code) {
        this.code = code;
    }
    
    public int getCode() {
        return this.code;
    }
}

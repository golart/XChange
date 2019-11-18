// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

public abstract class WapiResponse<T>
{
    public final boolean success;
    public final String msg;
    
    public WapiResponse(final boolean success, final String msg) {
        this.success = success;
        this.msg = msg;
    }
    
    public abstract T getData();
}

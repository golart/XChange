// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BinanceException extends RuntimeException
{
    private final int code;
    
    public BinanceException(@JsonProperty("code") final int code, @JsonProperty("msg") final String msg) {
        super(msg);
        this.code = code;
    }
    
    public int getCode() {
        return this.code;
    }
}

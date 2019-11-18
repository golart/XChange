// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class WithdrawRequest extends WapiResponse<String>
{
    public final String id;
    
    public WithdrawRequest(@JsonProperty("success") final boolean success, @JsonProperty("msg") final String msg, @JsonProperty("id") final String id) {
        super(success, msg);
        this.id = id;
    }
    
    @Override
    public String getData() {
        return this.id;
    }
}

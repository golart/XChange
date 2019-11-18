// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationInfo
{
    private Long tranId;
    
    public OperationInfo(@JsonProperty("tranId") final Long tranId) {
        this.tranId = tranId;
    }
    
    public Long getTranId() {
        return this.tranId;
    }
    
    public void setTranId(final Long tranId) {
        this.tranId = tranId;
    }
}

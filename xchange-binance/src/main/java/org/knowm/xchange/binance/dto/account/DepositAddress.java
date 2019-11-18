// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class DepositAddress
{
    public String address;
    public boolean success;
    public String addressTag;
    public String asset;
    
    public DepositAddress(@JsonProperty("address") final String address, @JsonProperty("success") final boolean success, @JsonProperty("addressTag") final String addressTag, @JsonProperty("asset") final String asset) {
        this.address = address;
        this.success = success;
        this.addressTag = addressTag;
        this.asset = asset;
    }
}

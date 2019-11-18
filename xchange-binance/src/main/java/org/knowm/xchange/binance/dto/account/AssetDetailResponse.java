// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class AssetDetailResponse
{
    private final boolean success;
    private final Map<String, AssetDetail> assetDetail;
    
    public AssetDetailResponse(@JsonProperty("success") final boolean success, @JsonProperty("assetDetail") final Map<String, AssetDetail> assetDetail) {
        this.success = success;
        this.assetDetail = assetDetail;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public Map<String, AssetDetail> getAssetDetail() {
        return this.assetDetail;
    }
    
    @Override
    public String toString() {
        return "AssetDetailResponse{success = '" + this.success + '\'' + ",assetDetail = '" + this.assetDetail + '\'' + "}";
    }
}

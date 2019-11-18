// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class AssetDetail
{
    private final String minWithdrawAmount;
    private final boolean depositStatus;
    private final BigDecimal withdrawFee;
    private final boolean withdrawStatus;
    
    public AssetDetail(@JsonProperty("minWithdrawAmount") final String minWithdrawAmount, @JsonProperty("depositStatus") final boolean depositStatus, @JsonProperty("withdrawFee") final BigDecimal withdrawFee, @JsonProperty("withdrawStatus") final boolean withdrawStatus) {
        this.minWithdrawAmount = minWithdrawAmount;
        this.depositStatus = depositStatus;
        this.withdrawFee = withdrawFee;
        this.withdrawStatus = withdrawStatus;
    }
    
    public String getMinWithdrawAmount() {
        return this.minWithdrawAmount;
    }
    
    public boolean isDepositStatus() {
        return this.depositStatus;
    }
    
    public BigDecimal getWithdrawFee() {
        return this.withdrawFee;
    }
    
    public boolean isWithdrawStatus() {
        return this.withdrawStatus;
    }
    
    @Override
    public String toString() {
        return "AssetDetail{minWithdrawAmount = '" + this.minWithdrawAmount + '\'' + ",depositStatus = '" + this.depositStatus + '\'' + ",withdrawFee = '" + this.withdrawFee + '\'' + ",withdrawStatus = '" + this.withdrawStatus + '\'' + "}";
    }
}

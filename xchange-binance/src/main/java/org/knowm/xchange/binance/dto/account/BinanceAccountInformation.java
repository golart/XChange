// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.math.BigDecimal;

public final class BinanceAccountInformation
{
    public final BigDecimal makerCommission;
    public final BigDecimal takerCommission;
    public final BigDecimal buyerCommission;
    public final BigDecimal sellerCommission;
    public final boolean canTrade;
    public final boolean canWithdraw;
    public final boolean canDeposit;
    public final long updateTime;
    public List<BinanceBalance> balances;
    
    public BinanceAccountInformation(@JsonProperty("makerCommission") final BigDecimal makerCommission, @JsonProperty("takerCommission") final BigDecimal takerCommission, @JsonProperty("buyerCommission") final BigDecimal buyerCommission, @JsonProperty("sellerCommission") final BigDecimal sellerCommission, @JsonProperty("canTrade") final boolean canTrade, @JsonProperty("canWithdraw") final boolean canWithdraw, @JsonProperty("canDeposit") final boolean canDeposit, @JsonProperty("updateTime") final long updateTime, @JsonProperty("balances") final List<BinanceBalance> balances) {
        this.makerCommission = makerCommission;
        this.takerCommission = takerCommission;
        this.buyerCommission = buyerCommission;
        this.sellerCommission = sellerCommission;
        this.canTrade = canTrade;
        this.canWithdraw = canWithdraw;
        this.canDeposit = canDeposit;
        this.updateTime = updateTime;
        this.balances = balances;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.currency.Currency;

public class Interest
{
    private Currency asset;
    private BigDecimal interest;
    private Long interestAccuredTime;
    private BigDecimal interestRate;
    private BigDecimal principal;
    private InterestType type;
    
    public Interest(@JsonProperty("asset") final String asset, @JsonProperty("interest") final BigDecimal interest, @JsonProperty("interestAccuredTime") final Long interestAccuredTime, @JsonProperty("interestRate") final BigDecimal interestRate, @JsonProperty("principal") final BigDecimal principal, @JsonProperty("type") final String type) {
        this.asset = Currency.getInstance(asset);
        this.interest = interest;
        this.interestAccuredTime = interestAccuredTime;
        this.interestRate = interestRate;
        this.principal = principal;
        this.type = InterestType.valueOf(type);
    }
    
    public Currency getAsset() {
        return this.asset;
    }
    
    public void setAsset(final Currency asset) {
        this.asset = asset;
    }
    
    public BigDecimal getInterest() {
        return this.interest;
    }
    
    public void setInterest(final BigDecimal interest) {
        this.interest = interest;
    }
    
    public Long getInterestAccuredTime() {
        return this.interestAccuredTime;
    }
    
    public void setInterestAccuredTime(final Long interestAccuredTime) {
        this.interestAccuredTime = interestAccuredTime;
    }
    
    public BigDecimal getInterestRate() {
        return this.interestRate;
    }
    
    public void setInterestRate(final BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
    
    public BigDecimal getPrincipal() {
        return this.principal;
    }
    
    public void setPrincipal(final BigDecimal principal) {
        this.principal = principal;
    }
    
    public InterestType getType() {
        return this.type;
    }
    
    public void setType(final InterestType type) {
        this.type = type;
    }
}

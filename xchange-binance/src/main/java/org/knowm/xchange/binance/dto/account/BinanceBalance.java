// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.currency.Currency;

public final class BinanceBalance
{
    private final Currency currency;
    private final BigDecimal free;
    private final BigDecimal locked;
    
    public BinanceBalance(@JsonProperty("asset") final String asset, @JsonProperty("free") final BigDecimal free, @JsonProperty("locked") final BigDecimal locked) {
        this.currency = Currency.getInstance(asset);
        this.locked = locked;
        this.free = free;
    }
    
    public Currency getCurrency() {
        return this.currency;
    }
    
    public BigDecimal getTotal() {
        return this.free.add(this.locked);
    }
    
    public BigDecimal getAvailable() {
        return this.free;
    }
    
    public BigDecimal getLocked() {
        return this.locked;
    }
    
    @Override
    public String toString() {
        return "[" + this.currency + ", free=" + this.free + ", locked=" + this.locked + "]";
    }
}

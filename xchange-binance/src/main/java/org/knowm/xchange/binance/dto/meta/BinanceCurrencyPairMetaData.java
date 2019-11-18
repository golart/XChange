// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.meta;

import org.knowm.xchange.dto.meta.FeeTier;
import java.math.BigDecimal;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;

public class BinanceCurrencyPairMetaData extends CurrencyPairMetaData
{
    private final BigDecimal minNotional;
    
    public BinanceCurrencyPairMetaData(final BigDecimal tradingFee, final BigDecimal minimumAmount, final BigDecimal maximumAmount, final Integer priceScale, final BigDecimal minNotional, final FeeTier[] feeTiers) {
        super(tradingFee, minimumAmount, maximumAmount, priceScale, feeTiers);
        this.minNotional = minNotional;
    }
    
    public BigDecimal getMinNotional() {
        return this.minNotional;
    }
    
    public String toString() {
        return "BinanceCurrencyPairMetaData{minNotional=" + this.minNotional + "} " + super.toString();
    }
}

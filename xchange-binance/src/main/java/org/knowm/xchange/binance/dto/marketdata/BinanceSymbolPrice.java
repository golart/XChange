// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public final class BinanceSymbolPrice
{
    public final String symbol;
    public final BigDecimal price;
    
    public BinanceSymbolPrice(@JsonProperty("symbol") final String symbol, @JsonProperty("price") final BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }
}

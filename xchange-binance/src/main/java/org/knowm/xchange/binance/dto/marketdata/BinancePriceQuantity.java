// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public final class BinancePriceQuantity
{
    public final String symbol;
    public final BigDecimal bidPrice;
    public final BigDecimal bidQty;
    public final BigDecimal askPrice;
    public final BigDecimal askQty;
    
    public BinancePriceQuantity(@JsonProperty("symbol") final String symbol, @JsonProperty("bidPrice") final BigDecimal bidPrice, @JsonProperty("bidQty") final BigDecimal bidQty, @JsonProperty("askPrice") final BigDecimal askPrice, @JsonProperty("askQty") final BigDecimal askQty) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
    }
}

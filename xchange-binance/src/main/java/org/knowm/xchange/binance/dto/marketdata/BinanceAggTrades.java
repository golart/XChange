// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public final class BinanceAggTrades
{
    public final long aggregateTradeId;
    public final BigDecimal price;
    public final BigDecimal quantity;
    public final long firstTradeId;
    public final long lastTradeId;
    public final long timestamp;
    public final boolean buyerMaker;
    public final boolean bestPriceMatch;
    
    public BinanceAggTrades(@JsonProperty("a") final long aggregateTradeId, @JsonProperty("p") final BigDecimal price, @JsonProperty("q") final BigDecimal quantity, @JsonProperty("f") final long firstTradeId, @JsonProperty("l") final long lastTradeId, @JsonProperty("T") final long timestamp, @JsonProperty("m") final boolean buyerMaker, @JsonProperty("M") final boolean bestPriceMatch) {
        this.aggregateTradeId = aggregateTradeId;
        this.price = price;
        this.quantity = quantity;
        this.firstTradeId = firstTradeId;
        this.lastTradeId = lastTradeId;
        this.timestamp = timestamp;
        this.buyerMaker = buyerMaker;
        this.bestPriceMatch = bestPriceMatch;
    }
    
    public Date getTimestamp() {
        return new Date(this.timestamp);
    }
}

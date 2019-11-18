// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.SortedMap;

public final class BinanceOrderbook
{
    public final long lastUpdateId;
    public final SortedMap<BigDecimal, BigDecimal> bids;
    public final SortedMap<BigDecimal, BigDecimal> asks;
    
    public BinanceOrderbook(@JsonProperty("lastUpdateId") final long lastUpdateId, @JsonProperty("bids") final List<Object[]> bidsJson, @JsonProperty("asks") final List<Object[]> asksJson) {
        this.lastUpdateId = lastUpdateId;
        final BigDecimal price;
        final BigDecimal qty;
        final BiConsumer<Object[], Map<BigDecimal, BigDecimal>> entryProcessor = (obj, col) -> {
            price = new BigDecimal(obj[0].toString());
            qty = new BigDecimal(obj[1].toString());
            col.put(price, qty);
            return;
        };
        final TreeMap<BigDecimal, BigDecimal> bids = new TreeMap<BigDecimal, BigDecimal>((k1, k2) -> -k1.compareTo(k2));
        final TreeMap<BigDecimal, BigDecimal> asks = new TreeMap<BigDecimal, BigDecimal>();
        bidsJson.stream().forEach(e -> entryProcessor.accept(e, bids));
        asksJson.stream().forEach(e -> entryProcessor.accept(e, asks));
        this.bids = Collections.unmodifiableSortedMap((SortedMap<BigDecimal, ? extends BigDecimal>)bids);
        this.asks = Collections.unmodifiableSortedMap((SortedMap<BigDecimal, ? extends BigDecimal>)asks);
    }
}

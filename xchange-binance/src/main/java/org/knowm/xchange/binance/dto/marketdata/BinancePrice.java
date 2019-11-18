// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import org.knowm.xchange.utils.Assert;
import org.knowm.xchange.utils.jackson.CurrencyPairDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.knowm.xchange.currency.CurrencyPair;

public final class BinancePrice implements Comparable<BinancePrice>
{
    private final CurrencyPair pair;
    private final BigDecimal price;
    
    public BinancePrice(@JsonProperty("symbol") final String symbol, @JsonProperty("price") final BigDecimal price) {
        this(CurrencyPairDeserializer.getCurrencyPairFromString(symbol), price);
    }
    
    public BinancePrice(final CurrencyPair pair, final BigDecimal price) {
        Assert.notNull((Object)price, "Null price");
        Assert.notNull((Object)pair, "Null pair");
        this.pair = pair;
        this.price = price;
    }
    
    public CurrencyPair getCurrencyPair() {
        return this.pair;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    @Override
    public int compareTo(final BinancePrice o) {
        if (this.pair.compareTo(o.pair) == 0) {
            return this.price.compareTo(o.price);
        }
        return this.pair.compareTo(o.pair);
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((this.pair == null) ? 0 : this.pair.hashCode());
        result = 31 * result + ((this.price == null) ? 0 : this.price.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinancePrice)) {
            return false;
        }
        final BinancePrice other = (BinancePrice)obj;
        return this.pair.equals((Object)other.pair) && this.price.equals(other.price);
    }
    
    @Override
    public String toString() {
        return "[" + this.pair + "] => " + this.price;
    }
}

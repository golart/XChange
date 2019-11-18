// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import org.knowm.xchange.currency.CurrencyPair;

public final class BinanceKline
{
    private final CurrencyPair pair;
    private final KlineInterval interval;
    private final long openTime;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;
    private final long closeTime;
    private final BigDecimal quoteAssetVolume;
    private final long numberOfTrades;
    private final BigDecimal takerBuyBaseAssetVolume;
    private final BigDecimal takerBuyQuoteAssetVolume;
    
    public BinanceKline(final CurrencyPair pair, final KlineInterval interval, final Object[] obj) {
        this.pair = pair;
        this.interval = interval;
        this.openTime = Long.valueOf(obj[0].toString());
        this.open = new BigDecimal(obj[1].toString());
        this.high = new BigDecimal(obj[2].toString());
        this.low = new BigDecimal(obj[3].toString());
        this.close = new BigDecimal(obj[4].toString());
        this.volume = new BigDecimal(obj[5].toString());
        this.closeTime = Long.valueOf(obj[6].toString());
        this.quoteAssetVolume = new BigDecimal(obj[7].toString());
        this.numberOfTrades = Long.valueOf(obj[8].toString());
        this.takerBuyBaseAssetVolume = new BigDecimal(obj[9].toString());
        this.takerBuyQuoteAssetVolume = new BigDecimal(obj[10].toString());
    }
    
    public CurrencyPair getCurrencyPair() {
        return this.pair;
    }
    
    public KlineInterval getInterval() {
        return this.interval;
    }
    
    public long getOpenTime() {
        return this.openTime;
    }
    
    public BigDecimal getOpenPrice() {
        return this.open;
    }
    
    public BigDecimal getHighPrice() {
        return this.high;
    }
    
    public BigDecimal getLowPrice() {
        return this.low;
    }
    
    public BigDecimal getAveragePrice() {
        return this.low.add(this.high).divide(new BigDecimal("2"));
    }
    
    public BigDecimal getClosePrice() {
        return this.close;
    }
    
    public BigDecimal getVolume() {
        return this.volume;
    }
    
    public long getCloseTime() {
        return this.closeTime;
    }
    
    public BigDecimal getQuoteAssetVolume() {
        return this.quoteAssetVolume;
    }
    
    public long getNumberOfTrades() {
        return this.numberOfTrades;
    }
    
    public BigDecimal getTakerBuyBaseAssetVolume() {
        return this.takerBuyBaseAssetVolume;
    }
    
    public BigDecimal getTakerBuyQuoteAssetVolume() {
        return this.takerBuyQuoteAssetVolume;
    }
    
    @Override
    public String toString() {
        final String tstamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.openTime);
        return String.format("[%s] %s %s O:%.6f A:%.6f C:%.6f", this.pair, tstamp, this.interval, this.open, this.getAveragePrice(), this.close);
    }
}

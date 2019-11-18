// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import org.knowm.xchange.binance.BinanceAdapters;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.currency.CurrencyPair;
import java.math.BigDecimal;

public final class BinanceTicker24h
{
    private final BigDecimal priceChange;
    private final BigDecimal priceChangePercent;
    private final BigDecimal weightedAvgPrice;
    private final BigDecimal prevClosePrice;
    private final BigDecimal lastPrice;
    private final BigDecimal lastQty;
    private final BigDecimal bidPrice;
    private final BigDecimal bidQty;
    private final BigDecimal askPrice;
    private final BigDecimal askQty;
    private final BigDecimal openPrice;
    private final BigDecimal highPrice;
    private final BigDecimal lowPrice;
    private final BigDecimal volume;
    private final BigDecimal quoteVolume;
    private final long openTime;
    private final long closeTime;
    private final long firstId;
    private final long lastId;
    private final long count;
    private final String symbol;
    private CurrencyPair pair;
    private Ticker ticker;
    
    public BinanceTicker24h(@JsonProperty("priceChange") final BigDecimal priceChange, @JsonProperty("priceChangePercent") final BigDecimal priceChangePercent, @JsonProperty("weightedAvgPrice") final BigDecimal weightedAvgPrice, @JsonProperty("prevClosePrice") final BigDecimal prevClosePrice, @JsonProperty("lastPrice") final BigDecimal lastPrice, @JsonProperty("lastQty") final BigDecimal lastQty, @JsonProperty("bidPrice") final BigDecimal bidPrice, @JsonProperty("bidQty") final BigDecimal bidQty, @JsonProperty("askPrice") final BigDecimal askPrice, @JsonProperty("askQty") final BigDecimal askQty, @JsonProperty("openPrice") final BigDecimal openPrice, @JsonProperty("highPrice") final BigDecimal highPrice, @JsonProperty("lowPrice") final BigDecimal lowPrice, @JsonProperty("volume") final BigDecimal volume, @JsonProperty("quoteVolume") final BigDecimal quoteVolume, @JsonProperty("openTime") final long openTime, @JsonProperty("closeTime") final long closeTime, @JsonProperty("firstId") final long firstId, @JsonProperty("lastId") final long lastId, @JsonProperty("count") final long count, @JsonProperty("symbol") final String symbol) {
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.weightedAvgPrice = weightedAvgPrice;
        this.prevClosePrice = prevClosePrice;
        this.lastPrice = lastPrice;
        this.lastQty = lastQty;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.firstId = firstId;
        this.lastId = lastId;
        this.count = count;
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public CurrencyPair getCurrencyPair() {
        return this.pair;
    }
    
    public void setCurrencyPair(final CurrencyPair pair) {
        this.pair = pair;
    }
    
    public BigDecimal getPriceChange() {
        return this.priceChange;
    }
    
    public BigDecimal getPriceChangePercent() {
        return this.priceChangePercent;
    }
    
    public BigDecimal getWeightedAvgPrice() {
        return this.weightedAvgPrice;
    }
    
    public BigDecimal getPrevClosePrice() {
        return this.prevClosePrice;
    }
    
    public BigDecimal getLastPrice() {
        return this.lastPrice;
    }
    
    public BigDecimal getLastQty() {
        return this.lastQty;
    }
    
    public BigDecimal getBidPrice() {
        return this.bidPrice;
    }
    
    public BigDecimal getBidQty() {
        return this.bidQty;
    }
    
    public BigDecimal getAskPrice() {
        return this.askPrice;
    }
    
    public BigDecimal getAskQty() {
        return this.askQty;
    }
    
    public BigDecimal getOpenPrice() {
        return this.openPrice;
    }
    
    public BigDecimal getHighPrice() {
        return this.highPrice;
    }
    
    public BigDecimal getLowPrice() {
        return this.lowPrice;
    }
    
    public BigDecimal getVolume() {
        return this.volume;
    }
    
    public BigDecimal getQuoteVolume() {
        return this.quoteVolume;
    }
    
    public long getFirstTradeId() {
        return this.firstId;
    }
    
    public long getLastTradeId() {
        return this.lastId;
    }
    
    public long getTradeCount() {
        return this.count;
    }
    
    public Date getOpenTime() {
        return new Date(this.openTime);
    }
    
    public Date getCloseTime() {
        return new Date(this.closeTime);
    }
    
    public synchronized Ticker toTicker() {
        CurrencyPair currencyPair = this.pair;
        if (currencyPair == null) {
            currencyPair = BinanceAdapters.adaptSymbol(this.symbol);
        }
        if (this.ticker == null) {
            this.ticker = new Ticker.Builder().currencyPair(currencyPair).open(this.openPrice).ask(this.askPrice).bid(this.bidPrice).last(this.lastPrice).high(this.highPrice).low(this.lowPrice).volume(this.volume).vwap(this.weightedAvgPrice).priceChange(this.priceChange).priceChangePercent(this.priceChangePercent).askSize(this.askQty).bidSize(this.bidQty).quoteVolume(this.quoteVolume).build();
        }
        return this.ticker;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.dto.marketdata.BinancePriceQuantity;
import org.knowm.xchange.binance.dto.marketdata.BinancePrice;
import org.knowm.xchange.binance.dto.marketdata.BinanceTicker24h;
import java.util.stream.Collectors;
import java.util.stream.Collector;
import org.knowm.xchange.utils.StreamUtils;
import org.knowm.xchange.binance.dto.marketdata.BinanceKline;
import org.knowm.xchange.binance.dto.marketdata.KlineInterval;
import org.knowm.xchange.binance.dto.marketdata.BinanceAggTrades;
import java.util.List;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.marketdata.BinanceOrderbook;
import org.knowm.xchange.currency.CurrencyPair;
import java.io.IOException;
import org.knowm.xchange.Exchange;

public class BinanceMarketDataServiceRaw extends BinanceBaseService
{
    protected BinanceMarketDataServiceRaw(final Exchange exchange) {
        super(exchange);
    }
    
    public void ping() throws IOException {
        this.binance.ping();
    }
    
    public BinanceOrderbook getBinanceOrderbook(final CurrencyPair pair, final Integer limit) throws IOException {
        return this.binance.depth(BinanceAdapters.toSymbol(pair), limit);
    }
    
    public List<BinanceAggTrades> aggTrades(final CurrencyPair pair, final Long fromId, final Long startTime, final Long endTime, final Integer limit) throws IOException {
        return this.binance.aggTrades(BinanceAdapters.toSymbol(pair), fromId, startTime, endTime, limit);
    }
    
    public BinanceKline lastKline(final CurrencyPair pair, final KlineInterval interval) throws IOException {
        return this.klines(pair, interval, 1, null, null).stream().collect((Collector<? super Object, Object, BinanceKline>)StreamUtils.singletonCollector());
    }
    
    public List<BinanceKline> klines(final CurrencyPair pair, final KlineInterval interval) throws IOException {
        return this.klines(pair, interval, null, null, null);
    }
    
    public List<BinanceKline> klines(final CurrencyPair pair, final KlineInterval interval, final Integer limit, final Long startTime, final Long endTime) throws IOException {
        final List<Object[]> raw = this.binance.klines(BinanceAdapters.toSymbol(pair), interval.code(), limit, startTime, endTime);
        return raw.stream().map(obj -> new BinanceKline(pair, interval, obj)).collect((Collector<? super Object, ?, List<BinanceKline>>)Collectors.toList());
    }
    
    public List<BinanceTicker24h> ticker24h() throws IOException {
        final List<BinanceTicker24h> binanceTicker24hList = this.binance.ticker24h();
        return binanceTicker24hList;
    }
    
    public BinanceTicker24h ticker24h(final CurrencyPair pair) throws IOException {
        final BinanceTicker24h ticker24h = this.binance.ticker24h(BinanceAdapters.toSymbol(pair));
        ticker24h.setCurrencyPair(pair);
        return ticker24h;
    }
    
    public BinancePrice tickerPrice(final CurrencyPair pair) throws IOException {
        return this.tickerAllPrices().stream().filter(p -> p.getCurrencyPair().equals((Object)pair)).collect((Collector<? super Object, Object, BinancePrice>)StreamUtils.singletonCollector());
    }
    
    public List<BinancePrice> tickerAllPrices() throws IOException {
        return this.binance.tickerAllPrices();
    }
    
    public List<BinancePriceQuantity> tickerAllBookTickers() throws IOException {
        return this.binance.tickerAllBookTickers();
    }
}

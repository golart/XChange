// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import java.util.Map;
import org.knowm.xchange.binance.dto.marketdata.BinancePriceQuantity;
import org.knowm.xchange.binance.dto.marketdata.BinanceAggTrades;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.dto.marketdata.Trades;
import java.util.function.Function;
import org.knowm.xchange.binance.dto.marketdata.BinanceTicker24h;
import org.knowm.xchange.service.marketdata.params.Params;
import org.knowm.xchange.dto.marketdata.Ticker;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Date;
import java.math.BigDecimal;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import java.util.List;
import java.io.IOException;
import org.knowm.xchange.binance.dto.marketdata.BinanceOrderbook;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.BinanceErrorAdapter;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class BinanceMarketDataService extends BinanceMarketDataServiceRaw implements MarketDataService
{
    public BinanceMarketDataService(final Exchange exchange) {
        super(exchange);
    }
    
    public OrderBook getOrderBook(final CurrencyPair pair, final Object... args) throws IOException {
        try {
            int limitDepth = 100;
            if (args != null && args.length == 1) {
                final Object arg0 = args[0];
                if (!(arg0 instanceof Integer)) {
                    throw new ExchangeException("Argument 0 must be an Integer!");
                }
                limitDepth = (int)arg0;
            }
            final BinanceOrderbook binanceOrderbook = this.getBinanceOrderbook(pair, limitDepth);
            return convertOrderBook(binanceOrderbook, pair);
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public static OrderBook convertOrderBook(final BinanceOrderbook ob, final CurrencyPair pair) {
        final List<LimitOrder> bids = ob.bids.entrySet().stream().map(e -> new LimitOrder(Order.OrderType.BID, (BigDecimal)e.getValue(), pair, (String)null, (Date)null, (BigDecimal)e.getKey())).collect((Collector<? super Object, ?, List<LimitOrder>>)Collectors.toList());
        final List<LimitOrder> asks = ob.asks.entrySet().stream().map(e -> new LimitOrder(Order.OrderType.ASK, (BigDecimal)e.getValue(), pair, (String)null, (Date)null, (BigDecimal)e.getKey())).collect((Collector<? super Object, ?, List<LimitOrder>>)Collectors.toList());
        return new OrderBook((Date)null, (List)asks, (List)bids);
    }
    
    public Ticker getTicker(final CurrencyPair pair, final Object... args) throws IOException {
        try {
            return this.ticker24h(pair).toTicker();
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public List<Ticker> getTickers(final Params params) throws IOException {
        try {
            return this.ticker24h().stream().map((Function<? super Object, ?>)BinanceTicker24h::toTicker).collect((Collector<? super Object, ?, List<Ticker>>)Collectors.toList());
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public Trades getTrades(final CurrencyPair pair, final Object... args) throws IOException {
        try {
            final Long fromId = this.tradesArgument(args, 0, Long::valueOf);
            final Long startTime = this.tradesArgument(args, 1, Long::valueOf);
            final Long endTime = this.tradesArgument(args, 2, Long::valueOf);
            final Integer limit = this.tradesArgument(args, 3, Integer::valueOf);
            final List<BinanceAggTrades> aggTrades = this.binance.aggTrades(BinanceAdapters.toSymbol(pair), fromId, startTime, endTime, limit);
            final List<Trade> trades = aggTrades.stream().map(at -> new Trade(BinanceAdapters.convertType(at.buyerMaker), at.quantity, pair, at.price, at.getTimestamp(), Long.toString(at.aggregateTradeId))).collect((Collector<? super Object, ?, List<Trade>>)Collectors.toList());
            return new Trades((List)trades, Trades.TradeSortType.SortByTimestamp);
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    private <T extends Number> T tradesArgument(final Object[] args, final int index, final Function<String, T> converter) {
        if (index >= args.length) {
            return null;
        }
        final Object arg = args[index];
        if (arg == null) {
            return null;
        }
        final String argStr = arg.toString();
        try {
            return converter.apply(argStr);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Argument on index " + index + " is not a number: " + argStr, e);
        }
    }
    
    public List<Ticker> getAllBookTickers() throws IOException {
        final List<BinancePriceQuantity> binanceTickers = this.tickerAllBookTickers();
        return BinanceAdapters.adaptPriceQuantities(binanceTickers);
    }
}

package org.knowm.xchange.binance.service.futures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.marketdata.*;
import org.knowm.xchange.binance.dto.marketdata.futures.BinanceFundingRate;
import org.knowm.xchange.binance.dto.marketdata.futures.BinanceFuturesLeverageBrackets;
import org.knowm.xchange.binance.dto.marketdata.futures.OpenInterestData;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import org.knowm.xchange.binance.dto.trade.BinanceTrade;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.StreamUtils;

public class BinanceFuturesMarketDataServiceRaw extends BinanceFuturesBaseService {

  protected BinanceFuturesMarketDataServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public void ping() throws IOException {
    binanceFutures.ping();
  }

  public BinanceOrderbook getOrderbook(CurrencyPair pair, Integer limit) throws IOException {
    return binanceFutures.depth(BinanceAdapters.toSymbol(pair), limit);
  }

  public List<BinanceAggTrades> aggTrades(
      CurrencyPair pair, Long fromId, Long startTime, Long endTime, Integer limit)
      throws IOException {
    return binanceFutures.aggTrades(
        BinanceAdapters.toSymbol(pair), fromId, startTime, endTime, limit);
  }

  public List<BinanceTrade> recentTrades(CurrencyPair pair, Integer limit) throws IOException {
    return binanceFutures.recentTrades(BinanceAdapters.toSymbol(pair), limit);
  }

  public List<BinanceTrade> historicalTrades(CurrencyPair pair, Long fromId, Integer limit)
      throws IOException {
    return binanceFutures.historicalTrades(BinanceAdapters.toSymbol(pair), fromId, limit);
  }

  public BinanceKline lastKline(CurrencyPair pair, KlineInterval interval) throws IOException {
    return klines(pair, interval, 1, null, null).stream().collect(StreamUtils.singletonCollector());
  }

  public List<BinanceKline> klines(CurrencyPair pair, KlineInterval interval) throws IOException {
    return klines(pair, interval, null, null, null);
  }

  public List<BinanceKline> klines(
      CurrencyPair pair, KlineInterval interval, Integer limit, Long startTime, Long endTime)
      throws IOException {
    List<Object[]> raw =
        binanceFutures.klines(
            BinanceAdapters.toSymbol(pair), interval.code(), limit, startTime, endTime);
    return raw.stream()
        .map(obj -> new BinanceKline(pair, interval, obj))
        .collect(Collectors.toList());
  }

  public List<BinanceTicker24h> ticker24h() throws IOException {
    List<BinanceTicker24h> binanceTicker24hList = binanceFutures.ticker24h();
    return binanceTicker24hList;
  }

  public BinanceTicker24h ticker24h(CurrencyPair pair) throws IOException {
    BinanceTicker24h ticker24h = binanceFutures.ticker24h(BinanceAdapters.toSymbol(pair));
    ticker24h.setCurrencyPair(pair);
    return ticker24h;
  }

  public BinancePrice tickerPrice(CurrencyPair pair) throws IOException {
    return binanceFutures.tickerPrice(BinanceAdapters.toSymbol(pair));
  }

  public List<BinancePrice> tickerAllPrices() throws IOException {
    return binanceFutures.tickerAllPrices();
  }

  public List<BinancePriceQuantity> tickerAllBookTickers() throws IOException {
    return binanceFutures.tickerAllBookTickers();
  }

  public BinancePriceQuantity tickerAllBookTickers(CurrencyPair pair) throws IOException {
    return binanceFutures.tickerBookTickers(BinanceAdapters.toSymbol(pair));
  }

  public List<BinanceFundingRate> fundingRate(
      CurrencyPair pair, Long startTime, Long endTime, Integer limit) throws IOException {
    return binanceFutures.fundingRate(BinanceAdapters.toSymbol(pair), limit, startTime, endTime);
  }

  public List<BinanceOrder> getAllLiquidationOrders(
      CurrencyPair pair, Long startTime, Long endTime, Integer limit) throws IOException {
    return binanceFutures.getAllLiquidationOrders(
        BinanceAdapters.toSymbol(pair), limit, startTime, endTime);
  }

  public List<BinanceOrder> openInterest(CurrencyPair pair) throws IOException {
    return binanceFutures.openInterest(BinanceAdapters.toSymbol(pair));
  }

  public List<BinanceFuturesLeverageBrackets> leverageBracket(CurrencyPair pair)
      throws IOException {
    return binanceFutures.leverageBracket(BinanceAdapters.toSymbol(pair));
  }

  public List<OpenInterestData> openInterestStatistics(
      CurrencyPair pair, KlineInterval period, Long startTime, Long endTime, Integer limit)
      throws IOException {
    return binanceFutures.openInterestStatistics(
        BinanceAdapters.toSymbol(pair), period, startTime, endTime, limit);
  }
}

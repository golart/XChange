package org.knowm.xchange.binance;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.*;
import org.knowm.xchange.binance.dto.marketdata.futures.BinanceFundingRate;
import org.knowm.xchange.binance.dto.marketdata.futures.BinanceFutureLongShortRatio;
import org.knowm.xchange.binance.dto.marketdata.futures.BinanceFuturesLeverageBrackets;
import org.knowm.xchange.binance.dto.marketdata.futures.OpenInterestData;
import org.knowm.xchange.binance.dto.meta.BinanceTime;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import org.knowm.xchange.binance.dto.trade.BinanceTrade;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceFutures {

  @GET
  @Path("fapi/v1/ping")
  /**
   * Test connectivity to the Rest API.
   *
   * @return
   * @throws IOException
   */
  Object ping() throws IOException;

  @GET
  @Path("fapi/v1/time")
  /**
   * Test connectivity to the Rest API and get the current server time.
   *
   * @return
   * @throws IOException
   */
  BinanceTime time() throws IOException;

  @GET
  @Path("fapi/v1/exchangeInfo")
  /**
   * Current exchange trading rules and symbol information.
   *
   * @return
   * @throws IOException
   */
  BinanceExchangeInfo exchangeInfo() throws IOException;

  @GET
  @Path("fapi/v1/depth")
  /**
   * @param symbol
   * @param limit optional, default 100; max 100.
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceOrderbook depth(@QueryParam("symbol") String symbol, @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/trades")
  List<BinanceTrade> recentTrades(
      @QueryParam("symbol") String symbol, @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/historicalTrades")
  List<BinanceTrade> historicalTrades(
      @QueryParam("symbol") String symbol,
      @QueryParam("fromId") Long fromId,
      @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/aggTrades")
  /**
   * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with the
   * same price will have the quantity aggregated.<br>
   * If both startTime and endTime are sent, limit should not be sent AND the distance between
   * startTime and endTime must be less than 24 hours.<br>
   * If frondId, startTime, and endTime are not sent, the most recent aggregate trades will be
   * returned.
   *
   * @param symbol
   * @param fromId optional, ID to get aggregate trades from INCLUSIVE.
   * @param startTime optional, Timestamp in ms to get aggregate trades from INCLUSIVE.
   * @param endTime optional, Timestamp in ms to get aggregate trades until INCLUSIVE.
   * @param limit optional, Default 500; max 500.
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceAggTrades> aggTrades(
      @QueryParam("symbol") String symbol,
      @QueryParam("fromId") Long fromId,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/klines")
  /**
   * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.<br>
   * If startTime and endTime are not sent, the most recent klines are returned.
   *
   * @param symbol
   * @param interval
   * @param limit optional, default 500; max 500.
   * @param startTime optional
   * @param endTime optional
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<Object[]> klines(
      @QueryParam("symbol") String symbol,
      @QueryParam("interval") String interval,
      @QueryParam("limit") Integer limit,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/fundingRate")
  /**
   * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.<br>
   * If startTime and endTime are not sent, the most recent klines are returned.
   *
   * @param symbol
   * @param interval
   * @param limit optional, default 500; max 500.
   * @param startTime optional
   * @param endTime optional
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceFundingRate> fundingRate(
      @QueryParam("symbol") String symbol,
      @QueryParam("limit") Integer limit,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/ticker/24hr")
  /**
   * 24 hour price change statistics for all symbols. - bee carreful this api call have a big
   * weight, only about 4 call per minut can be without ban.
   *
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceTicker24h> ticker24h() throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/ticker/24hr")
  /**
   * 24 hour price change statistics.
   *
   * @param symbol
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceTicker24h ticker24h(@QueryParam("symbol") String symbol)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/ticker/bookTicker")
  /**
   * Best price/qty on the order book for all symbols.
   *
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinancePriceQuantity> tickerAllBookTickers() throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/ticker/bookTicker")
  /**
   * Latest price for a symbol or symbols.
   *
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinancePriceQuantity tickerBookTickers(@QueryParam("symbol") String symbol)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/ticker/price")
  /**
   * BLatest price for a symbol or symbol.
   *
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinancePrice> tickerAllPrices() throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/ticker/price")
  /**
   * Best price/qty on the order book for symbol.
   *
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinancePrice tickerPrice(@QueryParam("symbol") String symbol)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/allForceOrders")
  List<BinanceOrder> getAllLiquidationOrders(
      @QueryParam("symbol") String symbol,
      @QueryParam("limit") Integer limit,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/openInterest")
  List<BinanceOrder> openInterest(@QueryParam("symbol") String symbol)
      throws IOException, BinanceException;

  @GET
  @Path("fapi/v1/leverageBracket")
  List<BinanceFuturesLeverageBrackets> leverageBracket(@QueryParam("symbol") String symbol)
      throws IOException, BinanceException;

  @GET
  @Path("futures/data/openInterestHist")
  List<OpenInterestData> openInterestStatistics(
      @QueryParam("symbol") String symbol,
      @QueryParam("period") KlineInterval period,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("futures/data/topLongShortAccountRatio")
  List<BinanceFutureLongShortRatio> topLongShortAccountRatio(
      @QueryParam("symbol") String symbol,
      @QueryParam("period") Long fromId,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("futures/data/topLongShortPositionRatio")
  List<BinanceFutureLongShortRatio> topLongShortPositionRatio(
      @QueryParam("symbol") String symbol,
      @QueryParam("period") Long fromId,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;

  @GET
  @Path("futures/data/globalLongShortAccountRatio")
  List<BinanceFutureLongShortRatio> globalLongShortAccountRatio(
      @QueryParam("symbol") String symbol,
      @QueryParam("period") Long fromId,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("limit") Integer limit)
      throws IOException, BinanceException;
}

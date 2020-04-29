//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.service.futures;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.BinanceMessage;
import org.knowm.xchange.binance.dto.account.futures.BinanceFuturesIncome;
import org.knowm.xchange.binance.dto.account.futures.BinanceFuturesInitialLeverage;
import org.knowm.xchange.binance.dto.account.futures.BinanceFuturesPositionRisk;
import org.knowm.xchange.binance.dto.trade.*;
import org.knowm.xchange.binance.dto.trade.futures.*;
import org.knowm.xchange.currency.CurrencyPair;

public class BinanceFuturesTradeServiceRaw extends BinanceFuturesBaseService {

  protected BinanceFuturesTradeServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public List<BinanceFuturesOrder> openOrders(Long recvWindow, long timestamp)
      throws BinanceException, IOException {
    return binanceFutures.getOpenOrders(
        null, recvWindow, timestamp, this.apiKey, this.signatureCreator);
  }

  public List<BinanceFuturesOrder> openOrders(CurrencyPair pair, Long recvWindow, long timestamp)
      throws BinanceException, IOException {
    return binanceFutures.getOpenOrders(
        BinanceAdapters.toSymbol(pair), recvWindow, timestamp, this.apiKey, this.signatureCreator);
  }

  public BinanceFuturesNewOrder newOrder(
      CurrencyPair pair,
      OrderSide side,
      OrderType type,
      TimeInForce timeInForce,
      BigDecimal quantity,
      BigDecimal price,
      boolean reduceOnly,
      String newClientOrderId,
      BigDecimal stopPrice,
      BigDecimal activationPrice,
      BigDecimal callbackRate,
      WorkingType workingType,
      Long recvWindow,
      long timestamp)
      throws IOException, BinanceException {
    return binanceFutures.newOrder(
        BinanceAdapters.toSymbol(pair),
        side,
        type,
        timeInForce,
        quantity,
        price,
        reduceOnly,
        newClientOrderId,
        stopPrice,
        activationPrice,
        callbackRate,
        workingType,
        recvWindow,
        timestamp,
        this.apiKey,
        this.signatureCreator);
  }

  public BinanceFuturesOrder getOrder(CurrencyPair pair, long orderId, String origClientOrderId)
      throws IOException, BinanceException {
    return binanceFutures.getFuturesOrder(
        BinanceAdapters.toSymbol(pair),
        orderId,
        origClientOrderId,
        getRecvWindow(),
        getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public BinanceFuturesCancelledOrder cancelOrder(
      CurrencyPair pair,
      long orderId,
      String origClientOrderId,
      String newClientOrderId,
      Long recvWindow,
      long timestamp)
      throws IOException, BinanceException {
    return binanceFutures.cancelOrder(
        BinanceAdapters.toSymbol(pair),
        orderId,
        origClientOrderId,
        newClientOrderId,
        recvWindow,
        timestamp,
        this.apiKey,
        this.signatureCreator);
  }

  public BinanceMessage cancelAllOrder(CurrencyPair pair) throws IOException, BinanceException {
    return binanceFutures.cancelAllOrder(
        BinanceAdapters.toSymbol(pair),
        getRecvWindow(),
        getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<BinanceFuturesOrder> getOpenOrders(final CurrencyPair pair) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binanceFutures.getOpenOrders(
        (pair != null) ? BinanceAdapters.toSymbol(pair) : null,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<BinanceFuturesUserTrade> userTrades(
      CurrencyPair pair, Integer limit, Long startTime, Long endTime, Long fromId)
      throws BinanceException, IOException {
    return binanceFutures.userTrades(
        BinanceAdapters.toSymbol(pair),
        startTime,
        endTime,
        fromId,
        limit,
        getRecvWindow(),
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public BinanceMessage changeMargineType(CurrencyPair pair, MarginType marginType)
      throws BinanceException, IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");

    return binanceFutures.changeMargineType(
        BinanceAdapters.toSymbol(pair),
        marginType,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<BinanceFuturesPositionMarginHistory> getPositionMargineChangeHistory(
      CurrencyPair pair,
      PositionMarginType positionMarginType,
      Long startTime,
      Long endTime,
      Integer limit)
      throws BinanceException, IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");

    return binanceFutures.getPositionMarginChangeHistory(
        BinanceAdapters.toSymbol(pair),
        positionMarginType.getCode(),
        startTime,
        endTime,
        limit,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public BinanceFuturesInitialLeverage changeInitialLeverage(CurrencyPair pair, Integer leverage)
      throws BinanceException, IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");

    return binanceFutures.changeInitialLeverage(
        BinanceAdapters.toSymbol(pair),
        leverage,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<BinanceFuturesPositionRisk> getPositionRisk() throws BinanceException, IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");

    return binanceFutures.getPositionRisk(
        recvWindow, this.getTimestamp(), this.apiKey, this.signatureCreator);
  }

  public List<BinanceFuturesIncome> getIncomeHistory(
      CurrencyPair pair, IncomeType incomeType, Long startTime, Long endTime, Integer limit)
      throws BinanceException, IOException {
    return binanceFutures.getIncomeHistory(
        BinanceAdapters.toSymbol(pair),
        incomeType,
        startTime,
        endTime,
        limit,
        getRecvWindow(),
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<BinanceFuturesOrder> allOrders(
      CurrencyPair pair,
      Long orderId,
      Long startTime,
      Long endTime,
      Integer limit,
      Long recvWindow,
      long timestamp)
      throws BinanceException, IOException {
    return binanceFutures.getAllOrders(
        BinanceAdapters.toSymbol(pair),
        orderId,
        startTime,
        endTime,
        limit,
        recvWindow,
        timestamp,
        super.apiKey,
        super.signatureCreator);
  }
}

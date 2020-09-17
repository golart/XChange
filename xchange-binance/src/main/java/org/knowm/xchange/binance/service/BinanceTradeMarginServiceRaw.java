//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.margin.*;
import org.knowm.xchange.binance.dto.trade.*;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class BinanceTradeMarginServiceRaw extends BinanceBaseService {
  protected BinanceTradeMarginServiceRaw(final Exchange exchange) {
    super(exchange);
  }

  public MarginAccount getAccount() throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMarginAccount(
        recvWindow, this.getTimestamp(), this.apiKey, this.signatureCreator);
  }

  public OperationInfo transfer(
      final Currency asset, final BigDecimal amount, final TransferType type) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.transfer(
        BinanceAdapters.toSymbol(asset),
        amount,
        type.getCode(),
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public OperationInfo borrow(final Currency asset, final BigDecimal amount) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.borrow(
        BinanceAdapters.toSymbol(asset),
        amount,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public OperationInfo repay(final Currency asset, final BigDecimal amount) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.repay(
        BinanceAdapters.toSymbol(asset),
        amount,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public BinanceNewOrder newMarginOrder(
      final CurrencyPair pair,
      final OrderSide side,
      final OrderType type,
      final TimeInForce timeInForce,
      final BigDecimal quantity,
      final BigDecimal price,
      final String newClientOrderId,
      final BigDecimal stopPrice,
      final BigDecimal icebergQty)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.newMarginOrder(
        BinanceAdapters.toSymbol(pair),
        side,
        type,
        timeInForce,
        quantity,
        price,
        newClientOrderId,
        stopPrice,
        icebergQty,
        recvWindow,
        this.getTimestamp(),
        super.apiKey,
        super.signatureCreator);
  }

  public BinanceCancelledOrder cancelMarginOrder(
      final CurrencyPair pair,
      final Long orderId,
      final String origClientOrderId,
      final String newClientOrderId)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.cancelMarginOrder(
        BinanceAdapters.toSymbol(pair),
        orderId,
        origClientOrderId,
        newClientOrderId,
        recvWindow,
        this.getTimestamp(),
        super.apiKey,
        super.signatureCreator);
  }

  public LoanRecords getLoanRecords(
      final Currency asset,
      final Long txId,
      final Long startTime,
      final Long endTime,
      final Long current,
      final Long size)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getLoanRecords(
        BinanceAdapters.toSymbol(asset),
        txId,
        startTime,
        endTime,
        current,
        size,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public RepayRecords getRepayRecords(
      final Currency asset,
      final Long txId,
      final Long startTime,
      final Long endTime,
      final Long current,
      final Long size)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getRepayRecords(
        BinanceAdapters.toSymbol(asset),
        txId,
        startTime,
        endTime,
        current,
        size,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public Transfers getTransferHistory(
      final Currency asset,
      final HistoryTransferType type,
      final Long startTime,
      final Long endTime,
      final Long current,
      final Long size)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getTransferHistory(
        (asset != null) ? BinanceAdapters.toSymbol(asset) : null,
        type.toString(),
        startTime,
        endTime,
        current,
        size,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public Interests getInterestHistory(
      final Currency asset,
      final Long startTime,
      final Long endTime,
      final Long current,
      final Long size)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getInterestHistory(
        (asset != null) ? BinanceAdapters.toSymbol(asset) : null,
        startTime,
        endTime,
        current,
        size,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public ForceLiquidationRecs getForceLiquidationRecords(
      final Long startTime, final Long endTime, final Long current, final Long size)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getForceLiquidationRecords(
        startTime,
        endTime,
        current,
        size,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public MarginOrder getMarginOrder(
      final CurrencyPair symbol, final String orderId, final String origClientOrderId)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMarginOrder(
        BinanceAdapters.toSymbol(symbol),
        orderId,
        origClientOrderId,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<MarginOrder> getOpenOrders(final CurrencyPair pair) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getOpenMarginOrders(
        (pair != null) ? BinanceAdapters.toSymbol(pair) : null,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<MarginOrder> getAllMarginOrders(
          final CurrencyPair symbol,
          final String orderId,
          final Long startTime,
          final Long endTime,
          final Integer limit)
          throws IOException, BinanceException {
    final Long recvWindow =
            (Long)
                    this.exchange
                            .getExchangeSpecification()
                            .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getAllMarginOrders(
            BinanceAdapters.toSymbol(symbol),
            orderId,
            startTime,
            endTime,
            limit,
            recvWindow,
            this.getTimestamp(),
            this.apiKey,
            this.signatureCreator);
  }

  public List<BinanceTrade> getTrades(
      final CurrencyPair symbol,
      final Long startTime,
      final Long endTime,
      final Long fromId,
      final Integer limit)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getTrades(
        BinanceAdapters.toSymbol(symbol),
        startTime,
        endTime,
        fromId,
        limit,
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public BigDecimal getMaxBorrow(final Currency asset) throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMaxBorrow(
        BinanceAdapters.toSymbol(asset),
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public BigDecimal getMaxTransferOutAmount(final Currency asset)
      throws IOException, BinanceException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMaxTransferOutAmount(
        BinanceAdapters.toSymbol(asset),
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public MarginAsset getMarginAsset(final Currency asset) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMarginAsset(
        BinanceAdapters.toSymbol(asset),
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public MarginPair getMarginPair(final CurrencyPair symbol) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMarginPair(
        BinanceAdapters.toSymbol(symbol),
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }

  public List<MarginAsset> getAllMarginAssets() throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getAllMarginAssets(
        recvWindow, this.getTimestamp(), this.apiKey, this.signatureCreator);
  }

  public List<MarginPair> getAllMarginPairs() throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getAllMarginPairs(
        recvWindow, this.getTimestamp(), this.apiKey, this.signatureCreator);
  }

  public MarginPriceIndex getMarginPriceIndex(final CurrencyPair pair) throws IOException {
    final Long recvWindow =
        (Long)
            this.exchange
                .getExchangeSpecification()
                .getExchangeSpecificParametersItem("recvWindow");
    return this.binance.getMarginPriceIndex(
        BinanceAdapters.toSymbol(pair),
        recvWindow,
        this.getTimestamp(),
        this.apiKey,
        this.signatureCreator);
  }
}

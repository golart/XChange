// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.dto.trade.BinanceListenKey;
import org.knowm.xchange.binance.dto.trade.BinanceTrade;
import org.knowm.xchange.binance.dto.trade.BinanceCancelledOrder;
import org.knowm.xchange.binance.dto.trade.BinanceNewOrder;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.TimeInForce;
import org.knowm.xchange.binance.dto.trade.OrderType;
import org.knowm.xchange.binance.dto.trade.OrderSide;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.currency.CurrencyPair;
import java.io.IOException;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import java.util.List;
import org.knowm.xchange.Exchange;

public class BinanceTradeServiceRaw extends BinanceBaseService
{
    protected BinanceTradeServiceRaw(final Exchange exchange) {
        super(exchange);
    }
    
    public List<BinanceOrder> openOrders(final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        return this.binance.openOrders(null, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public List<BinanceOrder> openOrders(final CurrencyPair pair, final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        return this.binance.openOrders(BinanceAdapters.toSymbol(pair), recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public BinanceNewOrder newOrder(final CurrencyPair pair, final OrderSide side, final OrderType type, final TimeInForce timeInForce, final BigDecimal quantity, final BigDecimal price, final String newClientOrderId, final BigDecimal stopPrice, final BigDecimal icebergQty, final Long recvWindow, final long timestamp) throws IOException, BinanceException {
        return this.binance.newOrder(BinanceAdapters.toSymbol(pair), side, type, timeInForce, quantity, price, newClientOrderId, stopPrice, icebergQty, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public void testNewOrder(final CurrencyPair pair, final OrderSide side, final OrderType type, final TimeInForce timeInForce, final BigDecimal quantity, final BigDecimal price, final String newClientOrderId, final BigDecimal stopPrice, final BigDecimal icebergQty, final Long recvWindow, final long timestamp) throws IOException, BinanceException {
        this.binance.testNewOrder(BinanceAdapters.toSymbol(pair), side, type, timeInForce, quantity, price, newClientOrderId, stopPrice, icebergQty, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public BinanceOrder orderStatus(final CurrencyPair pair, final long orderId, final String origClientOrderId, final Long recvWindow, final long timestamp) throws IOException, BinanceException {
        return this.binance.orderStatus(BinanceAdapters.toSymbol(pair), orderId, origClientOrderId, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public BinanceCancelledOrder cancelOrder(final CurrencyPair pair, final long orderId, final String origClientOrderId, final String newClientOrderId, final Long recvWindow, final long timestamp) throws IOException, BinanceException {
        return this.binance.cancelOrder(BinanceAdapters.toSymbol(pair), orderId, origClientOrderId, newClientOrderId, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public List<BinanceOrder> allOrders(final CurrencyPair pair, final Long orderId, final Integer limit, final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        return this.binance.allOrders(BinanceAdapters.toSymbol(pair), orderId, limit, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public List<BinanceTrade> myTrades(final CurrencyPair pair, final Integer limit, final Long startTime, final Long endTime, final Long fromId, final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        return this.binance.myTrades(BinanceAdapters.toSymbol(pair), limit, startTime, endTime, fromId, recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public BinanceListenKey startUserDataStream() throws IOException {
        return this.binance.startUserDataStream(this.apiKey);
    }
    
    public void keepAliveDataStream(final String listenKey) throws IOException {
        this.binance.keepAliveUserDataStream(this.apiKey, listenKey);
    }
    
    public void closeDataStream(final String listenKey) throws IOException {
        this.binance.closeUserDataStream(this.apiKey, listenKey);
    }
}

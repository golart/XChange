// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.service.trade.params.orders.OrderQueryParamCurrencyPair;
import org.knowm.xchange.service.trade.params.orders.OrderQueryParams;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import java.util.Collection;
import org.knowm.xchange.binance.dto.trade.BinanceTrade;
import org.knowm.xchange.dto.marketdata.Trades;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.service.trade.params.TradeHistoryParamsTimeSpan;
import org.knowm.xchange.service.trade.params.TradeHistoryParamsIdSpan;
import org.knowm.xchange.service.trade.params.TradeHistoryParamLimit;
import org.knowm.xchange.utils.Assert;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrencyPair;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;
import org.knowm.xchange.service.trade.params.CancelOrderByIdParams;
import org.knowm.xchange.service.trade.params.CancelOrderByCurrencyPair;
import org.knowm.xchange.service.trade.params.CancelOrderParams;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.binance.dto.trade.BinanceOrderFlags;
import java.util.Iterator;
import java.util.Set;
import org.knowm.xchange.dto.trade.StopOrder;
import org.knowm.xchange.binance.dto.trade.BinanceNewOrder;
import org.knowm.xchange.binance.dto.trade.TimeInForce;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.OrderType;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.BinanceErrorAdapter;
import java.util.List;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import java.util.ArrayList;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParamCurrencyPair;
import org.knowm.xchange.service.trade.params.orders.DefaultOpenOrdersParamCurrencyPair;
import org.knowm.xchange.currency.CurrencyPair;
import java.io.IOException;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParams;
import org.knowm.xchange.service.trade.params.orders.DefaultOpenOrdersParam;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.trade.TradeService;

public class BinanceTradeService extends BinanceTradeServiceRaw implements TradeService
{
    public BinanceTradeService(final Exchange exchange) {
        super(exchange);
    }
    
    public OpenOrders getOpenOrders() throws IOException {
        return this.getOpenOrders((OpenOrdersParams)new DefaultOpenOrdersParam());
    }
    
    public OpenOrders getOpenOrders(final CurrencyPair pair) throws IOException {
        return this.getOpenOrders((OpenOrdersParams)new DefaultOpenOrdersParamCurrencyPair(pair));
    }
    
    public OpenOrders getOpenOrders(final OpenOrdersParams params) throws IOException {
        try {
            final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
            List<BinanceOrder> binanceOpenOrders;
            if (params instanceof OpenOrdersParamCurrencyPair) {
                final OpenOrdersParamCurrencyPair pairParams = (OpenOrdersParamCurrencyPair)params;
                final CurrencyPair pair = pairParams.getCurrencyPair();
                binanceOpenOrders = super.openOrders(pair, recvWindow, this.getTimestamp());
            }
            else {
                binanceOpenOrders = super.openOrders(recvWindow, this.getTimestamp());
            }
            final List<LimitOrder> limitOrders = new ArrayList<LimitOrder>();
            final List<Order> otherOrders = new ArrayList<Order>();
            final Order order;
            final List<LimitOrder> list;
            final List<Order> list2;
            binanceOpenOrders.forEach(binanceOrder -> {
                order = BinanceAdapters.adaptOrder(binanceOrder);
                if (order instanceof LimitOrder) {
                    list.add((LimitOrder)order);
                }
                else {
                    list2.add(order);
                }
                return;
            });
            return new OpenOrders((List)limitOrders, (List)otherOrders);
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public String placeMarketOrder(final MarketOrder mo) throws IOException {
        return Long.toString(this.placeOrder(OrderType.MARKET, (Order)mo, null, null, null).orderId);
    }
    
    public BinanceNewOrder placeMarketOrder2(final MarketOrder mo) throws IOException {
        return this.placeOrder(OrderType.MARKET, (Order)mo, null, null, null);
    }
    
    public String placeStopOrder(final StopOrder so) throws IOException {
        TimeInForce tif = null;
        final Set<Order.IOrderFlags> orderFlags = (Set<Order.IOrderFlags>)so.getOrderFlags();
        for (final Order.IOrderFlags orderFlag : orderFlags) {
            if (orderFlag instanceof TimeInForce) {
                tif = (TimeInForce)orderFlag;
            }
        }
        if (so.getLimitPrice() != null && tif == null) {
            tif = TimeInForce.GTC;
        }
        OrderType orderType;
        if (so.getType().equals((Object)Order.OrderType.BID)) {
            orderType = ((so.getLimitPrice() == null) ? OrderType.TAKE_PROFIT : OrderType.TAKE_PROFIT_LIMIT);
        }
        else {
            orderType = ((so.getLimitPrice() == null) ? OrderType.STOP_LOSS : OrderType.STOP_LOSS_LIMIT);
        }
        return Long.toString(this.placeOrder(orderType, (Order)so, so.getLimitPrice(), so.getStopPrice(), tif).orderId);
    }
    
    private BinanceNewOrder placeOrder(final OrderType type, final Order order, final BigDecimal limitPrice, final BigDecimal stopPrice, final TimeInForce tif) throws IOException {
        try {
            final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
            return this.newOrder(order.getCurrencyPair(), BinanceAdapters.convert(order.getType()), type, tif, order.getOriginalAmount(), limitPrice, this.getClientOrderId(order), stopPrice, null, recvWindow, this.getTimestamp());
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public String placeLimitOrder(final LimitOrder lo) throws IOException {
        return Long.toString(this.placeLimitOrder2(lo).orderId);
    }
    
    public BinanceNewOrder placeLimitOrder2(final LimitOrder lo) throws IOException {
        TimeInForce tif = TimeInForce.GTC;
        OrderType type;
        if (lo.hasFlag((Order.IOrderFlags)org.knowm.xchange.binance.dto.trade.BinanceOrderFlags.LIMIT_MAKER)) {
            type = OrderType.LIMIT_MAKER;
            tif = null;
        }
        else {
            type = OrderType.LIMIT;
            final Set<Order.IOrderFlags> orderFlags = (Set<Order.IOrderFlags>)lo.getOrderFlags();
            for (final Order.IOrderFlags orderFlag : orderFlags) {
                if (orderFlag instanceof TimeInForce) {
                    tif = (TimeInForce)orderFlag;
                }
            }
        }
        return this.placeOrder(type, (Order)lo, lo.getLimitPrice(), null, tif);
    }
    
    public void placeTestOrder(final OrderType type, final Order order, final BigDecimal limitPrice, final BigDecimal stopPrice) throws IOException {
        try {
            final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
            this.testNewOrder(order.getCurrencyPair(), BinanceAdapters.convert(order.getType()), type, TimeInForce.GTC, order.getOriginalAmount(), limitPrice, this.getClientOrderId(order), stopPrice, null, recvWindow, this.getTimestamp());
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    private String getClientOrderId(final Order order) {
        String clientOrderId = null;
        for (final Order.IOrderFlags flags : order.getOrderFlags()) {
            if (flags instanceof BinanceOrderFlags) {
                final BinanceOrderFlags bof = (BinanceOrderFlags)flags;
                if (clientOrderId != null) {
                    continue;
                }
                clientOrderId = bof.getClientId();
            }
        }
        return clientOrderId;
    }
    
    public boolean cancelOrder(final String orderId) {
        throw new ExchangeException("You need to provide the currency pair to cancel an order.");
    }
    
    public boolean cancelOrder(final CancelOrderParams params) throws IOException {
        try {
            if (!(params instanceof CancelOrderByCurrencyPair) && !(params instanceof CancelOrderByIdParams)) {
                throw new ExchangeException("You need to provide the currency pair and the order id to cancel an order.");
            }
            final CancelOrderByCurrencyPair paramCurrencyPair = (CancelOrderByCurrencyPair)params;
            final CancelOrderByIdParams paramId = (CancelOrderByIdParams)params;
            final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
            super.cancelOrder(paramCurrencyPair.getCurrencyPair(), BinanceAdapters.id(paramId.getOrderId()), null, null, recvWindow, this.getTimestamp());
            return true;
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public UserTrades getTradeHistory(final TradeHistoryParams params) throws IOException {
        try {
            Assert.isTrue(params instanceof TradeHistoryParamCurrencyPair, "You need to provide the currency pair to get the user trades.");
            final TradeHistoryParamCurrencyPair pairParams = (TradeHistoryParamCurrencyPair)params;
            final CurrencyPair pair = pairParams.getCurrencyPair();
            if (pair == null) {
                throw new ExchangeException("You need to provide the currency pair to get the user trades.");
            }
            Integer limit = null;
            if (params instanceof TradeHistoryParamLimit) {
                final TradeHistoryParamLimit limitParams = (TradeHistoryParamLimit)params;
                limit = limitParams.getLimit();
            }
            Long fromId = null;
            if (params instanceof TradeHistoryParamsIdSpan) {
                final TradeHistoryParamsIdSpan idParams = (TradeHistoryParamsIdSpan)params;
                try {
                    fromId = BinanceAdapters.id(idParams.getStartId());
                }
                catch (Throwable t2) {}
            }
            Long startTime = null;
            Long endTime = null;
            if (params instanceof TradeHistoryParamsTimeSpan) {
                if (((TradeHistoryParamsTimeSpan)params).getStartTime() != null) {
                    startTime = ((TradeHistoryParamsTimeSpan)params).getStartTime().getTime();
                }
                if (((TradeHistoryParamsTimeSpan)params).getEndTime() != null) {
                    endTime = ((TradeHistoryParamsTimeSpan)params).getEndTime().getTime();
                }
            }
            if (fromId != null && (startTime != null || endTime != null)) {
                throw new ExchangeException("You should either specify the id from which you get the user trades from or start and end times. If you specify both, Binance will only honour the fromId parameter.");
            }
            final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
            final List<BinanceTrade> binanceTrades = super.myTrades(pair, limit, startTime, endTime, fromId, recvWindow, this.getTimestamp());
            final List<UserTrade> trades = binanceTrades.stream().map(t -> new UserTrade(BinanceAdapters.convertType(t.isBuyer), t.qty, pair, t.price, t.getTime(), Long.toString(t.id), Long.toString(t.orderId), t.commission, t.commissionAsset)).collect((Collector<? super Object, ?, List<UserTrade>>)Collectors.toList());
            final long lastId = binanceTrades.stream().map(t -> t.id).max(Long::compareTo).orElse(0L);
            return new UserTrades((List)trades, lastId, Trades.TradeSortType.SortByTimestamp);
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public TradeHistoryParams createTradeHistoryParams() {
        return (TradeHistoryParams)new BinanceTradeHistoryParams();
    }
    
    public OpenOrdersParams createOpenOrdersParams() {
        return (OpenOrdersParams)new DefaultOpenOrdersParamCurrencyPair();
    }
    
    public Collection<Order> getOrder(final String... orderIds) {
        throw new NotAvailableFromExchangeException();
    }
    
    public Collection<Order> getOrder(final OrderQueryParams... params) throws IOException {
        try {
            final Collection<Order> orders = new ArrayList<Order>();
            for (final OrderQueryParams param : params) {
                if (!(param instanceof OrderQueryParamCurrencyPair)) {
                    throw new ExchangeException("Parameters must be an instance of OrderQueryParamCurrencyPair");
                }
                final OrderQueryParamCurrencyPair orderQueryParamCurrencyPair = (OrderQueryParamCurrencyPair)param;
                if (orderQueryParamCurrencyPair.getCurrencyPair() == null || orderQueryParamCurrencyPair.getOrderId() == null) {
                    throw new ExchangeException("You need to provide the currency pair and the order id to query an order.");
                }
                orders.add(BinanceAdapters.adaptOrder(super.orderStatus(orderQueryParamCurrencyPair.getCurrencyPair(), BinanceAdapters.id(orderQueryParamCurrencyPair.getOrderId()), null, (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow"), this.getTimestamp())));
            }
            return orders;
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public interface BinanceOrderFlags extends Order.IOrderFlags
    {
        String getClientId();
    }
}

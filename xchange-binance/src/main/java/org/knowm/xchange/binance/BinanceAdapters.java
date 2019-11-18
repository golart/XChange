// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.List;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.binance.dto.marketdata.BinancePriceQuantity;
import java.util.Set;
import org.knowm.xchange.binance.service.BinanceTradeService;
import java.util.HashSet;
import org.knowm.xchange.dto.trade.StopOrder;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.BinanceOrderType;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import org.knowm.xchange.binance.dto.trade.BinanceOrderStatus;
import java.util.Iterator;
import java.util.Arrays;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.binance.dto.trade.OrderSide;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

public class BinanceAdapters
{
    private BinanceAdapters() {
    }
    
    public static String toSymbol(final CurrencyPair pair) {
        if (pair.equals((Object)CurrencyPair.IOTA_BTC)) {
            return "IOTABTC";
        }
        return pair.base.getCurrencyCode() + pair.counter.getCurrencyCode();
    }
    
    public static String toSymbol(final Currency currency) {
        if (Currency.IOT.equals((Object)currency)) {
            return "IOTA";
        }
        return currency.getSymbol();
    }
    
    public static Order.OrderType convert(final OrderSide side) {
        switch (side) {
            case BUY: {
                return Order.OrderType.BID;
            }
            case SELL: {
                return Order.OrderType.ASK;
            }
            default: {
                throw new RuntimeException("Not supported order side: " + side);
            }
        }
    }
    
    public static OrderSide convert(final Order.OrderType type) {
        switch (type) {
            case ASK: {
                return OrderSide.SELL;
            }
            case BID: {
                return OrderSide.BUY;
            }
            default: {
                throw new RuntimeException("Not supported order type: " + type);
            }
        }
    }
    
    public static CurrencyPair convert(final String symbol) {
        for (final Currency base : Arrays.asList(Currency.BTC, Currency.ETH, Currency.BNB, Currency.USDT)) {
            if (symbol.contains(base.toString())) {
                final String counter = symbol.replace(base.toString(), "");
                return new CurrencyPair(base, new Currency(counter));
            }
        }
        throw new IllegalArgumentException("Could not parse currency pair from '" + symbol + "'");
    }
    
    public static long id(final String id) {
        try {
            return Long.valueOf(id);
        }
        catch (Throwable e) {
            throw new RuntimeException("Binance id must be a valid long number.", e);
        }
    }
    
    public static Order.OrderStatus adaptOrderStatus(final BinanceOrderStatus orderStatus) {
        switch (orderStatus) {
            case NEW: {
                return Order.OrderStatus.NEW;
            }
            case FILLED: {
                return Order.OrderStatus.FILLED;
            }
            case EXPIRED: {
                return Order.OrderStatus.EXPIRED;
            }
            case CANCELED: {
                return Order.OrderStatus.CANCELED;
            }
            case REJECTED: {
                return Order.OrderStatus.REJECTED;
            }
            case PENDING_CANCEL: {
                return Order.OrderStatus.PENDING_CANCEL;
            }
            case PARTIALLY_FILLED: {
                return Order.OrderStatus.PARTIALLY_FILLED;
            }
            default: {
                return Order.OrderStatus.UNKNOWN;
            }
        }
    }
    
    public static Order.OrderType convertType(final boolean isBuyer) {
        return isBuyer ? Order.OrderType.BID : Order.OrderType.ASK;
    }
    
    public static CurrencyPair adaptSymbol(final String symbol) {
        final int pairLength = symbol.length();
        if (symbol.endsWith("USDT")) {
            return new CurrencyPair(symbol.substring(0, pairLength - 4), "USDT");
        }
        if (symbol.endsWith("TUSD")) {
            return new CurrencyPair(symbol.substring(0, pairLength - 4), "TUSD");
        }
        if (symbol.endsWith("USDS")) {
            return new CurrencyPair(symbol.substring(0, pairLength - 4), "USDS");
        }
        if (symbol.endsWith("USDC")) {
            return new CurrencyPair(symbol.substring(0, pairLength - 4), "USDC");
        }
        return new CurrencyPair(symbol.substring(0, pairLength - 3), symbol.substring(pairLength - 3));
    }
    
    public static Order adaptOrder(final BinanceOrder order) {
        final Order.OrderType type = convert(order.side);
        final CurrencyPair currencyPair = adaptSymbol(order.symbol);
        final Order.OrderStatus orderStatus = adaptOrderStatus(order.bStatus);
        BigDecimal averagePrice;
        if (order.executedQty.signum() == 0 || order.bType.equals(BinanceOrderType.MARKET)) {
            averagePrice = BigDecimal.ZERO;
        }
        else {
            averagePrice = order.price;
        }
        Order result;
        if (order.bType.equals(BinanceOrderType.MARKET)) {
            result = (Order)new MarketOrder(type, order.origQty, currencyPair, Long.toString(order.orderId), order.getTime(), averagePrice, order.executedQty, BigDecimal.ZERO, orderStatus);
        }
        else if (order.bType.equals(BinanceOrderType.LIMIT) || order.bType.equals(BinanceOrderType.LIMIT_MAKER)) {
            result = (Order)new LimitOrder(type, order.origQty, currencyPair, Long.toString(order.orderId), order.getTime(), order.price, averagePrice, order.executedQty, BigDecimal.ZERO, orderStatus);
        }
        else {
            result = (Order)new StopOrder(type, order.origQty, currencyPair, Long.toString(order.orderId), order.getTime(), order.stopPrice, averagePrice, order.executedQty, orderStatus);
        }
        final Set<Order.IOrderFlags> flags = new HashSet<Order.IOrderFlags>();
        if (order.clientOrderId != null) {
            flags.add((Order.IOrderFlags)new BinanceTradeService.BinanceOrderFlags() {
                @Override
                public String getClientId() {
                    return order.clientOrderId;
                }
            });
        }
        result.setOrderFlags((Set)flags);
        return result;
    }
    
    private static Ticker adaptPriceQuantity(final BinancePriceQuantity priceQuantity) {
        return new Ticker.Builder().currencyPair(adaptSymbol(priceQuantity.symbol)).ask(priceQuantity.askPrice).askSize(priceQuantity.askQty).bid(priceQuantity.bidPrice).bidSize(priceQuantity.bidQty).build();
    }
    
    public static List<Ticker> adaptPriceQuantities(final List<BinancePriceQuantity> priceQuantities) {
        return priceQuantities.stream().map((Function<? super Object, ?>)BinanceAdapters::adaptPriceQuantity).collect((Collector<? super Object, ?, List<Ticker>>)Collectors.toList());
    }
}

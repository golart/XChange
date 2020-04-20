package org.knowm.xchange.exmo.service;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.exmo.holder.ExmoMarketDataHolder;
import org.knowm.xchange.utils.DateUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExmoAdapters {
  public static UserTrade adaptTrade(Map<String, String> tradeDatum, CurrencyPair currencyPair) {
    Order.OrderType type = adaptOrderType(tradeDatum);
    BigDecimal amount = new BigDecimal(tradeDatum.get("quantity"));
    BigDecimal price = new BigDecimal(tradeDatum.get("price"));
    Date date = DateUtils.fromUnixTime(Long.valueOf(tradeDatum.get("date")));
    String tradeId = tradeDatum.get("trade_id");
    String orderId = tradeDatum.get("order_id");
    BigDecimal feeAmount = new BigDecimal(tradeDatum.get("commission_amount"));
    Currency feeCurrency = Currency.getInstance(tradeDatum.get("commission_currency"));

    return new UserTrade(
            type, amount, currencyPair, price, date, tradeId, orderId, feeAmount, feeCurrency);
  }

  public static Order.OrderType adaptOrderType(Map<String, String> order) {
    return order.get("type").equals("sell") ? Order.OrderType.ASK : Order.OrderType.BID;
  }

  public static Balance adaptBalance(
      Map<String, String> balances, Map<String, String> reserved, String ccy) {
    Currency currency = Currency.getInstance(ccy);
    BigDecimal available = new BigDecimal(balances.get(ccy));
    BigDecimal frozen = new BigDecimal(reserved.get(ccy));

    return new Balance(currency, available.add(frozen), available, frozen);
  }

  public static List<LimitOrder> adaptOrders(
      CurrencyPair currencyPair, Map<String, Object> orderBookData, Order.OrderType type) {
    List<LimitOrder> orders = new ArrayList<>();
    for (List<String> orderData :
        (List<List<String>>) orderBookData.get(type.equals(Order.OrderType.ASK) ? "ask" : "bid")) {
      BigDecimal price = new BigDecimal(orderData.get(0));
      BigDecimal quantity = new BigDecimal(orderData.get(1));
      orders.add(new LimitOrder(type, quantity, currencyPair, null, null, price));
    }
    return orders;
  }

  public static Ticker adaptTicker(CurrencyPair currencyPair, Map<String, String> data) {

    final BigDecimal last = new BigDecimal(data.get("last_trade"));
    final BigDecimal buyPrice = new BigDecimal(data.get("buy_price"));

    BigDecimal priceChange = null;
    BigDecimal priceChangePercent = null;

    if (ExmoMarketDataHolder.getCloseBuyPrice(currencyPair) != null) {
      final BigDecimal prevDay = ExmoMarketDataHolder.getCloseBuyPrice(currencyPair);
      if (prevDay.compareTo(BigDecimal.ZERO) != 0) {
        priceChange = buyPrice.subtract(prevDay);
        priceChangePercent =
            priceChange.divide(prevDay, 4, RoundingMode.CEILING).multiply(BigDecimal.valueOf(100L));
      }
    }
    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .ask(new BigDecimal(data.get("sell_price")))
        .bid(buyPrice)
        .high(new BigDecimal(data.get("high")))
        .last(last)
        .priceChangePercent(priceChangePercent)
        .priceChange(priceChange)
        .low(new BigDecimal(data.get("low")))
        .volume(new BigDecimal(data.get("vol")))
        .quoteVolume(new BigDecimal(data.get("vol_curr")))
        .timestamp(DateUtils.fromMillisUtc(Long.valueOf(data.get("updated"))))
        .build();
  }

  public static String format(CurrencyPair currencyPair) {
    return currencyPair.base.getCurrencyCode() + "_" + currencyPair.counter.getCurrencyCode();
  }
}

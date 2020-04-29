package org.knowm.xchange.binance.service.trade;

import java.io.IOException;
import java.math.BigDecimal;
import org.junit.BeforeClass;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.binance.BinanceExchange;
import org.knowm.xchange.binance.service.BinanceTradeService;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.MarketOrder;

public class TradeFuturesServiceIntegration {

  static Exchange exchange;
  static BinanceTradeService tradeService;

  @BeforeClass
  public static void beforeClass() {
    exchange = ExchangeFactory.INSTANCE.createExchange(BinanceExchange.class.getName());
    tradeService = (BinanceTradeService) exchange.getTradeService();
  }

  @Test
  public void test3() throws IOException {
    MarketOrder marketOrderBut =
        new MarketOrder.Builder(Order.OrderType.BID, CurrencyPair.ETH_USDT)
            .originalAmount(BigDecimal.valueOf(0.1))
            .build();
    String idBuy = tradeService.placeMarketOrder(marketOrderBut);
    String a = "weg";
    //    tradeService.cancelOrder(new BinanceCancelOrderParams(CurrencyPair.ETH_USDT, idSell));

    MarketOrder marketOrderSell =
        new MarketOrder.Builder(Order.OrderType.ASK, CurrencyPair.ETH_USDT)
            .originalAmount(BigDecimal.valueOf(0.1))
            .build();
    String idSell = tradeService.placeMarketOrder(marketOrderSell);
    //    tradeService.cancelOrder(new BinanceCancelOrderParams(CurrencyPair.ETH_USDT, idSell));
  }
}

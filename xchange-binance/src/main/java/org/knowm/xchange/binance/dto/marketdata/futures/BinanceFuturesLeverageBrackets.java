package org.knowm.xchange.binance.dto.marketdata.futures;

import java.util.List;

/** @author VKozlov */
public class BinanceFuturesLeverageBrackets {

  public final String symbol;
  public List<BinanceFuturesLeverageBracket> brackets;

  public BinanceFuturesLeverageBrackets(
      String symbol, List<BinanceFuturesLeverageBracket> brackets) {
    this.symbol = symbol;
    this.brackets = brackets;
  }
}

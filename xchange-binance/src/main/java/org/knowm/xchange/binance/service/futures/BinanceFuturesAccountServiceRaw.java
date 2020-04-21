package org.knowm.xchange.binance.service.futures;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.futures.BinanceFuturesAccountInformation;
import org.knowm.xchange.binance.dto.account.futures.BinanceFuturesBalance;

public class BinanceFuturesAccountServiceRaw extends BinanceFuturesBaseService {

  public BinanceFuturesAccountServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public BinanceFuturesAccountInformation account() throws BinanceException, IOException {
    return binanceFutures.getAccountInformation(
        getRecvWindow(), getTimestamp(), super.apiKey, super.signatureCreator);
  }

  public List<BinanceFuturesBalance> balance() throws BinanceException, IOException {
    return binanceFutures.balance(
        getRecvWindow(), this.getTimestamp(), this.apiKey, this.signatureCreator);
  }
}

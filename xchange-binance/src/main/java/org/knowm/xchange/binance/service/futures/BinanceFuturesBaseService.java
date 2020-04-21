package org.knowm.xchange.binance.service.futures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.BinanceFuturesAuthenticated;
import org.knowm.xchange.binance.BinanceFuturesExchange;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import org.knowm.xchange.binance.service.BinanceHmacDigest;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

public class BinanceFuturesBaseService extends BaseExchangeService implements BaseService {

  protected final Logger LOG = LoggerFactory.getLogger(getClass());

  protected final String apiKey;
  protected final BinanceFuturesAuthenticated binanceFutures;
  protected final ParamsDigest signatureCreator;

  protected BinanceFuturesBaseService(Exchange exchange) {

    super(exchange);
    this.binanceFutures =
        RestProxyFactory.createProxy(
            BinanceFuturesAuthenticated.class,
            exchange.getExchangeSpecification().getSslUri(),
            getClientConfig());
    this.apiKey = exchange.getExchangeSpecification().getApiKey();
    this.signatureCreator =
        BinanceHmacDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
  }

  public long getTimestamp() throws IOException {

    long deltaServerTime = ((BinanceFuturesExchange) exchange).deltaServerTime();
    Date systemTime = new Date(System.currentTimeMillis());
    Date serverTime = new Date(systemTime.getTime() + deltaServerTime);
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    LOG.trace(
        "getTimestamp: {} + {} => {}",
        df.format(systemTime),
        deltaServerTime,
        df.format(serverTime));
    return serverTime.getTime();
  }

  public Long getRecvWindow() {
    return (Long)
        exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
  }

  /**
   * After period of time, the deltaServerTime may not accurate again. Need to catch the "Timestamp
   * for this request was 1000ms ahead" exception and refresh the deltaServerTime.
   */
  public void refreshTimestamp() {
    ((BinanceFuturesExchange) exchange).clearDeltaServerTime();
  }

  public BinanceExchangeInfo getExchangeInfo() throws IOException {
    return binanceFutures.exchangeInfo();
  }
}

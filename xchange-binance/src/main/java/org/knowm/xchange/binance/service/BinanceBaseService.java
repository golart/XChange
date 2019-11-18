// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.knowm.xchange.binance.BinanceExchange;
import si.mazi.rescu.RestProxyFactory;
import si.mazi.rescu.Interceptor;
import org.slf4j.LoggerFactory;
import org.knowm.xchange.Exchange;
import si.mazi.rescu.ParamsDigest;
import org.knowm.xchange.binance.BinanceAuthenticated;
import org.slf4j.Logger;
import org.knowm.xchange.service.BaseService;
import org.knowm.xchange.service.BaseExchangeService;

public class BinanceBaseService extends BaseExchangeService implements BaseService
{
    protected final Logger LOG;
    protected final String apiKey;
    protected final BinanceAuthenticated binance;
    protected final ParamsDigest signatureCreator;
    
    protected BinanceBaseService(final Exchange exchange) {
        super(exchange);
        this.LOG = LoggerFactory.getLogger((Class)this.getClass());
        this.binance = (BinanceAuthenticated)RestProxyFactory.createProxy((Class)BinanceAuthenticated.class, exchange.getExchangeSpecification().getSslUri(), this.getClientConfig(), new Interceptor[0]);
        this.apiKey = exchange.getExchangeSpecification().getApiKey();
        this.signatureCreator = (ParamsDigest)BinanceHmacDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    }
    
    public long getTimestamp() throws IOException {
        final long deltaServerTime = ((BinanceExchange)this.exchange).deltaServerTime();
        final Date systemTime = new Date(System.currentTimeMillis());
        final Date serverTime = new Date(systemTime.getTime() + deltaServerTime);
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        this.LOG.trace("getTimestamp: {} + {} => {}", new Object[] { df.format(systemTime), deltaServerTime, df.format(serverTime) });
        return serverTime.getTime();
    }
    
    public void refreshTimestamp() {
        ((BinanceExchange)this.exchange).clearDeltaServerTime();
    }
    
    public BinanceExchangeInfo getExchangeInfo() throws IOException {
        return this.binance.exchangeInfo();
    }
}

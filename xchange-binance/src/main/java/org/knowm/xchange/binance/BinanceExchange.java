// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance;

import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import si.mazi.rescu.RestProxyFactory;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.Filter;
import org.knowm.xchange.binance.dto.account.AssetDetail;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.Symbol;
import java.util.Map;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.meta.FeeTier;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import java.util.Arrays;
import java.math.BigDecimal;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.AuthUtils;
import org.knowm.xchange.ExchangeSpecification;
import si.mazi.rescu.SynchronizedValueFactory;
import org.knowm.xchange.binance.service.BinanceAccountService;
import org.knowm.xchange.binance.service.BinanceTradeService;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.service.BinanceMarketDataService;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import org.knowm.xchange.binance.service.BinanceTradeMarginService;
import org.slf4j.Logger;
import org.knowm.xchange.BaseExchange;

public class BinanceExchange extends BaseExchange
{
    private static final Logger LOG;
    protected BinanceTradeMarginService marginTradeService;
    private BinanceExchangeInfo exchangeInfo;
    private Long deltaServerTimeExpire;
    private Long deltaServerTime;
    
    protected void initServices() {
        this.marketDataService = (MarketDataService)new BinanceMarketDataService((Exchange)this);
        this.tradeService = (TradeService)new BinanceTradeService((Exchange)this);
        this.accountService = (AccountService)new BinanceAccountService((Exchange)this);
        this.marginTradeService = new BinanceTradeMarginService((Exchange)this);
    }
    
    public SynchronizedValueFactory<Long> getNonceFactory() {
        throw new UnsupportedOperationException("Binance uses timestamp/recvwindow rather than a nonce");
    }
    
    public ExchangeSpecification getDefaultExchangeSpecification() {
        final ExchangeSpecification spec = new ExchangeSpecification(this.getClass().getCanonicalName());
        spec.setSslUri("https://api.binance.com");
        spec.setHost("www.binance.com");
        spec.setPort(80);
        spec.setExchangeName("Binance");
        spec.setExchangeDescription("Binance Exchange.");
        AuthUtils.setApiAndSecretKey(spec, "binance");
        return spec;
    }
    
    public BinanceExchangeInfo getExchangeInfo() {
        return this.exchangeInfo;
    }
    
    public void remoteInit() {
        try {
            final Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = (Map<CurrencyPair, CurrencyPairMetaData>)this.exchangeMetaData.getCurrencyPairs();
            final Map<Currency, CurrencyMetaData> currencies = (Map<Currency, CurrencyMetaData>)this.exchangeMetaData.getCurrencies();
            final BinanceMarketDataService marketDataService = (BinanceMarketDataService)this.marketDataService;
            this.exchangeInfo = marketDataService.getExchangeInfo();
            final Symbol[] symbols = this.exchangeInfo.getSymbols();
            final BinanceAccountService accountService = (BinanceAccountService)this.getAccountService();
            final Map<String, AssetDetail> assetDetailMap = accountService.getAssetDetails();
            for (final Symbol symbol : symbols) {
                if (symbol.getStatus().equals("TRADING")) {
                    final int basePrecision = Integer.parseInt(symbol.getBaseAssetPrecision());
                    final int counterPrecision = Integer.parseInt(symbol.getQuotePrecision());
                    int pairPrecision = 8;
                    int amountPrecision = 8;
                    BigDecimal minQty = null;
                    BigDecimal maxQty = null;
                    BigDecimal stepSize = null;
                    BigDecimal counterMinQty = null;
                    BigDecimal counterMaxQty = null;
                    final Filter[] filters = symbol.getFilters();
                    final CurrencyPair currentCurrencyPair = new CurrencyPair(symbol.getBaseAsset(), symbol.getQuoteAsset());
                    for (final Filter filter : filters) {
                        if (filter.getFilterType().equals("PRICE_FILTER")) {
                            pairPrecision = Math.min(pairPrecision, this.numberOfDecimals(filter.getTickSize()));
                        }
                        else if (filter.getFilterType().equals("LOT_SIZE")) {
                            amountPrecision = Math.min(amountPrecision, this.numberOfDecimals(filter.getMinQty()));
                            minQty = new BigDecimal(filter.getMinQty()).stripTrailingZeros();
                            maxQty = new BigDecimal(filter.getMaxQty()).stripTrailingZeros();
                            stepSize = new BigDecimal(filter.getStepSize()).stripTrailingZeros();
                        }
                        else if (filter.getFilterType().equals("MARKET_LOT_SIZE")) {
                            counterMinQty = new BigDecimal(filter.getMinQty()).stripTrailingZeros();
                            counterMaxQty = new BigDecimal(filter.getMaxQty()).stripTrailingZeros();
                        }
                    }
                    final boolean marketOrderAllowed = Arrays.asList(symbol.getOrderTypes()).contains("MARKET");
                    currencyPairs.put(currentCurrencyPair, new CurrencyPairMetaData(new BigDecimal("0.1"), minQty, maxQty, counterMinQty, counterMaxQty, Integer.valueOf(amountPrecision), Integer.valueOf(pairPrecision), (FeeTier[])null, stepSize, (Currency)null, marketOrderAllowed));
                    final Currency baseCurrency = currentCurrencyPair.base;
                    final BigDecimal baseWithdrawalFee = this.getWithdrawalFee(currencies, baseCurrency, assetDetailMap);
                    currencies.put(baseCurrency, new CurrencyMetaData(Integer.valueOf(basePrecision), baseWithdrawalFee));
                    final Currency counterCurrency = currentCurrencyPair.counter;
                    final BigDecimal counterWithdrawalFee = this.getWithdrawalFee(currencies, counterCurrency, assetDetailMap);
                    currencies.put(counterCurrency, new CurrencyMetaData(Integer.valueOf(counterPrecision), counterWithdrawalFee));
                }
            }
        }
        catch (Exception e) {
            throw new ExchangeException("Failed to initialize: " + e.getMessage(), (Throwable)e);
        }
    }
    
    private BigDecimal getWithdrawalFee(final Map<Currency, CurrencyMetaData> currencies, final Currency currency, final Map<String, AssetDetail> assetDetailMap) {
        if (assetDetailMap != null) {
            final AssetDetail asset = assetDetailMap.get(currency.getCurrencyCode());
            return (asset != null) ? asset.getWithdrawFee().stripTrailingZeros() : null;
        }
        return currencies.containsKey(currency) ? currencies.get(currency).getWithdrawalFee() : null;
    }
    
    private int numberOfDecimals(final String value) {
        return new BigDecimal(value).stripTrailingZeros().scale();
    }
    
    public void clearDeltaServerTime() {
        this.deltaServerTime = null;
    }
    
    public long deltaServerTime() throws IOException {
        if (this.deltaServerTime == null || this.deltaServerTimeExpire <= System.currentTimeMillis()) {
            final Binance binance = (Binance)RestProxyFactory.createProxy((Class)Binance.class, this.getExchangeSpecification().getSslUri());
            final Date serverTime = new Date(binance.time().getServerTime().getTime());
            final Date systemTime = new Date(System.currentTimeMillis());
            this.deltaServerTimeExpire = systemTime.getTime() + TimeUnit.MINUTES.toMillis(10L);
            this.deltaServerTime = serverTime.getTime() - systemTime.getTime();
            final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            BinanceExchange.LOG.trace("deltaServerTime: {} - {} => {}", new Object[] { df.format(serverTime), df.format(systemTime), this.deltaServerTime });
        }
        return this.deltaServerTime;
    }
    
    public BinanceTradeMarginService getMarginTradeService() {
        return this.marginTradeService;
    }
    
    static {
        LOG = LoggerFactory.getLogger((Class)BinanceExchange.class);
    }
}

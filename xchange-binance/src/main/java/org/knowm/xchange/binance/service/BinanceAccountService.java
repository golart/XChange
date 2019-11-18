// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.dto.account.BinanceBalance;
import org.knowm.xchange.binance.dto.account.WithdrawList;
import org.knowm.xchange.binance.dto.account.DepositList;
import java.util.ArrayList;
import org.knowm.xchange.service.trade.params.HistoryParamsFundingType;
import org.knowm.xchange.service.trade.params.TradeHistoryParamsTimeSpan;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrency;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;
import org.knowm.xchange.binance.dto.account.AssetDetail;
import org.knowm.xchange.binance.dto.account.DepositAddress;
import org.knowm.xchange.service.trade.params.RippleWithdrawFundsParams;
import org.knowm.xchange.service.trade.params.WithdrawFundsParams;
import org.knowm.xchange.service.trade.params.DefaultWithdrawFundsParams;
import org.knowm.xchange.dto.account.AddressWithTag;
import java.math.BigDecimal;
import org.knowm.xchange.currency.Currency;
import java.util.HashMap;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.currency.CurrencyPair;
import java.util.Map;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.BinanceErrorAdapter;
import java.util.Collection;
import org.knowm.xchange.dto.account.Wallet;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.knowm.xchange.dto.account.Balance;
import java.util.List;
import org.knowm.xchange.dto.account.AccountInfo;
import java.io.IOException;
import org.knowm.xchange.binance.dto.account.BinanceAccountInformation;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.account.AccountService;

public class BinanceAccountService extends BinanceAccountServiceRaw implements AccountService
{
    public BinanceAccountService(final Exchange exchange) {
        super(exchange);
    }
    
    private static FundingRecord.Status withdrawStatus(final int status) {
        switch (status) {
            case 0:
            case 2:
            case 4: {
                return FundingRecord.Status.PROCESSING;
            }
            case 1: {
                return FundingRecord.Status.CANCELLED;
            }
            case 3:
            case 5: {
                return FundingRecord.Status.FAILED;
            }
            case 6: {
                return FundingRecord.Status.COMPLETE;
            }
            default: {
                throw new RuntimeException("Unknown binance withdraw status: " + status);
            }
        }
    }
    
    private static FundingRecord.Status depositStatus(final int status) {
        switch (status) {
            case 0: {
                return FundingRecord.Status.PROCESSING;
            }
            case 1: {
                return FundingRecord.Status.COMPLETE;
            }
            default: {
                throw new RuntimeException("Unknown binance deposit status: " + status);
            }
        }
    }
    
    private BinanceAccountInformation getBinanceAccountInformation() throws IOException {
        final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
        return super.account(recvWindow, this.getTimestamp());
    }
    
    public AccountInfo getAccountInfo() throws IOException {
        try {
            final BinanceAccountInformation acc = this.getBinanceAccountInformation();
            final List<Balance> balances = acc.balances.stream().map(b -> new Balance(b.getCurrency(), b.getTotal(), b.getAvailable())).collect((Collector<? super Object, ?, List<Balance>>)Collectors.toList());
            return new AccountInfo(new Date(acc.updateTime), new Wallet[] { new Wallet((Collection)balances) });
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public Map<CurrencyPair, Fee> getDynamicTradingFees() throws IOException {
        final BinanceAccountInformation acc = this.getBinanceAccountInformation();
        final Map<CurrencyPair, Fee> tradingFees = new HashMap<CurrencyPair, Fee>();
        final List<CurrencyPair> pairs = (List<CurrencyPair>)this.exchange.getExchangeSymbols();
        final Map<CurrencyPair, Fee> map;
        final BinanceAccountInformation binanceAccountInformation;
        pairs.forEach(pair -> map.put(pair, new Fee(binanceAccountInformation.makerCommission, binanceAccountInformation.takerCommission)));
        return tradingFees;
    }
    
    public String withdrawFunds(final Currency currency, final BigDecimal amount, final String address) throws IOException {
        try {
            return super.withdraw(currency.getCurrencyCode(), address, amount);
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public String withdrawFunds(final Currency currency, final BigDecimal amount, final AddressWithTag address) throws IOException {
        return this.withdrawFunds((WithdrawFundsParams)new DefaultWithdrawFundsParams(address, currency, amount));
    }
    
    public String withdrawFunds(final WithdrawFundsParams params) throws IOException {
        try {
            if (!(params instanceof DefaultWithdrawFundsParams)) {
                throw new IllegalArgumentException("DefaultWithdrawFundsParams must be provided.");
            }
            String id = null;
            if (params instanceof RippleWithdrawFundsParams) {
                RippleWithdrawFundsParams rippleParams = null;
                rippleParams = (RippleWithdrawFundsParams)params;
                id = super.withdraw(rippleParams.getCurrency().getCurrencyCode(), rippleParams.getAddress(), rippleParams.getTag(), rippleParams.getAmount());
            }
            else {
                final DefaultWithdrawFundsParams p = (DefaultWithdrawFundsParams)params;
                id = super.withdraw(p.getCurrency().getCurrencyCode(), p.getAddress(), p.getDestinationTag(), p.getAmount());
            }
            return id;
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public String requestDepositAddress(final Currency currency, final String... args) throws IOException {
        try {
            return super.requestDepositAddress(currency).address;
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public AddressWithTag requestDepositAddressData(final Currency currency, final String... args) throws IOException {
        final DepositAddress depositAddress = super.requestDepositAddress(currency);
        return new AddressWithTag(depositAddress.address, depositAddress.addressTag);
    }
    
    public Map<String, AssetDetail> getAssetDetails() throws IOException {
        try {
            return super.requestAssetDetail().getAssetDetail();
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
    
    public TradeHistoryParams createFundingHistoryParams() {
        return (TradeHistoryParams)new BinanceFundingHistoryParams();
    }
    
    public List<FundingRecord> getFundingHistory(final TradeHistoryParams params) throws IOException {
        try {
            String asset = null;
            if (params instanceof TradeHistoryParamCurrency) {
                final TradeHistoryParamCurrency cp = (TradeHistoryParamCurrency)params;
                if (cp.getCurrency() != null) {
                    asset = cp.getCurrency().getCurrencyCode();
                }
            }
            final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
            boolean withdrawals = true;
            boolean deposits = true;
            Long startTime = null;
            Long endTime = null;
            if (params instanceof TradeHistoryParamsTimeSpan) {
                final TradeHistoryParamsTimeSpan tp = (TradeHistoryParamsTimeSpan)params;
                if (tp.getStartTime() != null) {
                    startTime = tp.getStartTime().getTime();
                }
                if (tp.getEndTime() != null) {
                    endTime = tp.getEndTime().getTime();
                }
            }
            if (params instanceof HistoryParamsFundingType) {
                final HistoryParamsFundingType f = (HistoryParamsFundingType)params;
                if (f.getType() != null) {
                    withdrawals = (f.getType() == FundingRecord.Type.WITHDRAWAL);
                    deposits = (f.getType() == FundingRecord.Type.DEPOSIT);
                }
            }
            final List<FundingRecord> result = new ArrayList<FundingRecord>();
            if (withdrawals) {
                final FundingRecord fundingRecord;
                final Object o;
                super.withdrawHistory(asset, startTime, endTime, recvWindow, this.getTimestamp()).forEach(w -> {
                    new FundingRecord(w.address, w.destinationTag, new Date(w.applyTime), Currency.getInstance(w.asset), w.amount, w.id, w.txId, FundingRecord.Type.WITHDRAWAL, withdrawStatus(w.status), (BigDecimal)null, (BigDecimal)null, (String)null);
                    ((List<FundingRecord>)o).add(fundingRecord);
                    return;
                });
            }
            if (deposits) {
                final FundingRecord fundingRecord2;
                final Object o2;
                super.depositHistory(asset, startTime, endTime, recvWindow, this.getTimestamp()).forEach(d -> {
                    new FundingRecord(d.address, new Date(d.insertTime), Currency.getInstance(d.asset), d.amount, (String)null, d.txId, FundingRecord.Type.DEPOSIT, depositStatus(d.status), (BigDecimal)null, (BigDecimal)null, (String)null);
                    ((List<FundingRecord>)o2).add(fundingRecord2);
                    return;
                });
            }
            return result;
        }
        catch (BinanceException e) {
            throw BinanceErrorAdapter.adapt(e);
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchange.binance.dto.account.WithdrawList;
import org.knowm.xchange.binance.dto.account.DepositList;
import java.util.List;
import org.knowm.xchange.binance.dto.account.AssetDetailResponse;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.account.DepositAddress;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.binance.dto.account.WithdrawRequest;
import org.knowm.xchange.binance.dto.account.WapiResponse;
import java.math.BigDecimal;
import java.io.IOException;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.BinanceAccountInformation;
import org.knowm.xchange.Exchange;

public class BinanceAccountServiceRaw extends BinanceBaseService
{
    public BinanceAccountServiceRaw(final Exchange exchange) {
        super(exchange);
    }
    
    public BinanceAccountInformation account(final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        return this.binance.account(recvWindow, timestamp, super.apiKey, super.signatureCreator);
    }
    
    public String withdraw(final String asset, final String address, final BigDecimal amount) throws IOException, BinanceException {
        final String name = (address.length() <= 10) ? address : address.substring(0, 10);
        return this.withdraw(asset, address, amount, name, null, this.getTimestamp());
    }
    
    public String withdraw(final String asset, final String address, final String addressTag, final BigDecimal amount) throws IOException, BinanceException {
        final String name = (address.length() <= 10) ? address : address.substring(0, 10);
        final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
        return this.withdraw(asset, address, addressTag, amount, name, recvWindow, this.getTimestamp());
    }
    
    private String withdraw(final String asset, final String address, final BigDecimal amount, final String name, final Long recvWindow, final long timestamp) throws IOException, BinanceException {
        final WithdrawRequest result = this.binance.withdraw(asset, address, null, amount, name, recvWindow, timestamp, super.apiKey, super.signatureCreator);
        this.checkWapiResponse((WapiResponse<Object>)result);
        return result.getData();
    }
    
    private String withdraw(final String asset, final String address, final String addressTag, final BigDecimal amount, final String name, final Long recvWindow, final long timestamp) throws IOException, BinanceException {
        final WithdrawRequest result = this.binance.withdraw(asset, address, addressTag, amount, name, recvWindow, timestamp, super.apiKey, super.signatureCreator);
        this.checkWapiResponse((WapiResponse<Object>)result);
        return result.getData();
    }
    
    public DepositAddress requestDepositAddress(final Currency currency) throws IOException {
        final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
        return this.binance.depositAddress(BinanceAdapters.toSymbol(currency), recvWindow, this.getTimestamp(), this.apiKey, super.signatureCreator);
    }
    
    public AssetDetailResponse requestAssetDetail() throws IOException {
        final Long recvWindow = (Long)this.exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
        return this.binance.assetDetail(recvWindow, this.getTimestamp(), this.apiKey, super.signatureCreator);
    }
    
    public List<DepositList.BinanceDeposit> depositHistory(final String asset, final Long startTime, final Long endTime, final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        final DepositList result = this.binance.depositHistory(asset, startTime, endTime, recvWindow, timestamp, super.apiKey, super.signatureCreator);
        return this.checkWapiResponse((WapiResponse<List<DepositList.BinanceDeposit>>)result);
    }
    
    public List<WithdrawList.BinanceWithdraw> withdrawHistory(final String asset, final Long startTime, final Long endTime, final Long recvWindow, final long timestamp) throws BinanceException, IOException {
        final WithdrawList result = this.binance.withdrawHistory(asset, startTime, endTime, recvWindow, timestamp, super.apiKey, super.signatureCreator);
        return this.checkWapiResponse((WapiResponse<List<WithdrawList.BinanceWithdraw>>)result);
    }
    
    private <T> T checkWapiResponse(final WapiResponse<T> result) {
        if (!result.success) {
            BinanceException exception;
            try {
                exception = (BinanceException)new ObjectMapper().readValue(result.msg, (Class)BinanceException.class);
            }
            catch (Throwable e) {
                exception = new BinanceException(-1, result.msg);
            }
            throw exception;
        }
        return result.getData();
    }
}

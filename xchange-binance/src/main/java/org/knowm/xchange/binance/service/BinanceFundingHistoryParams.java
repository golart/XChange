// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import java.util.Date;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.service.trade.params.HistoryParamsFundingType;
import org.knowm.xchange.service.trade.params.TradeHistoryParamsTimeSpan;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrency;

public class BinanceFundingHistoryParams implements TradeHistoryParamCurrency, TradeHistoryParamsTimeSpan, HistoryParamsFundingType
{
    private Currency currency;
    private FundingRecord.Type type;
    private Date startTime;
    private Date endTime;
    
    public Currency getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }
    
    public FundingRecord.Type getType() {
        return this.type;
    }
    
    public void setType(final FundingRecord.Type type) {
        this.type = type;
    }
    
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }
}

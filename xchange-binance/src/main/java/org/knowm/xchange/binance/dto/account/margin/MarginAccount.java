// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.math.BigDecimal;

public class MarginAccount
{
    private Boolean borrowEnabled;
    private BigDecimal marginLevel;
    private BigDecimal totalAssetOfBtc;
    private BigDecimal totalLiabilityOfBtc;
    private BigDecimal totalNetAssetOfBtc;
    private Boolean tradeEnabled;
    private Boolean transferEnabled;
    private List<MarginAssetBalance> userAssets;
    
    public MarginAccount(@JsonProperty("borrowEnabled") final Boolean borrowEnabled, @JsonProperty("marginLevel") final BigDecimal marginLevel, @JsonProperty("totalAssetOfBtc") final BigDecimal totalAssetOfBtc, @JsonProperty("totalLiabilityOfBtc") final BigDecimal totalLiabilityOfBtc, @JsonProperty("totalNetAssetOfBtc") final BigDecimal totalNetAssetOfBtc, @JsonProperty("tradeEnabled") final Boolean tradeEnabled, @JsonProperty("transferEnabled") final Boolean transferEnabled, @JsonProperty("userAssets") final List<MarginAssetBalance> userAssets) {
        this.borrowEnabled = borrowEnabled;
        this.marginLevel = marginLevel;
        this.totalAssetOfBtc = totalAssetOfBtc;
        this.totalLiabilityOfBtc = totalLiabilityOfBtc;
        this.totalNetAssetOfBtc = totalNetAssetOfBtc;
        this.tradeEnabled = tradeEnabled;
        this.transferEnabled = transferEnabled;
        this.userAssets = userAssets;
    }
    
    public Boolean getBorrowEnabled() {
        return this.borrowEnabled;
    }
    
    public void setBorrowEnabled(final Boolean borrowEnabled) {
        this.borrowEnabled = borrowEnabled;
    }
    
    public BigDecimal getMarginLevel() {
        return this.marginLevel;
    }
    
    public void setMarginLevel(final BigDecimal marginLevel) {
        this.marginLevel = marginLevel;
    }
    
    public BigDecimal getTotalAssetOfBtc() {
        return this.totalAssetOfBtc;
    }
    
    public void setTotalAssetOfBtc(final BigDecimal totalAssetOfBtc) {
        this.totalAssetOfBtc = totalAssetOfBtc;
    }
    
    public BigDecimal getTotalLiabilityOfBtc() {
        return this.totalLiabilityOfBtc;
    }
    
    public void setTotalLiabilityOfBtc(final BigDecimal totalLiabilityOfBtc) {
        this.totalLiabilityOfBtc = totalLiabilityOfBtc;
    }
    
    public BigDecimal getTotalNetAssetOfBtc() {
        return this.totalNetAssetOfBtc;
    }
    
    public void setTotalNetAssetOfBtc(final BigDecimal totalNetAssetOfBtc) {
        this.totalNetAssetOfBtc = totalNetAssetOfBtc;
    }
    
    public Boolean getTradeEnabled() {
        return this.tradeEnabled;
    }
    
    public void setTradeEnabled(final Boolean tradeEnabled) {
        this.tradeEnabled = tradeEnabled;
    }
    
    public Boolean getTransferEnabled() {
        return this.transferEnabled;
    }
    
    public void setTransferEnabled(final Boolean transferEnabled) {
        this.transferEnabled = transferEnabled;
    }
    
    public List<MarginAssetBalance> getUserAssets() {
        return this.userAssets;
    }
    
    public void setUserAssets(final List<MarginAssetBalance> userAssets) {
        this.userAssets = userAssets;
    }
}

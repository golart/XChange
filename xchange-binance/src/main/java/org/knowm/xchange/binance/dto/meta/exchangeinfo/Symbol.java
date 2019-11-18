// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.meta.exchangeinfo;

public class Symbol
{
    private String quoteAsset;
    private String icebergAllowed;
    private String baseAsset;
    private String symbol;
    private String status;
    private String quotePrecision;
    private String baseAssetPrecision;
    private String[] orderTypes;
    private Filter[] filters;
    
    public String getQuoteAsset() {
        return this.quoteAsset;
    }
    
    public void setQuoteAsset(final String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }
    
    public String getIcebergAllowed() {
        return this.icebergAllowed;
    }
    
    public void setIcebergAllowed(final String icebergAllowed) {
        this.icebergAllowed = icebergAllowed;
    }
    
    public String getBaseAsset() {
        return this.baseAsset;
    }
    
    public void setBaseAsset(final String baseAsset) {
        this.baseAsset = baseAsset;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getQuotePrecision() {
        return this.quotePrecision;
    }
    
    public void setQuotePrecision(final String quotePrecision) {
        this.quotePrecision = quotePrecision;
    }
    
    public String getBaseAssetPrecision() {
        return this.baseAssetPrecision;
    }
    
    public void setBaseAssetPrecision(final String baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }
    
    public String[] getOrderTypes() {
        return this.orderTypes;
    }
    
    public void setOrderTypes(final String[] orderTypes) {
        this.orderTypes = orderTypes;
    }
    
    public Filter[] getFilters() {
        return this.filters;
    }
    
    public void setFilters(final Filter[] filters) {
        this.filters = filters;
    }
    
    @Override
    public String toString() {
        return "ClassPojo [quoteAsset = " + this.quoteAsset + ", icebergAllowed = " + this.icebergAllowed + ", baseAsset = " + this.baseAsset + ", symbol = " + this.symbol + ", status = " + this.status + ", quotePrecision = " + this.quotePrecision + ", baseAssetPrecision = " + this.baseAssetPrecision + ", orderTypes = " + this.orderTypes + ", filters = " + this.filters + "]";
    }
}

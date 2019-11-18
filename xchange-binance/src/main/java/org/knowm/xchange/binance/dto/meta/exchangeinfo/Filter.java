// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.meta.exchangeinfo;

public class Filter
{
    private String maxPrice;
    private String filterType;
    private String tickSize;
    private String minPrice;
    private String minQty;
    private String maxQty;
    private String stepSize;
    private String minNotional;
    
    public String getMaxPrice() {
        return this.maxPrice;
    }
    
    public void setMaxPrice(final String maxPrice) {
        this.maxPrice = maxPrice;
    }
    
    public String getFilterType() {
        return this.filterType;
    }
    
    public void setFilterType(final String filterType) {
        this.filterType = filterType;
    }
    
    public String getTickSize() {
        return this.tickSize;
    }
    
    public void setTickSize(final String tickSize) {
        this.tickSize = tickSize;
    }
    
    public String getMinPrice() {
        return this.minPrice;
    }
    
    public void setMinPrice(final String minPrice) {
        this.minPrice = minPrice;
    }
    
    public String getMinQty() {
        return this.minQty;
    }
    
    public void setMinQty(final String minQty) {
        this.minQty = minQty;
    }
    
    public String getMaxQty() {
        return this.maxQty;
    }
    
    public void setMaxQty(final String maxQty) {
        this.maxQty = maxQty;
    }
    
    public String getStepSize() {
        return this.stepSize;
    }
    
    public void setStepSize(final String stepSize) {
        this.stepSize = stepSize;
    }
    
    public String getMinNotional() {
        return this.minNotional;
    }
    
    public void setMinNotional(final String minNotional) {
        this.minNotional = minNotional;
    }
    
    @Override
    public String toString() {
        return "Filter{maxPrice='" + this.maxPrice + '\'' + ", filterType='" + this.filterType + '\'' + ", tickSize='" + this.tickSize + '\'' + ", minPrice='" + this.minPrice + '\'' + ", minQty='" + this.minQty + '\'' + ", maxQty='" + this.maxQty + '\'' + ", stepSize='" + this.stepSize + '\'' + ", minNotional='" + this.minNotional + '\'' + '}';
    }
}

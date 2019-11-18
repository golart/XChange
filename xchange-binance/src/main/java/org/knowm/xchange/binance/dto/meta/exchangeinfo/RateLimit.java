// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.meta.exchangeinfo;

public class RateLimit
{
    private String limit;
    private String interval;
    private String rateLimitType;
    
    public String getLimit() {
        return this.limit;
    }
    
    public void setLimit(final String limit) {
        this.limit = limit;
    }
    
    public String getInterval() {
        return this.interval;
    }
    
    public void setInterval(final String interval) {
        this.interval = interval;
    }
    
    public String getRateLimitType() {
        return this.rateLimitType;
    }
    
    public void setRateLimitType(final String rateLimitType) {
        this.rateLimitType = rateLimitType;
    }
    
    @Override
    public String toString() {
        return "ClassPojo [limit = " + this.limit + ", interval = " + this.interval + ", rateLimitType = " + this.rateLimitType + "]";
    }
}

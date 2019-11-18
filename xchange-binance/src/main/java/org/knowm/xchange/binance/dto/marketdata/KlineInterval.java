// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.marketdata;

import java.util.concurrent.TimeUnit;

public enum KlineInterval
{
    m1("1m", Long.valueOf(TimeUnit.MINUTES.toMillis(1L))), 
    m3("3m", Long.valueOf(TimeUnit.MINUTES.toMillis(3L))), 
    m5("5m", Long.valueOf(TimeUnit.MINUTES.toMillis(5L))), 
    m15("15m", Long.valueOf(TimeUnit.MINUTES.toMillis(15L))), 
    m30("30m", Long.valueOf(TimeUnit.MINUTES.toMillis(30L))), 
    h1("1h", Long.valueOf(TimeUnit.HOURS.toMillis(1L))), 
    h2("2h", Long.valueOf(TimeUnit.HOURS.toMillis(2L))), 
    h4("4h", Long.valueOf(TimeUnit.HOURS.toMillis(4L))), 
    h6("6h", Long.valueOf(TimeUnit.HOURS.toMillis(6L))), 
    h8("8h", Long.valueOf(TimeUnit.HOURS.toMillis(8L))), 
    h12("12h", Long.valueOf(TimeUnit.HOURS.toMillis(12L))), 
    d1("1d", Long.valueOf(TimeUnit.DAYS.toMillis(1L))), 
    d3("3d", Long.valueOf(TimeUnit.DAYS.toMillis(3L))), 
    w1("1w", Long.valueOf(TimeUnit.DAYS.toMillis(7L))), 
    M1("1M", Long.valueOf(TimeUnit.DAYS.toMillis(30L)));
    
    private final String code;
    private final Long millis;
    
    private KlineInterval(final String code, final Long millis) {
        this.millis = millis;
        this.code = code;
    }
    
    public Long getMillis() {
        return this.millis;
    }
    
    public String code() {
        return this.code;
    }
}

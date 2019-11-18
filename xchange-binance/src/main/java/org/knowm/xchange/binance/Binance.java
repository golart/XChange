// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance;

import org.knowm.xchange.binance.dto.marketdata.BinancePriceQuantity;
import org.knowm.xchange.binance.dto.marketdata.BinancePrice;
import org.knowm.xchange.binance.dto.marketdata.BinanceTicker24h;
import org.knowm.xchange.binance.dto.marketdata.BinanceAggTrades;
import java.util.List;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.BinanceOrderbook;
import javax.ws.rs.QueryParam;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;
import org.knowm.xchange.binance.dto.meta.BinanceTime;
import javax.ws.rs.GET;
import java.io.IOException;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("")
@Produces({ "application/json" })
public interface Binance
{
    @GET
    @Path("api/v1/ping")
    Object ping() throws IOException;
    
    @GET
    @Path("api/v1/time")
    BinanceTime time() throws IOException;
    
    @GET
    @Path("api/v1/exchangeInfo")
    BinanceExchangeInfo exchangeInfo() throws IOException;
    
    @GET
    @Path("api/v1/depth")
    BinanceOrderbook depth(@QueryParam("symbol") final String p0, @QueryParam("limit") final Integer p1) throws IOException, BinanceException;
    
    @GET
    @Path("api/v1/aggTrades")
    List<BinanceAggTrades> aggTrades(@QueryParam("symbol") final String p0, @QueryParam("fromId") final Long p1, @QueryParam("startTime") final Long p2, @QueryParam("endTime") final Long p3, @QueryParam("limit") final Integer p4) throws IOException, BinanceException;
    
    @GET
    @Path("api/v1/klines")
    List<Object[]> klines(@QueryParam("symbol") final String p0, @QueryParam("interval") final String p1, @QueryParam("limit") final Integer p2, @QueryParam("startTime") final Long p3, @QueryParam("endTime") final Long p4) throws IOException, BinanceException;
    
    @GET
    @Path("api/v1/ticker/24hr")
    List<BinanceTicker24h> ticker24h() throws IOException, BinanceException;
    
    @GET
    @Path("api/v1/ticker/24hr")
    BinanceTicker24h ticker24h(@QueryParam("symbol") final String p0) throws IOException, BinanceException;
    
    @GET
    @Path("api/v1/ticker/allPrices")
    List<BinancePrice> tickerAllPrices() throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/ticker/bookTicker")
    List<BinancePriceQuantity> tickerAllBookTickers() throws IOException, BinanceException;
}

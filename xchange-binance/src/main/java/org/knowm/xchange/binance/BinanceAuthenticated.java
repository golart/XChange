// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance;

import org.knowm.xchange.binance.dto.account.margin.MarginPriceIndex;
import org.knowm.xchange.binance.dto.account.margin.MarginPair;
import org.knowm.xchange.binance.dto.account.margin.MarginAsset;
import org.knowm.xchange.binance.dto.account.margin.ShortMarginOrder;
import org.knowm.xchange.binance.dto.account.margin.ForceLiquidationRecs;
import org.knowm.xchange.binance.dto.account.margin.Interests;
import org.knowm.xchange.binance.dto.account.margin.Transfers;
import org.knowm.xchange.binance.dto.account.margin.RepayRecords;
import org.knowm.xchange.binance.dto.account.margin.LoanRecords;
import org.knowm.xchange.binance.dto.account.margin.OperationInfo;
import org.knowm.xchange.binance.dto.account.margin.MarginOrder;
import org.knowm.xchange.binance.dto.account.margin.MarginAccount;
import javax.ws.rs.PUT;
import java.util.Map;
import javax.ws.rs.PathParam;
import org.knowm.xchange.binance.dto.trade.BinanceListenKey;
import org.knowm.xchange.binance.dto.account.AssetDetailResponse;
import org.knowm.xchange.binance.dto.account.DepositAddress;
import org.knowm.xchange.binance.dto.account.WithdrawList;
import org.knowm.xchange.binance.dto.account.DepositList;
import org.knowm.xchange.binance.dto.account.WithdrawRequest;
import org.knowm.xchange.binance.dto.trade.BinanceTrade;
import org.knowm.xchange.binance.dto.account.BinanceAccountInformation;
import java.util.List;
import javax.ws.rs.DELETE;
import org.knowm.xchange.binance.dto.trade.BinanceCancelledOrder;
import javax.ws.rs.GET;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import javax.ws.rs.POST;
import org.knowm.xchange.binance.dto.BinanceException;
import java.io.IOException;
import org.knowm.xchange.binance.dto.trade.BinanceNewOrder;
import javax.ws.rs.QueryParam;
import si.mazi.rescu.ParamsDigest;
import javax.ws.rs.HeaderParam;
import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.trade.TimeInForce;
import org.knowm.xchange.binance.dto.trade.OrderType;
import org.knowm.xchange.binance.dto.trade.OrderSide;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("")
@Produces({ "application/json" })
public interface BinanceAuthenticated extends Binance
{
    public static final String SIGNATURE = "signature";
    public static final String X_MBX_APIKEY = "X-MBX-APIKEY";
    
    @POST
    @Path("api/v3/order")
    BinanceNewOrder newOrder(@FormParam("symbol") final String p0, @FormParam("side") final OrderSide p1, @FormParam("type") final OrderType p2, @FormParam("timeInForce") final TimeInForce p3, @FormParam("quantity") final BigDecimal p4, @FormParam("price") final BigDecimal p5, @FormParam("newClientOrderId") final String p6, @FormParam("stopPrice") final BigDecimal p7, @FormParam("icebergQty") final BigDecimal p8, @FormParam("recvWindow") final Long p9, @FormParam("timestamp") final long p10, @HeaderParam("X-MBX-APIKEY") final String p11, @QueryParam("signature") final ParamsDigest p12) throws IOException, BinanceException;
    
    @POST
    @Path("api/v3/order/test")
    Object testNewOrder(@FormParam("symbol") final String p0, @FormParam("side") final OrderSide p1, @FormParam("type") final OrderType p2, @FormParam("timeInForce") final TimeInForce p3, @FormParam("quantity") final BigDecimal p4, @FormParam("price") final BigDecimal p5, @FormParam("newClientOrderId") final String p6, @FormParam("stopPrice") final BigDecimal p7, @FormParam("icebergQty") final BigDecimal p8, @FormParam("recvWindow") final Long p9, @FormParam("timestamp") final long p10, @HeaderParam("X-MBX-APIKEY") final String p11, @QueryParam("signature") final ParamsDigest p12) throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/order")
    BinanceOrder orderStatus(@QueryParam("symbol") final String p0, @QueryParam("orderId") final long p1, @QueryParam("origClientOrderId") final String p2, @QueryParam("recvWindow") final Long p3, @QueryParam("timestamp") final long p4, @HeaderParam("X-MBX-APIKEY") final String p5, @QueryParam("signature") final ParamsDigest p6) throws IOException, BinanceException;
    
    @DELETE
    @Path("api/v3/order")
    BinanceCancelledOrder cancelOrder(@QueryParam("symbol") final String p0, @QueryParam("orderId") final long p1, @QueryParam("origClientOrderId") final String p2, @QueryParam("newClientOrderId") final String p3, @QueryParam("recvWindow") final Long p4, @QueryParam("timestamp") final long p5, @HeaderParam("X-MBX-APIKEY") final String p6, @QueryParam("signature") final ParamsDigest p7) throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/openOrders")
    List<BinanceOrder> openOrders(@QueryParam("symbol") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/openOrders")
    List<BinanceOrder> openOrders(@QueryParam("recvWindow") final Long p0, @QueryParam("timestamp") final long p1, @HeaderParam("X-MBX-APIKEY") final String p2, @QueryParam("signature") final ParamsDigest p3) throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/allOrders")
    List<BinanceOrder> allOrders(@QueryParam("symbol") final String p0, @QueryParam("orderId") final Long p1, @QueryParam("limit") final Integer p2, @QueryParam("recvWindow") final Long p3, @QueryParam("timestamp") final long p4, @HeaderParam("X-MBX-APIKEY") final String p5, @QueryParam("signature") final ParamsDigest p6) throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/account")
    BinanceAccountInformation account(@QueryParam("recvWindow") final Long p0, @QueryParam("timestamp") final long p1, @HeaderParam("X-MBX-APIKEY") final String p2, @QueryParam("signature") final ParamsDigest p3) throws IOException, BinanceException;
    
    @GET
    @Path("api/v3/myTrades")
    List<BinanceTrade> myTrades(@QueryParam("symbol") final String p0, @QueryParam("limit") final Integer p1, @QueryParam("startTime") final Long p2, @QueryParam("endTime") final Long p3, @QueryParam("fromId") final Long p4, @QueryParam("recvWindow") final Long p5, @QueryParam("timestamp") final long p6, @HeaderParam("X-MBX-APIKEY") final String p7, @QueryParam("signature") final ParamsDigest p8) throws IOException, BinanceException;
    
    @POST
    @Path("wapi/v3/withdraw.html")
    WithdrawRequest withdraw(@FormParam("asset") final String p0, @FormParam("address") final String p1, @FormParam("addressTag") final String p2, @FormParam("amount") final BigDecimal p3, @FormParam("name") final String p4, @FormParam("recvWindow") final Long p5, @FormParam("timestamp") final long p6, @HeaderParam("X-MBX-APIKEY") final String p7, @QueryParam("signature") final ParamsDigest p8) throws IOException, BinanceException;
    
    @GET
    @Path("wapi/v3/depositHistory.html")
    DepositList depositHistory(@QueryParam("asset") final String p0, @QueryParam("startTime") final Long p1, @QueryParam("endTime") final Long p2, @QueryParam("recvWindow") final Long p3, @QueryParam("timestamp") final long p4, @HeaderParam("X-MBX-APIKEY") final String p5, @QueryParam("signature") final ParamsDigest p6) throws IOException, BinanceException;
    
    @GET
    @Path("wapi/v3/withdrawHistory.html")
    WithdrawList withdrawHistory(@QueryParam("asset") final String p0, @QueryParam("startTime") final Long p1, @QueryParam("endTime") final Long p2, @QueryParam("recvWindow") final Long p3, @QueryParam("timestamp") final long p4, @HeaderParam("X-MBX-APIKEY") final String p5, @QueryParam("signature") final ParamsDigest p6) throws IOException, BinanceException;
    
    @GET
    @Path("wapi/v3/depositAddress.html")
    DepositAddress depositAddress(@QueryParam("asset") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @GET
    @Path("wapi/v3/assetDetail.html")
    AssetDetailResponse assetDetail(@QueryParam("recvWindow") final Long p0, @QueryParam("timestamp") final long p1, @HeaderParam("X-MBX-APIKEY") final String p2, @QueryParam("signature") final ParamsDigest p3) throws IOException, BinanceException;
    
    @POST
    @Path("/api/v1/userDataStream")
    BinanceListenKey startUserDataStream(@HeaderParam("X-MBX-APIKEY") final String p0) throws IOException, BinanceException;
    
    @PUT
    @Path("/api/v1/userDataStream?listenKey={listenKey}")
    Map<?, ?> keepAliveUserDataStream(@HeaderParam("X-MBX-APIKEY") final String p0, @PathParam("listenKey") final String p1) throws IOException, BinanceException;
    
    @DELETE
    @Path("/api/v1/userDataStream?listenKey={listenKey}")
    Map<?, ?> closeUserDataStream(@HeaderParam("X-MBX-APIKEY") final String p0, @PathParam("listenKey") final String p1) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/account")
    MarginAccount getMarginAccount(@QueryParam("recvWindow") final Long p0, @QueryParam("timestamp") final long p1, @HeaderParam("X-MBX-APIKEY") final String p2, @QueryParam("signature") final ParamsDigest p3) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/openOrders")
    List<MarginOrder> getOpenMarginOrders(@QueryParam("symbol") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @POST
    @Path("sapi/v1/margin/transfer")
    OperationInfo transfer(@FormParam("asset") final String p0, @FormParam("amount") final BigDecimal p1, @FormParam("type") final int p2, @FormParam("recvWindow") final Long p3, @FormParam("timestamp") final long p4, @HeaderParam("X-MBX-APIKEY") final String p5, @QueryParam("signature") final ParamsDigest p6) throws IOException, BinanceException;
    
    @POST
    @Path("sapi/v1/margin/loan")
    OperationInfo borrow(@FormParam("asset") final String p0, @FormParam("amount") final BigDecimal p1, @FormParam("recvWindow") final Long p2, @FormParam("timestamp") final long p3, @HeaderParam("X-MBX-APIKEY") final String p4, @QueryParam("signature") final ParamsDigest p5) throws IOException, BinanceException;
    
    @POST
    @Path("sapi/v1/margin/repay")
    OperationInfo repay(@FormParam("asset") final String p0, @FormParam("amount") final BigDecimal p1, @FormParam("recvWindow") final Long p2, @FormParam("timestamp") final long p3, @HeaderParam("X-MBX-APIKEY") final String p4, @QueryParam("signature") final ParamsDigest p5) throws IOException, BinanceException;
    
    @POST
    @Path("sapi/v1/margin/order")
    BinanceNewOrder newMarginOrder(@FormParam("symbol") final String p0, @FormParam("side") final OrderSide p1, @FormParam("type") final OrderType p2, @FormParam("timeInForce") final TimeInForce p3, @FormParam("quantity") final BigDecimal p4, @FormParam("price") final BigDecimal p5, @FormParam("newClientOrderId") final String p6, @FormParam("stopPrice") final BigDecimal p7, @FormParam("icebergQty") final BigDecimal p8, @FormParam("recvWindow") final Long p9, @FormParam("timestamp") final long p10, @HeaderParam("X-MBX-APIKEY") final String p11, @QueryParam("signature") final ParamsDigest p12) throws IOException, BinanceException;
    
    @DELETE
    @Path("sapi/v1/margin/order")
    BinanceCancelledOrder cancelMarginOrder(@QueryParam("symbol") final String p0, @QueryParam("orderId") final long p1, @QueryParam("origClientOrderId") final String p2, @QueryParam("newClientOrderId") final String p3, @QueryParam("recvWindow") final Long p4, @QueryParam("timestamp") final long p5, @HeaderParam("X-MBX-APIKEY") final String p6, @QueryParam("signature") final ParamsDigest p7) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/loan")
    LoanRecords getLoanRecords(@QueryParam("asset") final String p0, @QueryParam("txId") final Long p1, @QueryParam("startTime") final Long p2, @QueryParam("endTime") final Long p3, @QueryParam("current") final Long p4, @QueryParam("size") final Long p5, @QueryParam("recvWindow") final Long p6, @QueryParam("timestamp") final long p7, @HeaderParam("X-MBX-APIKEY") final String p8, @QueryParam("signature") final ParamsDigest p9) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/repay")
    RepayRecords getRepayRecords(@QueryParam("asset") final String p0, @QueryParam("txId") final Long p1, @QueryParam("startTime") final Long p2, @QueryParam("endTime") final Long p3, @QueryParam("current") final Long p4, @QueryParam("size") final Long p5, @QueryParam("recvWindow") final Long p6, @QueryParam("timestamp") final long p7, @HeaderParam("X-MBX-APIKEY") final String p8, @QueryParam("signature") final ParamsDigest p9) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/transfer")
    Transfers getTransferHistory(@QueryParam("asset") final String p0, @QueryParam("type") final String p1, @QueryParam("startTime") final Long p2, @QueryParam("endTime") final Long p3, @QueryParam("current") final Long p4, @QueryParam("size") final Long p5, @QueryParam("recvWindow") final Long p6, @QueryParam("timestamp") final long p7, @HeaderParam("X-MBX-APIKEY") final String p8, @QueryParam("signature") final ParamsDigest p9) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/interestHistory")
    Interests getInterestHistory(@QueryParam("asset") final String p0, @QueryParam("startTime") final Long p1, @QueryParam("endTime") final Long p2, @QueryParam("current") final Long p3, @QueryParam("size") final Long p4, @QueryParam("recvWindow") final Long p5, @QueryParam("timestamp") final long p6, @HeaderParam("X-MBX-APIKEY") final String p7, @QueryParam("signature") final ParamsDigest p8) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/forceLiquidationRec")
    ForceLiquidationRecs getForceLiquidationRecords(@QueryParam("startTime") final Long p0, @QueryParam("endTime") final Long p1, @QueryParam("current") final Long p2, @QueryParam("size") final Long p3, @QueryParam("recvWindow") final Long p4, @QueryParam("timestamp") final long p5, @HeaderParam("X-MBX-APIKEY") final String p6, @QueryParam("signature") final ParamsDigest p7) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/order")
    MarginOrder getMarginOrder(@QueryParam("symbol") final String p0, @QueryParam("orderId") final String p1, @QueryParam("origClientOrderId") final String p2, @QueryParam("recvWindow") final Long p3, @QueryParam("timestamp") final long p4, @HeaderParam("X-MBX-APIKEY") final String p5, @QueryParam("signature") final ParamsDigest p6) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/allOrders")
    List<ShortMarginOrder> getAllMarginOrders(@QueryParam("symbol") final String p0, @QueryParam("orderId") final String p1, @QueryParam("startTime") final Long p2, @QueryParam("endTime") final Long p3, @QueryParam("limit") final Integer p4, @QueryParam("recvWindow") final Long p5, @QueryParam("timestamp") final long p6, @HeaderParam("X-MBX-APIKEY") final String p7, @QueryParam("signature") final ParamsDigest p8) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/myTrades")
    List<BinanceTrade> getTrades(@QueryParam("symbol") final String p0, @QueryParam("startTime") final Long p1, @QueryParam("endTime") final Long p2, @QueryParam("fromId") final Long p3, @QueryParam("limit") final Integer p4, @QueryParam("recvWindow") final Long p5, @QueryParam("timestamp") final long p6, @HeaderParam("X-MBX-APIKEY") final String p7, @QueryParam("signature") final ParamsDigest p8) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/maxBorrowable")
    BigDecimal getMaxBorrow(@QueryParam("asset") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/maxTransferable")
    BigDecimal getMaxTransferOutAmount(@QueryParam("asset") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/asset")
    MarginAsset getMarginAsset(@QueryParam("asset") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/pair")
    MarginPair getMarginPair(@QueryParam("symbol") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/allAssets")
    List<MarginAsset> getAllMarginAssets(@QueryParam("recvWindow") final Long p0, @QueryParam("timestamp") final long p1, @HeaderParam("X-MBX-APIKEY") final String p2, @QueryParam("signature") final ParamsDigest p3) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/allPairs")
    List<MarginPair> getAllMarginPairs(@QueryParam("recvWindow") final Long p0, @QueryParam("timestamp") final long p1, @HeaderParam("X-MBX-APIKEY") final String p2, @QueryParam("signature") final ParamsDigest p3) throws IOException, BinanceException;
    
    @GET
    @Path("sapi/v1/margin/priceIndex")
    MarginPriceIndex getMarginPriceIndex(@QueryParam("symbol") final String p0, @QueryParam("recvWindow") final Long p1, @QueryParam("timestamp") final long p2, @HeaderParam("X-MBX-APIKEY") final String p3, @QueryParam("signature") final ParamsDigest p4) throws IOException, BinanceException;
}

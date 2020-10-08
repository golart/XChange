package org.knowm.xchange.binance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.*;
import org.knowm.xchange.binance.dto.account.margin.*;
import org.knowm.xchange.binance.dto.trade.*;
import si.mazi.rescu.ParamsDigest;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceAuthenticated extends Binance {

  String SIGNATURE = "signature";
  String X_MBX_APIKEY = "X-MBX-APIKEY";

  @POST
  @Path("api/v3/order")
  /**
   * Send in a new order
   *
   * @param symbol
   * @param side
   * @param type
   * @param timeInForce
   * @param quantity
   * @param price optional, must be provided for limit orders only
   * @param newClientOrderId optional, a unique id for the order. Automatically generated if not
   *     sent.
   * @param stopPrice optional, used with stop orders
   * @param icebergQty optional, used with iceberg orders
   * @param recvWindow optional
   * @param timestamp
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceNewOrder newOrder(
      @FormParam("symbol") String symbol,
      @FormParam("side") OrderSide side,
      @FormParam("type") OrderType type,
      @FormParam("timeInForce") TimeInForce timeInForce,
      @FormParam("quantity") BigDecimal quantity,
      @FormParam("price") BigDecimal price,
      @FormParam("newClientOrderId") String newClientOrderId,
      @FormParam("stopPrice") BigDecimal stopPrice,
      @FormParam("icebergQty") BigDecimal icebergQty,
      @FormParam("recvWindow") Long recvWindow,
      @FormParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @POST
  @Path("api/v3/order/test")
  /**
   * Test new order creation and signature/recvWindow long. Creates and validates a new order but
   * does not send it into the matching engine.
   *
   * @param symbol
   * @param side
   * @param type
   * @param timeInForce
   * @param quantity
   * @param price
   * @param newClientOrderId optional, a unique id for the order. Automatically generated by
   *     default.
   * @param stopPrice optional, used with STOP orders
   * @param icebergQty optional used with icebergOrders
   * @param recvWindow optional
   * @param timestamp
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  Object testNewOrder(
      @FormParam("symbol") String symbol,
      @FormParam("side") OrderSide side,
      @FormParam("type") OrderType type,
      @FormParam("timeInForce") TimeInForce timeInForce,
      @FormParam("quantity") BigDecimal quantity,
      @FormParam("price") BigDecimal price,
      @FormParam("newClientOrderId") String newClientOrderId,
      @FormParam("stopPrice") BigDecimal stopPrice,
      @FormParam("icebergQty") BigDecimal icebergQty,
      @FormParam("recvWindow") Long recvWindow,
      @FormParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("api/v3/order")
  /**
   * Check an order's status.<br>
   * Either orderId or origClientOrderId must be sent.
   *
   * @param symbol
   * @param orderId optional
   * @param origClientOrderId optional
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceOrder orderStatus(
      @QueryParam("symbol") String symbol,
      @QueryParam("orderId") long orderId,
      @QueryParam("origClientOrderId") String origClientOrderId,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @DELETE
  @Path("api/v3/order")
  /**
   * Cancel an active order.
   *
   * @param symbol
   * @param orderId optional
   * @param origClientOrderId optional
   * @param newClientOrderId optional, used to uniquely identify this cancel. Automatically
   *     generated by default.
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceCancelledOrder cancelOrder(
      @QueryParam("symbol") String symbol,
      @QueryParam("orderId") long orderId,
      @QueryParam("origClientOrderId") String origClientOrderId,
      @QueryParam("newClientOrderId") String newClientOrderId,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("api/v3/openOrders")
  /**
   * Get all open orders on a symbol.
   *
   * @param symbol optional
   * @param recvWindow optional
   * @param timestamp
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceOrder> openOrders(
      @QueryParam("symbol") String symbol,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("api/v3/openOrders")
  /**
   * Get all open orders without a symbol.
   *
   * @param symbol
   * @param recvWindow optional
   * @param timestamp mandatory
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceOrder> openOrders(
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("api/v3/allOrders")
  /**
   * Get all account orders; active, canceled, or filled. <br>
   * If orderId is set, it will get orders >= that orderId. Otherwise most recent orders are
   * returned.
   *
   * @param symbol
   * @param orderId optional
   * @param limit optional
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceOrder> allOrders(
      @QueryParam("symbol") String symbol,
      @QueryParam("orderId") Long orderId,
      @QueryParam("limit") Integer limit,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("api/v3/account")
  /**
   * Get current account information.
   *
   * @param recvWindow optional
   * @param timestamp
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceAccountInformation account(
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("api/v3/myTrades")
  /**
   * Get trades for a specific account and symbol.
   *
   * @param symbol
   * @param startTime optional
   * @param endTime optional
   * @param limit optional, default 500; max 1000.
   * @param fromId optional, tradeId to fetch from. Default gets most recent trades.
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceTrade> myTrades(
      @QueryParam("symbol") String symbol,
      @QueryParam("limit") Integer limit,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("fromId") Long fromId,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @POST
  @Path("wapi/v3/withdraw.html")
  /**
   * Submit a withdraw request.
   *
   * @param asset
   * @param address
   * @param addressTag optional for Ripple
   * @param amount
   * @param name optional, description of the address
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  WithdrawRequest withdraw(
      @FormParam("asset") String asset,
      @FormParam("address") String address,
      @FormParam("addressTag") String addressTag,
      @FormParam("amount") BigDecimal amount,
      @FormParam("name") String name,
      @FormParam("recvWindow") Long recvWindow,
      @FormParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("wapi/v3/depositHistory.html")
  /**
   * Fetch deposit history.
   *
   * @param asset optional
   * @param startTime optional
   * @param endTime optional
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  DepositList depositHistory(
      @QueryParam("asset") String asset,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("wapi/v3/withdrawHistory.html")
  /**
   * Fetch withdraw history.
   *
   * @param asset optional
   * @param startTime optional
   * @param endTime optional
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  WithdrawList withdrawHistory(
      @QueryParam("asset") String asset,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  /**
   * Fetch small amounts of assets exchanged BNB records.
   *
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  @GET
  @Path("/wapi/v3/userAssetDribbletLog.html")
  AssetDribbletLogResponse getAssetDribbletLog(
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  /**
   * Fetch small amounts of assets exchanged BNB records.
   *
   * @param asset optional
   * @param startTime optional
   * @param endTime optional
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  @GET
  @Path("/sapi/v1/asset/assetDividend")
  AssetDividendResponse getAssetDividend(
      @QueryParam("asset") String asset,
      @QueryParam("startTime") Long startTime,
      @QueryParam("endTime") Long endTime,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("wapi/v3/depositAddress.html")
  /**
   * Fetch deposit address.
   *
   * @param asset
   * @param recvWindow
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  DepositAddress depositAddress(
      @QueryParam("asset") String asset,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("wapi/v3/assetDetail.html")
  /**
   * Fetch asset details.
   *
   * @param recvWindow
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  AssetDetailResponse assetDetail(
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  /**
   * Returns a listen key for websocket login.
   *
   * @param apiKey the api key
   * @return
   * @throws BinanceException
   * @throws IOException
   */
  @POST
  @Path("/api/v1/userDataStream")
  BinanceListenKey startUserDataStream(@HeaderParam(X_MBX_APIKEY) String apiKey)
      throws IOException, BinanceException;

  /**
   * Keeps the authenticated websocket session alive.
   *
   * @param apiKey the api key
   * @param listenKey the api secret
   * @return
   * @throws BinanceException
   * @throws IOException
   */
  @PUT
  @Path("/api/v1/userDataStream?listenKey={listenKey}")
  Map<?, ?> keepAliveUserDataStream(
      @HeaderParam(X_MBX_APIKEY) String apiKey, @PathParam("listenKey") String listenKey)
      throws IOException, BinanceException;

  /**
   * Closes the websocket authenticated connection.
   *
   * @param apiKey the api key
   * @param listenKey the api secret
   * @return
   * @throws BinanceException
   * @throws IOException
   */
  @DELETE
  @Path("/api/v1/userDataStream?listenKey={listenKey}")
  Map<?, ?> closeUserDataStream(
      @HeaderParam(X_MBX_APIKEY) String apiKey, @PathParam("listenKey") String listenKey)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/account")
  MarginAccount getMarginAccount(
      @QueryParam("recvWindow") final Long p0,
      @QueryParam("timestamp") final long p1,
      @HeaderParam("X-MBX-APIKEY") final String p2,
      @QueryParam("signature") final ParamsDigest p3)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/openOrders")
  List<MarginOrder> getOpenMarginOrders(
      @QueryParam("symbol") final String p0,
      @QueryParam("recvWindow") final Long p1,
      @QueryParam("timestamp") final long p2,
      @HeaderParam("X-MBX-APIKEY") final String p3,
      @QueryParam("signature") final ParamsDigest p4)
      throws IOException, BinanceException;

  @POST
  @Path("sapi/v1/margin/transfer")
  OperationInfo transfer(
      @FormParam("asset") final String p0,
      @FormParam("amount") final BigDecimal p1,
      @FormParam("type") final int p2,
      @FormParam("recvWindow") final Long p3,
      @FormParam("timestamp") final long p4,
      @HeaderParam("X-MBX-APIKEY") final String p5,
      @QueryParam("signature") final ParamsDigest p6)
      throws IOException, BinanceException;

  @POST
  @Path("sapi/v1/margin/loan")
  OperationInfo borrow(
      @FormParam("asset") final String p0,
      @FormParam("amount") final BigDecimal p1,
      @FormParam("recvWindow") final Long p2,
      @FormParam("timestamp") final long p3,
      @HeaderParam("X-MBX-APIKEY") final String p4,
      @QueryParam("signature") final ParamsDigest p5)
      throws IOException, BinanceException;

  @POST
  @Path("sapi/v1/margin/repay")
  OperationInfo repay(
      @FormParam("asset") final String p0,
      @FormParam("amount") final BigDecimal p1,
      @FormParam("recvWindow") final Long p2,
      @FormParam("timestamp") final long p3,
      @HeaderParam("X-MBX-APIKEY") final String p4,
      @QueryParam("signature") final ParamsDigest p5)
      throws IOException, BinanceException;

  @POST
  @Path("sapi/v1/margin/order")
  BinanceNewOrder newMarginOrder(
      @FormParam("symbol") final String p0,
      @FormParam("side") final OrderSide p1,
      @FormParam("type") final OrderType p2,
      @FormParam("timeInForce") final TimeInForce p3,
      @FormParam("quantity") final BigDecimal p4,
      @FormParam("price") final BigDecimal p5,
      @FormParam("newClientOrderId") final String p6,
      @FormParam("stopPrice") final BigDecimal p7,
      @FormParam("icebergQty") final BigDecimal p8,
      @FormParam("recvWindow") final Long p9,
      @FormParam("timestamp") final long p10,
      @HeaderParam("X-MBX-APIKEY") final String p11,
      @QueryParam("signature") final ParamsDigest p12)
      throws IOException, BinanceException;

  @DELETE
  @Path("sapi/v1/margin/order")
  BinanceCancelledOrder cancelMarginOrder(
      @QueryParam("symbol") final String p0,
      @QueryParam("orderId") final long p1,
      @QueryParam("origClientOrderId") final String p2,
      @QueryParam("newClientOrderId") final String p3,
      @QueryParam("recvWindow") final Long p4,
      @QueryParam("timestamp") final long p5,
      @HeaderParam("X-MBX-APIKEY") final String p6,
      @QueryParam("signature") final ParamsDigest p7)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/loan")
  LoanRecords getLoanRecords(
      @QueryParam("asset") final String p0,
      @QueryParam("txId") final Long p1,
      @QueryParam("startTime") final Long p2,
      @QueryParam("endTime") final Long p3,
      @QueryParam("current") final Long p4,
      @QueryParam("size") final Long p5,
      @QueryParam("recvWindow") final Long p6,
      @QueryParam("timestamp") final long p7,
      @HeaderParam("X-MBX-APIKEY") final String p8,
      @QueryParam("signature") final ParamsDigest p9)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/repay")
  RepayRecords getRepayRecords(
      @QueryParam("asset") final String p0,
      @QueryParam("txId") final Long p1,
      @QueryParam("startTime") final Long p2,
      @QueryParam("endTime") final Long p3,
      @QueryParam("current") final Long p4,
      @QueryParam("size") final Long p5,
      @QueryParam("recvWindow") final Long p6,
      @QueryParam("timestamp") final long p7,
      @HeaderParam("X-MBX-APIKEY") final String p8,
      @QueryParam("signature") final ParamsDigest p9)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/transfer")
  Transfers getTransferHistory(
      @QueryParam("asset") final String p0,
      @QueryParam("type") final String p1,
      @QueryParam("startTime") final Long p2,
      @QueryParam("endTime") final Long p3,
      @QueryParam("current") final Long p4,
      @QueryParam("size") final Long p5,
      @QueryParam("recvWindow") final Long p6,
      @QueryParam("timestamp") final long p7,
      @HeaderParam("X-MBX-APIKEY") final String p8,
      @QueryParam("signature") final ParamsDigest p9)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/interestHistory")
  Interests getInterestHistory(
      @QueryParam("asset") final String p0,
      @QueryParam("startTime") final Long p1,
      @QueryParam("endTime") final Long p2,
      @QueryParam("current") final Long p3,
      @QueryParam("size") final Long p4,
      @QueryParam("recvWindow") final Long p5,
      @QueryParam("timestamp") final long p6,
      @HeaderParam("X-MBX-APIKEY") final String p7,
      @QueryParam("signature") final ParamsDigest p8)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/forceLiquidationRec")
  ForceLiquidationRecs getForceLiquidationRecords(
      @QueryParam("startTime") final Long p0,
      @QueryParam("endTime") final Long p1,
      @QueryParam("current") final Long p2,
      @QueryParam("size") final Long p3,
      @QueryParam("recvWindow") final Long p4,
      @QueryParam("timestamp") final long p5,
      @HeaderParam("X-MBX-APIKEY") final String p6,
      @QueryParam("signature") final ParamsDigest p7)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/order")
  MarginOrder getMarginOrder(
      @QueryParam("symbol") final String p0,
      @QueryParam("orderId") final String p1,
      @QueryParam("origClientOrderId") final String p2,
      @QueryParam("recvWindow") final Long p3,
      @QueryParam("timestamp") final long p4,
      @HeaderParam("X-MBX-APIKEY") final String p5,
      @QueryParam("signature") final ParamsDigest p6)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/allOrders")
  List<MarginOrder> getAllMarginOrders(
      @QueryParam("symbol") final String p0,
      @QueryParam("orderId") final String p1,
      @QueryParam("startTime") final Long p2,
      @QueryParam("endTime") final Long p3,
      @QueryParam("limit") final Integer p4,
      @QueryParam("recvWindow") final Long p5,
      @QueryParam("timestamp") final long p6,
      @HeaderParam("X-MBX-APIKEY") final String p7,
      @QueryParam("signature") final ParamsDigest p8)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/myTrades")
  List<BinanceTrade> getTrades(
      @QueryParam("symbol") final String p0,
      @QueryParam("startTime") final Long p1,
      @QueryParam("endTime") final Long p2,
      @QueryParam("fromId") final Long p3,
      @QueryParam("limit") final Integer p4,
      @QueryParam("recvWindow") final Long p5,
      @QueryParam("timestamp") final long p6,
      @HeaderParam("X-MBX-APIKEY") final String p7,
      @QueryParam("signature") final ParamsDigest p8)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/maxBorrowable")
  BigDecimal getMaxBorrow(
      @QueryParam("asset") final String p0,
      @QueryParam("recvWindow") final Long p1,
      @QueryParam("timestamp") final long p2,
      @HeaderParam("X-MBX-APIKEY") final String p3,
      @QueryParam("signature") final ParamsDigest p4)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/maxTransferable")
  BigDecimal getMaxTransferOutAmount(
      @QueryParam("asset") final String p0,
      @QueryParam("recvWindow") final Long p1,
      @QueryParam("timestamp") final long p2,
      @HeaderParam("X-MBX-APIKEY") final String p3,
      @QueryParam("signature") final ParamsDigest p4)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/asset")
  MarginAsset getMarginAsset(
      @QueryParam("asset") final String p0,
      @QueryParam("recvWindow") final Long p1,
      @QueryParam("timestamp") final long p2,
      @HeaderParam("X-MBX-APIKEY") final String p3,
      @QueryParam("signature") final ParamsDigest p4)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/pair")
  MarginPair getMarginPair(
      @QueryParam("symbol") final String p0,
      @QueryParam("recvWindow") final Long p1,
      @QueryParam("timestamp") final long p2,
      @HeaderParam("X-MBX-APIKEY") final String p3,
      @QueryParam("signature") final ParamsDigest p4)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/allAssets")
  List<MarginAsset> getAllMarginAssets(
      @QueryParam("recvWindow") final Long p0,
      @QueryParam("timestamp") final long p1,
      @HeaderParam("X-MBX-APIKEY") final String p2,
      @QueryParam("signature") final ParamsDigest p3)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/allPairs")
  List<MarginPair> getAllMarginPairs(
      @QueryParam("recvWindow") final Long p0,
      @QueryParam("timestamp") final long p1,
      @HeaderParam("X-MBX-APIKEY") final String p2,
      @QueryParam("signature") final ParamsDigest p3)
      throws IOException, BinanceException;

  @GET
  @Path("sapi/v1/margin/priceIndex")
  MarginPriceIndex getMarginPriceIndex(
      @QueryParam("symbol") final String p0,
      @QueryParam("recvWindow") final Long p1,
      @QueryParam("timestamp") final long p2,
      @HeaderParam("X-MBX-APIKEY") final String p3,
      @QueryParam("signature") final ParamsDigest p4)
      throws IOException, BinanceException;

  @POST
  @Path("sapi/v1/futures/transfer")
  TransferResult tranfser(
      @FormParam("asset") String asset,
      @FormParam("amount") BigDecimal amount,
      @FormParam("type") Integer type,
      @FormParam("recvWindow") Long recvWindow,
      @FormParam("timestamp") long timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;
}

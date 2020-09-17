package org.knowm.xchange.binance.dto.account;

public enum SpotTransferType {
  FROM_SPOT_TO_PERPETUAL_FUTURES(1),
  FROM_PERPETUAL_FUTURES_TO_PERPETUAL_FUTURES(2),
  FROM_SPOT_TO_DELIVERY_FUTURES(3),
  FROM_DELIVERY_FUTURES_TO_SPOT(4);

  private final int code;

  private SpotTransferType(final int code) {
    this.code = code;
  }

  public int getCode() {
    return this.code;
  }
}

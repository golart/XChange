package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferResult {

  public final Long tranId;

  public TransferResult(@JsonProperty("tranId") Long tranId) {
    this.tranId = tranId;
  }
}

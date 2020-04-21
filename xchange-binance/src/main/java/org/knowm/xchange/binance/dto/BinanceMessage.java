package org.knowm.xchange.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BinanceMessage {

  private final int code;
  private final String msg;

  public BinanceMessage(@JsonProperty("code") int code, @JsonProperty("msg") String msg) {

    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}

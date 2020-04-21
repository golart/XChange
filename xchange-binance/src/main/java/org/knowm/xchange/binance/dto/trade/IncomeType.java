package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/** @author VKozlov */
public enum IncomeType {
  TRANSFER,
  WELCOME_BONUS,
  REALIZED_PNL,
  FUNDING_FEE,
  COMMISSION,
  INSURANCE_CLEAR;

  @JsonCreator
  public static IncomeType getIncomeType(String s) {
    try {
      return IncomeType.valueOf(s);
    } catch (Exception e) {
      throw new RuntimeException("Unknown order side " + s + ".");
    }
  }
}

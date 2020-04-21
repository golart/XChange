//
// Decompiled by Procyon v0.5.36
//

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LoanRecords {
  private List<LoanRecord> rows;
  private Long total;

  public LoanRecords(
      @JsonProperty("rows") final List<LoanRecord> rows, @JsonProperty("total") final Long total) {
    this.rows = rows;
    this.total = total;
  }

  public List<LoanRecord> getRows() {
    return this.rows;
  }

  public void setRows(final List<LoanRecord> rows) {
    this.rows = rows;
  }

  public Long getTotal() {
    return this.total;
  }

  public void setTotal(final Long total) {
    this.total = total;
  }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class RepayRecords
{
    private List<RepayRecord> rows;
    private Long total;
    
    public RepayRecords(@JsonProperty("rows") final List<RepayRecord> rows, @JsonProperty("total") final Long total) {
        this.rows = rows;
        this.total = total;
    }
    
    public List<RepayRecord> getRows() {
        return this.rows;
    }
    
    public void setRows(final List<RepayRecord> rows) {
        this.rows = rows;
    }
    
    public Long getTotal() {
        return this.total;
    }
    
    public void setTotal(final Long total) {
        this.total = total;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ForceLiquidationRecs
{
    private List<ForceLiquidationRec> rows;
    private Long total;
    
    public ForceLiquidationRecs(@JsonProperty("rows") final List<ForceLiquidationRec> rows, @JsonProperty("total") final Long total) {
        this.rows = rows;
        this.total = total;
    }
    
    public List<ForceLiquidationRec> getRows() {
        return this.rows;
    }
    
    public void setRows(final List<ForceLiquidationRec> rows) {
        this.rows = rows;
    }
    
    public Long getTotal() {
        return this.total;
    }
    
    public void setTotal(final Long total) {
        this.total = total;
    }
}

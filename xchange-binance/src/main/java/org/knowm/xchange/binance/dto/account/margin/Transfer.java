// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account.margin;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.Currency;
import java.math.BigDecimal;

public class Transfer
{
    private BigDecimal amount;
    private Currency asset;
    private TransferStatus status;
    private Long timestamp;
    private Long txId;
    private HistoryTransferType type;
    
    public Transfer(@JsonProperty("amount") final BigDecimal amount, @JsonProperty("asset") final String asset, @JsonProperty("status") final String status, @JsonProperty("timestamp") final Long timestamp, @JsonProperty("txId") final Long txId, @JsonProperty("type") final String type) {
        this.amount = amount;
        this.asset = Currency.getInstance(asset);
        this.status = TransferStatus.valueOf(status);
        this.timestamp = timestamp;
        this.txId = txId;
        this.type = HistoryTransferType.valueOf(type);
    }
    
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }
    
    public Currency getAsset() {
        return this.asset;
    }
    
    public void setAsset(final Currency asset) {
        this.asset = asset;
    }
    
    public TransferStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(final TransferStatus status) {
        this.status = status;
    }
    
    public Long getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public Long getTxId() {
        return this.txId;
    }
    
    public void setTxId(final Long txId) {
        this.txId = txId;
    }
    
    public HistoryTransferType getType() {
        return this.type;
    }
    
    public void setType(final HistoryTransferType type) {
        this.type = type;
    }
}

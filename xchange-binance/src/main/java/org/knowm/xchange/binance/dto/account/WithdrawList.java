// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import java.math.BigDecimal;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public final class WithdrawList extends WapiResponse<List<BinanceWithdraw>>
{
    private final BinanceWithdraw[] withdrawList;
    
    public WithdrawList(@JsonProperty("withdrawList") final BinanceWithdraw[] withdrawList, @JsonProperty("success") final boolean success, @JsonProperty("msg") final String msg) {
        super(success, msg);
        this.withdrawList = withdrawList;
    }
    
    @Override
    public List<BinanceWithdraw> getData() {
        return Arrays.asList(this.withdrawList);
    }
    
    @Override
    public String toString() {
        return "WithdrawList [withdrawList=" + Arrays.toString(this.withdrawList) + ", success=" + this.success + ", msg=" + this.msg + "]";
    }
    
    public static final class BinanceWithdraw
    {
        public final BigDecimal amount;
        public final String address;
        public final String destinationTag;
        public final long successTime;
        public final String txId;
        public final String id;
        public final String asset;
        public final long applyTime;
        public final int status;
        
        public BinanceWithdraw(@JsonProperty("amount") final BigDecimal amount, @JsonProperty("address") final String address, @JsonProperty("successTime") final long successTime, @JsonProperty("txId") final String txId, @JsonProperty("id") final String id, @JsonProperty("asset") final String asset, @JsonProperty("applyTime") final long applyTime, @JsonProperty("status") final int status) {
            this(amount, address, null, successTime, txId, id, asset, applyTime, status);
        }
        
        public BinanceWithdraw(@JsonProperty("amount") final BigDecimal amount, @JsonProperty("address") final String address, @JsonProperty("destinationTag") final String destinationTag, @JsonProperty("successTime") final long successTime, @JsonProperty("txId") final String txId, @JsonProperty("id") final String id, @JsonProperty("asset") final String asset, @JsonProperty("applyTime") final long applyTime, @JsonProperty("status") final int status) {
            this.amount = amount;
            this.address = address;
            this.destinationTag = destinationTag;
            this.successTime = successTime;
            this.txId = txId;
            this.id = id;
            this.asset = asset;
            this.applyTime = applyTime;
            this.status = status;
        }
        
        @Override
        public String toString() {
            return "BinanceWithdraw [amount=" + this.amount + ", address=" + this.address + ", successTime=" + this.successTime + ", txId=" + this.txId + ", id=" + this.id + ", asset=" + this.asset + ", applyTime=" + this.applyTime + ", status=" + this.status + "]";
        }
    }
}

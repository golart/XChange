// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.dto.account;

import java.math.BigDecimal;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public final class DepositList extends WapiResponse<List<BinanceDeposit>>
{
    private final BinanceDeposit[] depositList;
    
    public DepositList(@JsonProperty("depositList") final BinanceDeposit[] depositList, @JsonProperty("success") final boolean success, @JsonProperty("msg") final String msg) {
        super(success, msg);
        this.depositList = depositList;
    }
    
    @Override
    public List<BinanceDeposit> getData() {
        return Arrays.asList(this.depositList);
    }
    
    @Override
    public String toString() {
        return "DepositList [depositList=" + Arrays.toString(this.depositList) + "]";
    }
    
    public static final class BinanceDeposit
    {
        public final long insertTime;
        public final BigDecimal amount;
        public final String asset;
        public final String txId;
        public final String address;
        public final int status;
        
        public BinanceDeposit(@JsonProperty("insertTime") final long insertTime, @JsonProperty("amount") final BigDecimal amount, @JsonProperty("asset") final String asset, @JsonProperty("txId") final String txId, @JsonProperty("address") final String address, @JsonProperty("status") final int status) {
            this.insertTime = insertTime;
            this.amount = amount;
            this.asset = asset;
            this.status = status;
            this.txId = txId;
            this.address = address;
        }
        
        @Override
        public String toString() {
            return "BinanceDeposit [insertTime=" + this.insertTime + ", amount=" + this.amount + ", asset=" + this.asset + ", txId=" + this.txId + ", address=" + this.address + ", status=" + this.status + "]";
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance;

import org.knowm.xchange.exceptions.CurrencyPairNotValidException;
import org.knowm.xchange.exceptions.NonceException;
import org.knowm.xchange.exceptions.ExchangeUnavailableException;
import org.knowm.xchange.exceptions.FundsExceededException;
import org.knowm.xchange.exceptions.RateLimitExceededException;
import org.knowm.xchange.exceptions.ExchangeSecurityException;
import org.apache.commons.lang3.StringUtils;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.binance.dto.BinanceException;

public final class BinanceErrorAdapter
{
    private BinanceErrorAdapter() {
    }
    
    public static ExchangeException adapt(final BinanceException e) {
        String message = e.getMessage();
        if (StringUtils.isEmpty((CharSequence)message)) {
            message = "Operation failed without any error message";
        }
        switch (e.getCode()) {
            case -1002: {
                return (ExchangeException)new ExchangeSecurityException(message, (Throwable)e);
            }
            case -1003: {
                return (ExchangeException)new RateLimitExceededException(message, (Throwable)e);
            }
            case -2011:
            case -2010:
            case -1010: {
                if (e.getMessage().contains("insufficient balance")) {
                    return (ExchangeException)new FundsExceededException(e.getMessage(), (Throwable)e);
                }
                return new ExchangeException(message, (Throwable)e);
            }
            case -1016: {
                return (ExchangeException)new ExchangeUnavailableException(message, (Throwable)e);
            }
            case -1021: {
                return (ExchangeException)new NonceException(message, (Throwable)e);
            }
            case -1121: {
                return (ExchangeException)new CurrencyPairNotValidException(message, (Throwable)e);
            }
            case -1122: {
                return (ExchangeException)new ExchangeSecurityException(message, (Throwable)e);
            }
            default: {
                return new ExchangeException(message, (Throwable)e);
            }
        }
    }
}

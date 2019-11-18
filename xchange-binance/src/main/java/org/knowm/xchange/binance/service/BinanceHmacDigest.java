// 
// Decompiled by Procyon v0.5.36
// 

package org.knowm.xchange.binance.service;

import org.slf4j.LoggerFactory;
import java.util.Map;
import javax.crypto.Mac;
import java.io.UnsupportedEncodingException;
import org.knowm.xchange.utils.DigestUtils;
import javax.ws.rs.QueryParam;
import si.mazi.rescu.Params;
import si.mazi.rescu.RestInvocation;
import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.knowm.xchange.service.BaseParamsDigest;

public class BinanceHmacDigest extends BaseParamsDigest
{
    private static final Logger LOG;
    private final Field invocationUrlField;
    
    private BinanceHmacDigest(final String secretKeyBase64) {
        super(secretKeyBase64, "HmacSHA256");
        try {
            (this.invocationUrlField = RestInvocation.class.getDeclaredField("invocationUrl")).setAccessible(true);
        }
        catch (NoSuchFieldException | SecurityException ex2) {
            final Exception ex;
            final Exception e = ex;
            throw new RuntimeException(e);
        }
    }
    
    public static BinanceHmacDigest createInstance(final String secretKeyBase64) {
        return (secretKeyBase64 == null) ? null : new BinanceHmacDigest(secretKeyBase64);
    }
    
    private static String getQuery(final RestInvocation restInvocation) {
        final Params p = Params.of();
        restInvocation.getParamsMap().get(QueryParam.class).asHttpHeaders().entrySet().stream().filter(e -> !"signature".equals(e.getKey())).forEach(e -> p.add((String)e.getKey(), (Object)e.getValue()));
        return p.asQueryString();
    }
    
    public String digestParams(final RestInvocation restInvocation) {
        try {
            String input;
            if (restInvocation.getPath().startsWith("wapi/")) {
                input = getQuery(restInvocation);
            }
            else {
                final String httpMethod = restInvocation.getHttpMethod();
                switch (httpMethod) {
                    case "GET":
                    case "DELETE": {
                        input = getQuery(restInvocation);
                        break;
                    }
                    case "POST": {
                        input = restInvocation.getRequestBody();
                        break;
                    }
                    default: {
                        throw new RuntimeException("Not support http method: " + restInvocation.getHttpMethod());
                    }
                }
            }
            final Mac mac = this.getMac();
            mac.update(input.getBytes("UTF-8"));
            final String printBase64Binary = DigestUtils.bytesToHex(mac.doFinal());
            final String invocationUrl = restInvocation.getInvocationUrl();
            final String sig = "signature=";
            final int idx = invocationUrl.indexOf("signature=");
            final String newInvocationUrl = invocationUrl.substring(0, idx + "signature=".length()) + printBase64Binary;
            try {
                this.invocationUrlField.set(restInvocation, newInvocationUrl);
            }
            catch (IllegalArgumentException | IllegalAccessException ex2) {
                final Exception ex;
                final Exception e = ex;
                throw new RuntimeException(e);
            }
            return printBase64Binary;
        }
        catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Illegal encoding, check the code.", e2);
        }
    }
    
    static {
        LOG = LoggerFactory.getLogger((Class)BinanceHmacDigest.class);
    }
}

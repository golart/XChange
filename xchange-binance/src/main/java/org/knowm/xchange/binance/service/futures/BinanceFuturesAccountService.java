package org.knowm.xchange.binance.service.futures;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.binance.BinanceErrorAdapter;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.futures.BinanceFuturesAccountInformation;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord.Status;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.service.account.AccountService;

public class BinanceFuturesAccountService extends BinanceFuturesAccountServiceRaw
    implements AccountService {

  public BinanceFuturesAccountService(Exchange exchange) {
    super(exchange);
  }

  /** (0:pending,6: credited but cannot withdraw,1:success) */
  private static Status depositStatus(int status) {
    switch (status) {
      case 0:
      case 6:
        return Status.PROCESSING;
      case 1:
        return Status.COMPLETE;
      default:
        throw new RuntimeException("Unknown binance deposit status: " + status);
    }
  }

  private BinanceFuturesAccountInformation getBinanceAccountInformation() throws IOException {
    return super.account();
  }

  @Override
  public AccountInfo getAccountInfo() throws IOException {
    try {
      BinanceFuturesAccountInformation acc = getBinanceAccountInformation();
      List<Balance> balances =
          balance().stream()
              .map(
                  b ->
                      new Balance(
                          new Currency(b.getAsset()), b.getBalance(), b.getWithdrawAvailable()))
              .collect(Collectors.toList());
      return new AccountInfo(new Date(acc.getUpdateTime()), Wallet.Builder.from(balances).build());
    } catch (BinanceException e) {
      throw BinanceErrorAdapter.adapt(e);
    }
  }
}

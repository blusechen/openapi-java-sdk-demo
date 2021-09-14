package com.tigerbrokers.stock.openapi.demo.trade;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.request.TigerHttpRequest;
import com.tigerbrokers.stock.openapi.client.https.response.TigerHttpResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.Currency;
import com.tigerbrokers.stock.openapi.client.struct.enums.Market;
import com.tigerbrokers.stock.openapi.client.struct.enums.OrderStatus;
import com.tigerbrokers.stock.openapi.client.struct.enums.SecType;
import com.tigerbrokers.stock.openapi.client.util.builder.AccountParamBuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tigerbrokers.stock.openapi.demo.Config.*;

/**
 * Description:
 * Created by lijiawen on 2018/07/06.
 */
public class AccountDemo {

  private static final Logger log = LoggerFactory.getLogger(AccountDemo.class);
  private static TigerHttpClient client = new TigerHttpClient(serverUrl, tigerId, yourPrivateKey);

  @Test
  public void testGetContract() {
    TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.CONTRACT);
    String bizContent = AccountParamBuilder.instance()
        .account(account)
        .conid("42451645")
        .buildJson();
    request.setBizContent(bizContent);

    TigerHttpResponse response = client.execute(request);
    outputResponse(request.getApiMethodName(), bizContent, response);
  }

  @Test
  public void testGetAccount() {
    TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.ACCOUNTS);
    String bizContent = AccountParamBuilder.instance()
        .account("DU575569")
        .buildJson();
    request.setBizContent(bizContent);

    TigerHttpResponse response = client.execute(request);
    outputResponse(request.getApiMethodName(), bizContent, response);
  }

  @Test
  public void testGetAsset() {
    TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.ASSETS);
    String bizContent = AccountParamBuilder.instance()
        .account("DU575569")
        .buildJson();
    request.setBizContent(bizContent);

    TigerHttpResponse response = client.execute(request);
    outputResponse(request.getApiMethodName(), bizContent, response);
  }

  @Test
  public void testGetPosition() {
    TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.POSITIONS);

    String bizContent = AccountParamBuilder.instance()
        .account("DU575569")
        .currency(Currency.USD)
        .market(Market.US)
        .symbol("AAPL")
        .secType(SecType.STK)
        .buildJson();
    request.setBizContent(bizContent);

    TigerHttpResponse response = client.execute(request);
    outputResponse(request.getApiMethodName(), bizContent, response);
  }

  @Test
  public void testGetOrders() {
    TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.ORDERS);
    List<String> states = new ArrayList<>();
    states.add(OrderStatus.Submitted.name());
    states.add(OrderStatus.Filled.name());

    String bizContent = AccountParamBuilder.instance()
        .account("DU575569")
        .startDate("2018-07-21")
        .endDate("2018-11-28")
        .secType(SecType.STK)
        .market(Market.US)
        .states(states)
        .isBrief(false)
        .buildJson();
    request.setBizContent(bizContent);

    TigerHttpResponse response = client.execute(request);
    outputResponse(request.getApiMethodName(), bizContent, response);
  }

  private void outputResponse(String apiMethodName, String param, TigerHttpResponse response) {
    if (response != null) {
      log.info("请求方法:\n {}", apiMethodName);
      log.info("请求参数:\n {}", param);
      log.info("返回结果:\n code: {}\n message: {}\n data: {}", response.getCode(), response.getMessage(), response.getData());
    } else {
      log.error("请求失败:\n {}", param);
    }
  }
}

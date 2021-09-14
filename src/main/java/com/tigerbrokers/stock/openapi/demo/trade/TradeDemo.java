package com.tigerbrokers.stock.openapi.demo.trade;

import com.alibaba.fastjson.JSON;
import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.request.TigerHttpRequest;
import com.tigerbrokers.stock.openapi.client.https.response.TigerHttpResponse;
import com.tigerbrokers.stock.openapi.client.struct.TagValue;
import com.tigerbrokers.stock.openapi.client.struct.enums.*;
import com.tigerbrokers.stock.openapi.client.struct.param.OrderParameter;
import com.tigerbrokers.stock.openapi.client.util.StringUtils;
import com.tigerbrokers.stock.openapi.client.util.builder.TradeParamBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.tigerbrokers.stock.openapi.demo.Config.*;

/**
 * Description:
 * Created by lijiawen on 2018/05/31.
 */
public class TradeDemo {

    private static final Logger log = LoggerFactory.getLogger(TradeDemo.class);
    private static TigerHttpClient client = new TigerHttpClient(serverUrl, tigerId, yourPrivateKey);

    @Test
    public void testPlaceOptionOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("AAPL")
                .secType(SecType.OPT)
                .market(Market.US)
                .currency(Currency.USD)
                .expiry("20180810")
                .strike("182.5")
                .right("CALL")
                .multiplier(100F)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(61.0)
                .totalQuantity(1)
                .outsideRth(true)
                .timeInForce(TimeInForce.DAY)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceWarOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("00823")
                .secType(SecType.WAR)
                .market(Market.HK)
                .currency(Currency.HKD)
                .expiry("20181218")
                .strike("74.880")
                .right("PUT")
                .localSymbol("13768")
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(0.590)
                .totalQuantity(10000)
                .timeInForce(TimeInForce.DAY)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceUSStockOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("AAPL")
                .secType(SecType.STK)
                .market(Market.US)
                .currency(Currency.USD)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(182.0)
                .totalQuantity(100)
                .timeInForce(TimeInForce.DAY)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceHKStockOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("00700")
                .secType(SecType.STK)
                .market(Market.HK)
                .currency(Currency.HKD)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(380.0)
                .totalQuantity(100)
                .timeInForce(TimeInForce.DAY)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceConnectStockOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("600016")
                .secType(SecType.STK)
                .market(Market.CN)
                .currency(Currency.CNH)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(9.0)
                .totalQuantity(10)
                .timeInForce(TimeInForce.DAY)
                .outsideRth(false)
                .buildJson();

        request.setBizContent(bizContent);
        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceFutOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("NG")
                .secType(SecType.FUT)
                .market(Market.US)
                .currency(Currency.USD)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .expiry("20301126")
                .multiplier(10000f)
                .exchange("NYMEX")
                .limitPrice(9.0)
                .totalQuantity(10)
                .timeInForce(TimeInForce.DAY)
                .outsideRth(false)
                .buildJson();

        request.setBizContent(bizContent);
        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceAStockOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("600016")
                .secType(SecType.STK)
                .market(Market.CN)
                .currency(Currency.CNH)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(8.0)
                .totalQuantity(100)
                .timeInForce(TimeInForce.DAY)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceAlgoOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        List<String> accounts = new ArrayList<>();
        accounts.add("DU1003980");
        accounts.add("DU1003981");
        List<Double> shares = new ArrayList<>();
        shares.add(300.0);
        shares.add(200.0);
        List<TagValue> tagValues = new ArrayList<>();
        tagValues.add(new TagValue("participation_rate", "0.5"));
        tagValues.add(new TagValue("riskAversion", "GetDon"));
        tagValues.add(new TagValue("forceCompletion", "0"));

        String bizContent = TradeParamBuilder.instance()
                .account("DF1003979")
                .orderId(getOrderNo())
                .symbol("AAPL")
                .allocAccounts(accounts)
                .allocShares(shares)
                .totalQuantity(500)
                .limitPrice(61.0)
                .orderType(OrderType.LMT)
                .action(ActionType.BUY)
                .secType(SecType.STK)
                .currency(Currency.USD)
                .outsideRth(true)
                .algoStrategy("ArrivalPx")
                .algoParams(tagValues)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testPlaceCashOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.PLACE_ORDER);

        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(getOrderNo())
                .symbol("USD")
                .secType(SecType.CASH)
                .currency(Currency.HKD)
                .action(ActionType.BUY)
                .orderType(OrderType.LMT)
                .limitPrice(9.0)
                .totalQuantity(10)
                .timeInForce(TimeInForce.DAY)
                .outsideRth(false)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testCancelOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.CANCEL_ORDER);
        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .orderId(1000042974)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testModifyOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.MODIFY_ORDER);
        String bizContent = TradeParamBuilder.instance()
                .account(account)
                .totalQuantity(500)
                .action(ActionType.BUY)
                .limitPrice(61.2)
                .orderId(1000043432)
                .orderType(OrderType.LMT)
                .buildJson();
        request.setBizContent(bizContent);

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), bizContent, response);
    }

    @Test
    public void testBatchPlaceOrder() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.BATCH_PLACE_ORDER);
        List<OrderParameter> parameterList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            OrderParameter orderParameter = TradeParamBuilder.instance()
                    .account(account)
                    .orderId(i == 0 ? getOrderNo() : 0)
                    .symbol("AAPL")
                    .secType(SecType.STK)
                    .market(Market.US)
                    .currency(Currency.USD)
                    .action(ActionType.BUY)
                    .orderType(OrderType.LMT)
                    .limitPrice(182.0)
                    .totalQuantity(100)
                    .timeInForce(TimeInForce.DAY)
                    .build();
            parameterList.add(orderParameter);
        }
        request.setBizContent(JSON.toJSONString(parameterList));

        TigerHttpResponse response = client.execute(request);
        outputResponse(request.getApiMethodName(), request.getBizContent(), response);
    }

    private int getOrderNo() {
        TigerHttpRequest request = new TigerHttpRequest(ApiServiceType.ORDER_NO);
        String bizContent = TradeParamBuilder.instance().account(account).buildJson();
        request.setBizContent(bizContent);
        TigerHttpResponse response = client.execute(request);
        if (response != null && !StringUtils.isEmpty(response.getData())) {
            return JSON.parseObject(response.getData()).getIntValue("orderId");
        }
        throw new RuntimeException("获取订单号失败:" + response.getMessage());
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

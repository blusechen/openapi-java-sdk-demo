package com.tigerbrokers.stock.openapi.demo.quote;

import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureContinuousContractRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureContractByConCodeRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureContractByExchCodeRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureCurrentContractRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureExchangeRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureKlineRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureRealTimeQuoteRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureTickRequest;
import com.tigerbrokers.stock.openapi.client.https.request.future.FutureTradingDateRequest;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureBatchContractResponse;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureContractResponse;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureExchangeResponse;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureKlineResponse;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureRealTimeQuoteResponse;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureTickResponse;
import com.tigerbrokers.stock.openapi.client.https.response.future.FutureTradingDateResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.FutureKType;
import com.tigerbrokers.stock.openapi.client.struct.enums.SecType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static com.tigerbrokers.stock.openapi.demo.Config.serverUrl;
import static com.tigerbrokers.stock.openapi.demo.Config.tigerId;
import static com.tigerbrokers.stock.openapi.demo.Config.yourPrivateKey;

/**
 * Description:
 * Created by lijiawen on 2018/12/26.
 */
public class FutureDemo {

  private static TigerHttpClient client = new TigerHttpClient(serverUrl, tigerId, yourPrivateKey);

  @Test
  public void getFutureExchange() {
    FutureExchangeResponse response = client.execute(FutureExchangeRequest.newRequest(SecType.FUT.name()));
    System.out.println(Arrays.toString(response.getFutureExchangeItems().toArray()));
  }

  @Test
  public void getFutureContinuousContracts() {
    FutureContractResponse cl = client.execute(FutureContinuousContractRequest.newRequest("ES"));
    System.out.println(cl.getFutureContractItem());
  }

  @Test
  public void getFutureContractByContractCode() {
    FutureContractResponse response = client.execute(FutureContractByConCodeRequest.newRequest("CL1902"));
    System.out.println(response.getFutureContractItem());
  }

  @Test
  public void getFutureContractByExchangeCode() {
    FutureBatchContractResponse response = client.execute(FutureContractByExchCodeRequest.newRequest("CME"));
    System.out.println(response.getFutureContractItems());
  }

  @Test
  public void getFutureCurrentContract() {
    FutureContractResponse response = client.execute(FutureCurrentContractRequest.newRequest("CL"));
    System.out.println(response.getFutureContractItem());
  }

  @Test
  public void getFutureKline() {
    List<String> contractCodes = new ArrayList<>();
    contractCodes.add("CL1902");

    FutureKlineResponse response = client.execute(
        FutureKlineRequest.newRequest(contractCodes, FutureKType.min15, 1535634249489L,
            1538807049489L, 200));
    System.out.println(response.getFutureKlineItems());
  }

  @Test
  public void getFutureRealtimeQuote() {
    List<String> contractCodes = new ArrayList<>();
    contractCodes.add("CL1902");

    FutureRealTimeQuoteResponse response = client.execute(FutureRealTimeQuoteRequest.newRequest(contractCodes));
    System.out.println(response.getFutureRealTimeItems());
  }

  @Test
  public void getFutureTick() {
    List<String> contractCodes = new ArrayList<>();
    contractCodes.add("CL1902");

    FutureTickResponse response = client.execute(FutureTickRequest.newRequest(contractCodes, 0, 1000));
    System.out.println(response.getFutureTickItems());
  }

  @Test
  public void getFutureTradingDate() {
    FutureTradingDateResponse response =
        client.execute(FutureTradingDateRequest.newRequest("CL1902", System.currentTimeMillis()));
    System.out.println(response.getFutureTradingDateItem());
  }
}

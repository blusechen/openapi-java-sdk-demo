package com.tigerbrokers.stock.openapi.demo;

/**
 * Description:
 * Created by lijiawen on 2018/07/25.
 */
public final class Config {

  /**
   * 线上http接口地址
   */
  public static String serverUrl = "https://openapi.itiger.com/gateway";

  /**
   * 线上消息推送接口地址
   */
  public static String webSocketServerUrl = "wss://openapi.itiger.com:8883";

  /**
   * 参数必填,tigerId : 形如2015xxxx,查询地址：https://www.itiger.com/openapi/info
   */
  public static String tigerId = "1";

  /**
   * 交易资金账号，查询地址：https://www.itiger.com/openapi/info
   */
  public static String account = "DU575569";

  /**
   * 参数必填,yourPrivateKey : 开发者注册时生成的私钥
   * 生成方式 : https://quant.itiger.com/openapi/java-docs/zh-cn/docs/intro/quickstart.html
   * 如果报错,可以比对下下面的私钥实例 testPrivateKey 或者 testPrivateKey1(去除了头尾、换行和空格)
   */
  public static String yourPrivateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALVqZlrliwZOSWvLsMCxQE7BckKCuxlm0HbU8ibD/IuatupF+xLe9rC8yKAtZwLAgOcdr6Gl2l7N7R4cjBtnMnNQMa9EAtgr23cPynA9XGnBfU4XxF8cIzthC9I688+cce5VC8ppHs02bX9aa8ZcL2RUl2RhDuQKaHnayIWjLUwtAgMBAAECgYBVptyYgdO3sHKdwFe9QnKYPGET4eEwRwiZckS55MJxryQ5S70U1cwm+ZrHdWgzNmwlsjBf44xMQnF3TAciUQDSAQKMPAUrhDjar6m07hAAElBVILoj5063Y4hjby69PeuR6c47wpEgO3gXnY8V3vVl0HVppeLE5E5GrUx1IuLwSQJBAOK+IAH4vlH8dXHDG+pl8nnfQ60V3kiKlkL1hmVjUK1dYKa7z0srtRSUS41fIaw7HLPmMuoW41GyJ7kALbe18Q8CQQDM0wJrxrElZ89kgfi0attnUXcjjUFB2CnbMGZHsDJQwEOSWLzo7OYntBQIkD88nErjf8hhRabg5TlD5K9cKvcDAkEAlMGPVjvPARLUKlKK2fkQX4xuZfvW3ViuxDc4eQPzRgnhAwJsOTDvmBTCjHlBKjGN3yjDdniVol9zWBgZ5lDjWQJBAIKJDCbxxx4GrdbpOj6JR3DuK1aeBHPZNru5ecXAViC+l5HiOercZ8Xv70CR5atUFCou2t6bTEJR9A//436C508CQEUtu3vz8ylAYQNzuPK78oTkynjAwwNBDByH1Uu+wBnBYvKwHqtlamjeMh+n3NntzfM5gY0xYBmO0yY2REnwI4c=";

  /**
   * 老虎公钥，在SDK中已集成，如果用户是自己对接的rest api，拿到接口返回结果后，需要通过老虎公钥来验证其中的签名信息，确保数据是老虎开放平台返回
   */
  public static String tigerPubKey =
      "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNF3G8SoEcCZh2rshUbayDgLLrj6rKgzNMxDL2HSnKcB0+GPOsndqSv+a4IBu9+I3fyBp5hkyMMG2+AXugd9pMpy6VxJxlNjhX1MYbNTZJUT4nudki4uh+LMOkIBHOceGNXjgB+cXqmlUnjlqha/HgboeHSnSgpM3dKSJQlIOsDwIDAQAB";
}

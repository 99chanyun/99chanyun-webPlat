package com.chanyun.common.constants;

/**
 * 常量
 */
public class WeChatPayConstants {

    public enum SignType{
        MD5, HMACSHA256
    }

    public enum TradeType{
        JSAPI, NATIVE, MWEB, APP
    }

    //失败
    public static final String FAIL = "FAIL";

    //成功
    public static final String SUCCESS = "SUCCESS";

    //HMACSHA256
    public static final String HMACSHA256 = "HMAC-SHA256";

    //MD5
    public static final String MD5 = "MD5";

    //sign
    public static final String FIELD_SIGN = "sign";

    //PKCS12
    public static final String PKCS12 = "PKCS12";

    //TLS
    public static final String TLS = "TLS";

    //UTF-8
    public static final String UTF8 = "UTF-8";

    //签名不匹配通知微信的字符串
    public static final String SIGN_NOT_MATCH_BACK_STRING = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[签名不匹配]]></return_msg></xml>";

    //商户号不匹配通知微信的字符串
    public static final String PARTNER_NOT_MATCH_BACK_STRING = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[商户号不匹配]]></return_msg></xml>";

    //异步通知成功通知微信的字符串
    public static final String SUCCESS_BACK_STRING = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

    //异步通知失败通知微信的字符串
    public static final String FAIL_BACK_STRING = "<xml><return_code><![CDATA[FAIL]]></return_code></xml>";

}

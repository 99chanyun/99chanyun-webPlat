package com.chanyun.common.constants;

/**
 * 微信接口的key
 * 
 */
public class WechatKeyConstants {

    /** 签名 */
    public static final String SIGN = "sign";

    /** 返回状态码 */
    public static final String RETURN_CODE = "return_code";

    /** 业务结果 */
    public static final String RESULT_CODE = "result_code";

    /** 预支付交易会话标识 */
    public static final String PREPAY_ID = "prepay_id";

    /** 错误代码 */
    public static final String ERR_CODE = "err_code";

    /** 返回信息 */
    public static final String RETURN_MSG = "return_msg";

    /**
     * 订单金额 total_fee 是 Int 100 订单总金额，单位为分.
     * 
     * @since 5.3.2.18
     */
    public static final String TOTAL_FEE = "total_fee";

    /** 错误代码描述 */
    public static final String ERR_CODE_DES = "err_code_des";

    /** 交易状态 */
    public static final String TRADE_STATE = "trade_state";

    /** 商户交易号 */
    public static final String OUT_TRADE_NO = "out_trade_no";

    /** 微信支付订单号 */
    public static final String TRANSACTION_ID = "transaction_id";

    /** 商户号 */
    public static final String MCH_ID = "mch_id";

    /** 公众账号ID **/
    public static final String APPID = "appid";

    /** 用户标识 */
    public static final String OPENID = "openid";

    /** 设备号 **/
    public static final String DEVICE_INFO = "device_info";

    /** 随机字符串 **/
    public static final String NONCE_STR = "nonce_str";

    /** 签名用的key **/
    public static final String SIGN_KEY = "sign_key";

    /**
     * trade_state交易状态值域
     * 
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * REVOKED—已撤销（刷卡支付）
     * USERPAYING--用户支付中
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     * 
     * @author hao.li
     * @since 5.3.2.20
     */
    public enum TradeStateValue{
        SUCCESS, REFUND, NOTPAY, CLOSED, REVOKED, USERPAYING, PAYERROR
    }

    public enum NativeKeyValue{
        mch_id, nonce_str, app_id, prepay_id, code_url
    }

    public enum AppKeyValue{
        timestamp, partnerid, appid, prepayid, noncestr
    }

    public enum H5KeyValue{
        mch_id, nonce_str, app_id, prepay_id, mweb_url
    }

    public enum JSAPIKeyValue{
        timeStamp, appId, nonceStr, signType
    }

    /** 交易类型 **/
    public static final String TRADE_TYPE = "trade_type";

    /** 二维码链接 **/
    public static final String CODE_URL = "code_url";

    /** H5支付链接 **/
    public static final String MWEB_URL = "mweb_url";

    /** 交易类型JSAPI **/
    public static final String TRADE_TYPE_JSAPI = "JSAPI";

    /** 交易类型NATIVE **/
    public static final String TRADE_TYPE_NATIVE = "NATIVE";

    /** 交易类型APP **/
    public static final String TRADE_TYPE_APP = "APP";

    /** 交易类型WAP **/
    public static final String TRADE_TYPE_WAP = "WAP";

    /** 交易类型H5 **/
    public static final String TRADE_TYPE_MWEB = "MWEB";

    /** 交易时间 **/
    public static final String TIME_END = "time_end";

    /** 标价币种 **/
    public static final String FEE_TYPE = "fee_type";

    /** 商户的店铺编号 **/
    public static final String STORE_CODE = "store_code";

    /** 平台为每个商户分配的商户号 **/
    public static final String MERC_CODE = "merc_code";

    /** 商品描述 **/
    public static final String BODY = "body";

    /** 商品详情 **/
    public static final String DETAIL = "detail";

    /** 附加数据 **/
    public static final String ATTACH = "attach";

    /** 商品ID **/
    public static final String PRODUCT_ID = "product_id";

    /** 交易结束时间 **/
    public static final String TIME_EXPIRE = "time_expire";

    /** 终端IP **/
    public static final String SPBILL_CREATE_IP = "spbill_create_ip";

    /** 异步通知地址 **/
    public static final String NOTIFY_URL = "notify_url";

    /** 扩展字段 **/
    public static final String WX_PACKAGE = "wx_package";

    /** 时间戳 **/
    public static final String TIME_STAMP = "time_stamp";

    /** 签名类型 **/
    public static final String SIGN_TYPE = "sign_type";

    /** 付款银行 **/
    public static final String BANK_TYPE = "bank_type";

    /** 现金支付金额 **/
    public static final String CASH_FEE = "cash_fee";

    /** 是否关注公众账号 **/
    public static final String IS_SUBSCRIBE = "is_subscribe";

    /** unex签名 **/
    public static final String UNEX_SIGN = "unex_sign";

    /** unex版本 **/
    public static final String UNEX_VERSION = "unex_version";

    /** 支付平台退款单号 **/
    public static final String OUT_REFUND_NO = "out_refund_no";

    /** 退款金额 **/
    public static final String REFUND_FEE = "refund_fee";

    /** 加密信息 **/
    public static final String REQ_INFO = "req_info";

    /** 微信退款单号 **/
    public static final String REFUND_ID = "refund_id";

    /** 应结订单金额 **/
    public static final String SETTLEMENT_TOTAL_FEE = "settlement_total_fee";

    /** 退款金额 **/
    public static final String SETTLEMENT_REFUND_FEE = "settlement_refund_fee";

    /** 退款状态 **/
    public static final String REFUND_STATUS = "refund_status";

    /** 退款成功时间 **/
    public static final String SUCCESS_TIME = "success_time";

    /** 退款入账账户 **/
    public static final String REFUND_RECV_ACCOUT = "refund_recv_accout";

    /** 退款资金来源 **/
    public static final String REFUND_ACCOUNT = "refund_account";

    /** 退款发起来源 **/
    public static final String REFUND_REQUEST_SOURCE = "refund_request_source";

    /** 现金支付货币类型 **/
    public static final String CASH_FEE_TYPE = "cash_fee_type";

    /** 现金退款金额 **/
    public static final String CASH_REFUND_FEE = "cash_refund_fee";

    /** 场景信息 **/
    public static final String SCENE_INFO = "scene_info";

}

package com.chanyun.service.channel.weixin;

import com.alibaba.fastjson.JSON;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.code.PaymentTypeEnum;
import com.chanyun.common.constants.WeChatPayConstants.SignType;
import com.chanyun.common.constants.WeChatPayConstants.TradeType;
import com.chanyun.common.constants.WechatKeyConstants.AppKeyValue;
import com.chanyun.common.constants.WechatKeyConstants.H5KeyValue;
import com.chanyun.common.constants.WechatKeyConstants.JSAPIKeyValue;
import com.chanyun.common.constants.WechatKeyConstants.NativeKeyValue;
import com.chanyun.common.util.CreateNoUtil;
import com.chanyun.common.util.StringUtil;
import com.chanyun.common.util.WeChatPayRequestUtil;
import com.chanyun.common.util.WeChatPayUtil;
import com.chanyun.entity.PaymentApply;
import com.chanyun.service.IPaymentApplyService;
import com.chanyun.service.channel.IChannelCreateOrderService;
import com.chanyun.vo.CreateOrderVo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Service("weixinCreateOrderService")
@Slf4j
public class WeixinCreateOrderService extends WeixinCommonService implements IChannelCreateOrderService {

    @Autowired
    private IPaymentApplyService paymentApplyService;
    WeChatPayRequestUtil weixinPayRequestUtil = new WeChatPayRequestUtil();

    public WeixinCreateOrderService() {
    }

    @Override
    public BaseResult<String> createOrder(CreateOrderVo createOrderVo) {
        log.info("调用微信创单接口");

        BaseResult<String> baseResult = new BaseResult();
        HashMap<String, String> addition = new HashMap();
        addition.put("appid", APP_ID);
        addition.put("mch_id", MCH_ID);
//        if (StringUtil.contains(PaymentTypeEnum.JSAPI.code(), createOrderVo.getPaymentType().toLowerCase())) {
//            addition.put("trade_type", TradeType.JSAPI.toString());
//            addition.put("openid", createOrderVo.getWeixinOpenId());
//        }

        if (StringUtil.contains(PaymentTypeEnum.WAP.code(), createOrderVo.getPaymentType().toLowerCase())) {
            addition.put("trade_type", TradeType.MWEB.toString());
            addition.put("scene_info", createOrderVo.getWeixinSceneInfo());
        }

        if (StringUtil.contains(PaymentTypeEnum.NATIVE.code(), createOrderVo.getPaymentType().toLowerCase())) {
            addition.put("trade_type", TradeType.NATIVE.toString());
            addition.put("product_id", createOrderVo.getWeixinProductId());
        }

        if (StringUtil.contains(PaymentTypeEnum.APP.code(), createOrderVo.getPaymentType().toLowerCase())) {
            addition.put("trade_type", TradeType.APP.toString());
        }

        addition.put("fee_type", "CNY");
        addition.put("total_fee", (int) (new BigDecimal(createOrderVo.getPayAmount())).multiply(new BigDecimal(100)).doubleValue() + "");
        if (StringUtil.isNotBlank(createOrderVo.getOrderDesc())) {
            addition.put("body", createOrderVo.getOrderDesc());
        }

        if (StringUtil.isNotBlank(createOrderVo.getMemo())) {
            addition.put("attach", createOrderVo.getMemo());
        }

        if (StringUtil.isNotBlank(createOrderVo.getOrderExpireTime())) {
            addition.put("time_expire", createOrderVo.getOrderExpireTime());
        }

        addition.put("sign_type", SignType.MD5.toString());
        addition.put("spbill_create_ip", createOrderVo.getWeixinSpbillCreateIp());
        addition.put("notify_url", NOTIFY_URL);
        addition.put("nonce_str", WeChatPayUtil.getRandomStringByLength(32));
        String payOrderNo = CreateNoUtil.createNo();
        addition.put("out_trade_no", payOrderNo);
        if (log.isDebugEnabled()) {
            log.debug("object info:{}", JSON.toJSONString(addition));
        }

        String sign = WeChatPayUtil.getSign(addition, null, SIGN_KEY);
        addition.put("sign", sign);

        String xmlInfo = null;
        try {
            xmlInfo = WeChatPayUtil.mapToXml(addition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = null;
        Map responseMap = null;

        try {
            response = this.weixinPayRequestUtil.requestOnce(UNIFIED_URL, xmlInfo, 1000, 1000, false, (byte[]) null);
            responseMap = WeChatPayUtil.xmlToMap(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.debug("response xml info: [{}]", response);
        if (log.isInfoEnabled()) {
            log.info("responseMap:[{}]", JSON.toJSONString(responseMap));
        }


        if ("SUCCESS".equals(responseMap.get("return_code"))) {
            if ("SUCCESS".equals(responseMap.get("result_code"))) {
                String resSign = null;
                String responseSign = (String) responseMap.get("sign");

                try {
                    resSign = WeChatPayUtil.getSign(responseMap, "sign", SIGN_KEY);
                } catch (Exception var18) {
                    log.error("sign failure");
                    var18.printStackTrace();
                }

                if (responseSign.equals(resSign)) {
                    responseMap = this.getDiffirentSign(responseMap, SIGN_KEY);

                    try {

                        baseResult.setCode(Constants.RESULT_CODE_SUCCESS);
                        baseResult.setMessage("success");
                        baseResult.setData(JSON.toJSONString(responseMap));
                        // 保存支付申请记录
                        PaymentApply paymentApply = new PaymentApply();
                        paymentApply.setOrderNo(createOrderVo.getOrderNo());
                        paymentApply.setPayOrderNo(payOrderNo);
                        paymentApply.setChannelType(createOrderVo.getChannelType());
                        paymentApply.setPaymentType(createOrderVo.getPaymentType());
                        paymentApply.setPrepayData(JSON.toJSONString(responseMap));
                        paymentApplyService.insertSelective(paymentApply);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    log.error("unifiedOrder sign not match, parameter sign : {}, local sign : {}", responseMap.get("sign"), resSign);
                }
            } else {
                log.error("unifiedOrder failure , result_code : {}, err_code : {},err_code_des : {}", new Object[]{responseMap.get("result_code"), responseMap.get("err_code"), responseMap.get("err_code_des")});
                baseResult.setCode(Constants.RESULT_CODE_FAIL);
                baseResult.setMessage((String) responseMap.get("err_code_des"));
                baseResult.setData(JSON.toJSONString(responseMap));
            }
        } else {
            log.error("unifiedOrder failure , return_code : {}, return_msg : {}", responseMap.get("return_code"), responseMap.get("return_msg"));
            baseResult.setCode(Constants.RESULT_CODE_FAIL);
            baseResult.setMessage((String) responseMap.get("return_msg"));
        }

        return baseResult;
    }

    private Map<String, String> getDiffirentSign(Map<String, String> responseMap, String paySignKey) {
        Map<String, String> dataMap = new HashMap();
        String tradeType = (responseMap.get("trade_type")).toLowerCase();
        String mch_id = responseMap.get("mch_id");
        String nonce_str = responseMap.get("nonce_str");
        String app_id = responseMap.get("appid");
        String prepay_id = responseMap.get("prepay_id");
        String code_url = responseMap.get("code_url");
        String mweb_url = responseMap.get("mweb_url");
        String timestamp = System.currentTimeMillis() / 1000L + "";
        if (StringUtils.contains(tradeType, PaymentTypeEnum.NATIVE.code())) {
            dataMap.put(NativeKeyValue.mch_id.toString(), mch_id);
            dataMap.put(NativeKeyValue.nonce_str.toString(), nonce_str);
            dataMap.put(NativeKeyValue.app_id.toString(), app_id);
            dataMap.put(NativeKeyValue.prepay_id.toString(), prepay_id);
            dataMap.put(NativeKeyValue.code_url.toString(), code_url);
        }

        if (StringUtils.contains(tradeType, PaymentTypeEnum.WAP.code())) {
            dataMap.put(H5KeyValue.mch_id.toString(), mch_id);
            dataMap.put(H5KeyValue.nonce_str.toString(), nonce_str);
            dataMap.put(H5KeyValue.app_id.toString(), app_id);
            dataMap.put(H5KeyValue.prepay_id.toString(), prepay_id);
            dataMap.put(H5KeyValue.mweb_url.toString(), mweb_url);
        }

        if (StringUtils.contains(tradeType, PaymentTypeEnum.APP.code())) {
            dataMap.put("package", "Sign=WXPay");
            dataMap.put(AppKeyValue.timestamp.toString(), timestamp);
            dataMap.put(AppKeyValue.partnerid.toString(), mch_id);
            dataMap.put(AppKeyValue.appid.toString(), app_id);
            dataMap.put(AppKeyValue.prepayid.toString(), prepay_id);
            dataMap.put(AppKeyValue.noncestr.toString(), nonce_str);
            responseMap.put("wx_package", "Sign=WXPay");
            responseMap.put("time_stamp", timestamp);
        }

        if (StringUtils.contains(tradeType, PaymentTypeEnum.JSAPI.code())) {
            dataMap.put(JSAPIKeyValue.timeStamp.toString(), timestamp);
            dataMap.put(JSAPIKeyValue.appId.toString(), app_id);
            dataMap.put(JSAPIKeyValue.nonceStr.toString(), nonce_str);
            dataMap.put("package", "prepay_id=" + prepay_id);
            dataMap.put(JSAPIKeyValue.signType.toString(), SignType.MD5.toString());
            responseMap.put("time_stamp", timestamp);
            responseMap.put("sign_type", SignType.MD5.toString());
            responseMap.put("wx_package", "prepay_id=" + prepay_id);
        }

        String sign = WeChatPayUtil.getSign(dataMap, (String) null, paySignKey);
        responseMap.put("sign", sign);
        return responseMap;
    }
}

package com.chanyun.service.channel.weixin;

import com.alibaba.fastjson.JSON;
import com.chanyun.common.constants.WeChatPayConstants;
import com.chanyun.common.constants.WechatKeyConstants;
import com.chanyun.common.util.WeChatPayUtil;
import com.chanyun.entity.PaymentOrder;
import com.chanyun.service.impl.PaymentOrderService;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 微信异步通知处理接口实现
 *
 * @author hao.li
 */
@Service("weixinReturnService")
@Slf4j
public class WeixinReturnService extends WeixinCommonService{

    @Autowired
    private PaymentOrderService paymentOrderService;


    public String backReturn(Map<String, String> params) {

        log.info("调用微信异步回调接口");

        Validate.notEmpty(params, "responseMap can't be null/empty!");
        String backString;
        PaymentOrder paymentOrder;
        if ("SUCCESS".equals(params.get(WechatKeyConstants.RETURN_CODE))) {
            if ("SUCCESS".equals(params.get(WechatKeyConstants.RESULT_CODE))) {
                //查询支付订单
                String payOrderNo = params.get(WechatKeyConstants.OUT_TRADE_NO);
                paymentOrder = paymentOrderService.queryPaymentOrderByPayOrderNo(payOrderNo);
                if (paymentOrder != null) {
                    log.info("getPaymentResultFromNotification OrderStatus SUCCESSED, Need no more notification");
                    return WeChatPayConstants.SUCCESS_BACK_STRING;
                }
                //金额校验
//                BigDecimal totalFee = new BigDecimal(params.get(WechatKeyConstants.TOTAL_FEE)).divide(new BigDecimal(100));
//                BigDecimal payAmount = paymentOrderVo.getPayAmount() == null ? new BigDecimal(0) : paymentOrderVo.getPayAmount();
//                if (totalFee.subtract(payAmount).doubleValue() != 0) {
//                    log.error("getPaymentResultFromNotification totalFee not match, totalFee : {}, payAmount : {}", totalFee, payAmount);
//                    return WeChatPayConstants.FAIL_BACK_STRING;
//                }

                String signKey = SIGN_KEY;
                String mchId = MCH_ID;
                if (log.isInfoEnabled()) {
                    log.info(JSON.toJSONString(params));
                }

                String sign = params.get(WechatKeyConstants.SIGN);
                String resSign = WeChatPayUtil.getSignAllowNull(params, WechatKeyConstants.SIGN, signKey);
                //验证签名
                if (!sign.equals(resSign)) {
                    log.error("getPaymentResultFromNotification sign not match, parameter sign : {}, local sign : {}", sign, resSign);
                    //返回结果通知
                    return WeChatPayConstants.SIGN_NOT_MATCH_BACK_STRING;
                }

                String partner = params.get(WechatKeyConstants.MCH_ID);// 商户号

                // 验证商户号是否一致

                if (!mchId.equals(partner)) {
                    log.error("getPaymentResultFromNotification partner not match, parameter partner : {}, local partner : {}", partner,
                                    mchId);
                    //返回结果通知
                    return WeChatPayConstants.PARTNER_NOT_MATCH_BACK_STRING;
                }

                backString = WeChatPayConstants.SUCCESS_BACK_STRING;
            } else {
                log.error("getPaymentResultFromNotification failure , result_code : {}, err_code : {},err_code_des : {}",
                                params.get(WechatKeyConstants.RESULT_CODE), params.get(WechatKeyConstants.ERR_CODE),
                                params.get(WechatKeyConstants.ERR_CODE_DES));
                backString = WeChatPayConstants.FAIL_BACK_STRING;
            }

        } else {
            log.error("getPaymentResultFromNotification failure , return_code : {}, return_msg : {}",
                            params.get(WechatKeyConstants.RETURN_CODE), params.get(WechatKeyConstants.RETURN_MSG));
            return WeChatPayConstants.FAIL_BACK_STRING;
        }
        //支付结果插入订单表
        paymentOrderService.insertSelective(params);

        //返回结果通知
        return backString;
    }

}

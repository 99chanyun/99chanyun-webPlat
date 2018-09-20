package com.chanyun.service.impl;

import com.chanyun.common.code.PaymentStatusEnum;
import com.chanyun.common.constants.WechatKeyConstants;
import com.chanyun.dao.PaymentOrderMapper;
import com.chanyun.entity.PaymentOrder;
import com.chanyun.service.IPaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Service
public class PaymentOrderService implements IPaymentOrderService{

    @Autowired
    private PaymentOrderMapper paymentOrderMapper;

    @Override
    public PaymentOrder queryPaymentOrderByPayOrderNo(String payOrderNo){
        return paymentOrderMapper.queryPaymentOrderByPayOrderNo(payOrderNo);
    }

    @Override
    public int insertSelective(Map<String, String> params){
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setPayOrderNo(params.get(WechatKeyConstants.OUT_TRADE_NO));
        paymentOrder.setChannelOrderNo(params.get(WechatKeyConstants.TRANSACTION_ID));
        paymentOrder.setChannelOrderTime(params.get(WechatKeyConstants.TIME_END));
        paymentOrder.setChannelType("WEIXIN");
        paymentOrder.setPaymentType(params.get(WechatKeyConstants.TRADE_TYPE));
        paymentOrder.setCurrency(params.get(WechatKeyConstants.FEE_TYPE));
        paymentOrder.setPayAmount(new BigDecimal(params.get(WechatKeyConstants.TOTAL_FEE)).divide(new BigDecimal(100)));
        paymentOrder.setPayOrderStatus(PaymentStatusEnum.PAY_SUCCESS.code());
        paymentOrder.setMemo(params.get(WechatKeyConstants.ATTACH));
        paymentOrder.setCreateTime(new Date());
        return paymentOrderMapper.insertSelective(paymentOrder);
    }
}

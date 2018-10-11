package com.chanyun.service;

import java.util.List;

import com.chanyun.entity.PaymentApply;

import org.springframework.stereotype.Service;

public interface IPaymentApplyService {

    public PaymentApply initApply(String orderNo, String ChannelType, String paymentType);

    public int insertSelective(PaymentApply paymentApply);
    
    public PaymentApply queryByPayOrderNo(String payOrderNo);
}

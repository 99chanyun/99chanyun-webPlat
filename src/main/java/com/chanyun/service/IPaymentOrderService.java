package com.chanyun.service;

import com.chanyun.entity.PaymentOrder;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface IPaymentOrderService {

    PaymentOrder queryPaymentOrderByPayOrderNo(String payOrderNo);

    int insertSelective(Map<String, String> params);

}

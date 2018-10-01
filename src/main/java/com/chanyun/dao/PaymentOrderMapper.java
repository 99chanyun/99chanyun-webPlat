package com.chanyun.dao;

import com.chanyun.entity.PaymentOrder;

public interface PaymentOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentOrder record);

    int insertSelective(PaymentOrder record);

    PaymentOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentOrder record);

    int updateByPrimaryKey(PaymentOrder record);

    PaymentOrder queryPaymentOrderByPayOrderNo(String payOrderNo);
    
}
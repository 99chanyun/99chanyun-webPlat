package com.chanyun.dao;

import com.chanyun.entity.PaymentApply;

public interface PaymentApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentApply record);

    int insertSelective(PaymentApply record);

    PaymentApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentApply record);

    int updateByPrimaryKey(PaymentApply record);

    PaymentApply selectByPaymentApply(PaymentApply  paymentApply);
}
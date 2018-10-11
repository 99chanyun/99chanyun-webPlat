package com.chanyun.service.impl;

import java.util.List;

import com.chanyun.dao.PaymentApplyMapper;
import com.chanyun.entity.PaymentApply;
import com.chanyun.service.IPaymentApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentApplyService implements IPaymentApplyService {

    @Autowired
    private PaymentApplyMapper paymentApplyMapper;

    @Override
    public PaymentApply initApply(String orderNo, String ChannelType, String paymentType) {
        PaymentApply paymentApply = new PaymentApply();
        paymentApply.setOrderNo(orderNo);
        paymentApply.setChannelType(ChannelType);
        paymentApply.setPaymentType(paymentType);
        paymentApply = paymentApplyMapper.selectByPaymentApply(paymentApply);
        return paymentApply;
    }

    @Override
    public int insertSelective(PaymentApply paymentApply){
        return paymentApplyMapper.insertSelective(paymentApply);
    }

	/* (non-Javadoc)
	 * @see com.chanyun.service.IPaymentApplyService#queryByOrderNo(java.lang.String)
	 */
	@Override
	public PaymentApply queryByPayOrderNo(String payOrderNo) {
		PaymentApply paymentApply = new PaymentApply();
        paymentApply.setPayOrderNo(payOrderNo);
        List<PaymentApply> result = paymentApplyMapper.selectByOrderNo(paymentApply);
        if(null != result && result.size() > 0 ) return result.get(0);
        return null;
	}
}

package com.chanyun.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.entity.PaymentApply;
import com.chanyun.service.MeritsService;
import com.chanyun.service.OrderPayService;
import com.chanyun.service.channel.ChannelPaymentFactory;
import com.chanyun.service.channel.IChannelCreateOrderService;
import com.chanyun.vo.CreateOrderVo;

@Service
@Slf4j
public class OrderPayServiceImpl implements OrderPayService {
	@Autowired
	private MeritsService meritsService;
	@Autowired
	private PaymentApplyService paymentApplyService;
	@Autowired
    private ChannelPaymentFactory channelPaymentFactory;
	
	@Override
	public BaseResult<String> orderPay(CreateOrderVo createOrderVo) {
		log.info("统一下单");
        BaseResult<String> baseResult = new BaseResult<String>();

        // 幂等处理(如果订单已经申请支付，则返回预支付字符串，如果为空，则发起支付)
        PaymentApply paymentApply = paymentApplyService.initApply(createOrderVo.getOrderNo(),createOrderVo.getChannelType(),createOrderVo.getPaymentType());
        if(paymentApply != null){
            baseResult.setCode(Constants.RESULT_CODE_SUCCESS);
            baseResult.setMessage("SUCCESS");
            baseResult.setData(JSON.toJSONString(paymentApply.getPrepayData()));
        }else{
            // 发起支付
            IChannelCreateOrderService channelCreateOrderService = channelPaymentFactory
                    .getCreateOrderService(createOrderVo.getChannelType(), createOrderVo.getPaymentType());
            baseResult = channelCreateOrderService.createOrder(createOrderVo);
        }
        return baseResult;
	}

}

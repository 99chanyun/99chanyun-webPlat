package com.chanyun.service.channel;

import com.chanyun.common.BaseResult;
import com.chanyun.vo.CreateOrderVo;

public interface IChannelCreateOrderService {

    BaseResult<String> createOrder(CreateOrderVo createOrderVo);
}

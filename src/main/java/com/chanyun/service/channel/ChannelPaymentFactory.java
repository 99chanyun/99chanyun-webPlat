package com.chanyun.service.channel;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChannelPaymentFactory {
    @Autowired
    @Qualifier("weixinCreateOrderService")
    private IChannelCreateOrderService weixinCreateOrderService;

    public ChannelPaymentFactory() {
    }

    /*
    根据支付渠道和支付方式生成对应的支付service
     */
    public IChannelCreateOrderService getCreateOrderService(String channelType, String paymentType) {
        log.info("getCreateOrderService: channelType=" + channelType + ", paymentType=" + paymentType);
        return this.weixinCreateOrderService;
    }
}

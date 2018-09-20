package com.chanyun.service.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChannelPaymentFactory {
    private static final Logger logger = LoggerFactory.getLogger(ChannelPaymentFactory.class);
    @Autowired
    @Qualifier("weixinCreateOrderService")
    private IChannelCreateOrderService weixinCreateOrderService;

    public ChannelPaymentFactory() {
    }

    /*
    根据支付渠道和支付方式生成对应的支付service
     */
    public IChannelCreateOrderService getCreateOrderService(String channelType, String paymentType) {
        logger.info("getCreateOrderService: channelType=" + channelType + ", paymentType=" + paymentType);
        return this.weixinCreateOrderService;
    }
}

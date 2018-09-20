package com.chanyun.service.channel.weixin;

import org.springframework.beans.factory.annotation.Value;

public abstract class WeixinCommonService {

    @Value("${payment.weixin.unifiedUrl}")
    protected String UNIFIED_URL;
    @Value("${payment.weixin.appId}")
    protected String APP_ID;
    @Value("${payment.weixin.mchId}")
    protected String MCH_ID;
    @Value("${payment.weixin.signKey}")
    protected String SIGN_KEY;
    @Value("${payment.weixin.notifyUrl}")
    protected String NOTIFY_URL;


    public WeixinCommonService() {
    }
}

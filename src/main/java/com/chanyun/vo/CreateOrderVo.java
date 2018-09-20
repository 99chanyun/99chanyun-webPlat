package com.chanyun.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一下单输入参数
 *
 * @author 黎浩
 */
public class CreateOrderVo {

    //订单编号
    @ApiModelProperty(name = "orderNo", value = "订单编号", required = true)
    private String orderNo;

    // 支付渠道
    @ApiModelProperty(name = "channelType", value = "支付渠道", required = true)
    private String channelType;

    // 支付方式
    @ApiModelProperty(name = "paymentType", value = "支付方式", required = true)
    private String paymentType;

//    // 标价币种
//    @ApiModelProperty(name = "currency",value = "标价币种",required = true)
//    private String currency;

    // 订单金额
    @ApiModelProperty(name = "payAmount", value = "订单金额", required = true)
    private String payAmount;

    // 订单描述
    @ApiModelProperty(name = "orderDesc", value = "订单描述", required = true)
    private String orderDesc;

    // 备注
    @ApiModelProperty(name = "memo", value = "备注")
    private String memo;

    // 订单超时时间
    @ApiModelProperty(name = "orderExpireTime", value = "订单超时时间")
    private String orderExpireTime;

    // 终端IP
    @ApiModelProperty(name = "weixinSpbillCreateIp", value = "终端IP")
    private String weixinSpbillCreateIp;

    // 商品id
    @ApiModelProperty(name = "weixinProductId", value = "商品id")
    private String weixinProductId;

    // 场景信息
    @ApiModelProperty(name = "weixinSceneInfo", value = "场景信息")
    private String weixinSceneInfo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOrderExpireTime() {
        return orderExpireTime;
    }

    public void setOrderExpireTime(String orderExpireTime) {
        this.orderExpireTime = orderExpireTime;
    }

    public String getWeixinSpbillCreateIp() {
        return weixinSpbillCreateIp;
    }

    public void setWeixinSpbillCreateIp(String weixinSpbillCreateIp) {
        this.weixinSpbillCreateIp = weixinSpbillCreateIp;
    }

    public String getWeixinProductId() {
        return weixinProductId;
    }

    public void setWeixinProductId(String weixinProductId) {
        this.weixinProductId = weixinProductId;
    }

    public String getWeixinSceneInfo() {
        return weixinSceneInfo;
    }

    public void setWeixinSceneInfo(String weixinSceneInfo) {
        this.weixinSceneInfo = weixinSceneInfo;
    }

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

}

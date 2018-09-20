package com.chanyun.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentOrder {
    private Integer id;

    private String payOrderNo;

    private String channelOrderNo;

    private String channelOrderTime;

    private String channelType;

    private String paymentType;

    private String currency;

    private BigDecimal payAmount;

    private Integer payOrderStatus;

    private String memo;

    private Date createTime;

    private Integer logicDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo == null ? null : payOrderNo.trim();
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo == null ? null : channelOrderNo.trim();
    }

    public String getChannelOrderTime() {
        return channelOrderTime;
    }

    public void setChannelOrderTime(String channelOrderTime) {
        this.channelOrderTime = channelOrderTime == null ? null : channelOrderTime.trim();
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayOrderStatus() {
        return payOrderStatus;
    }

    public void setPayOrderStatus(Integer payOrderStatus) {
        this.payOrderStatus = payOrderStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLogicDelete() {
        return logicDelete;
    }

    public void setLogicDelete(Integer logicDelete) {
        this.logicDelete = logicDelete;
    }
}
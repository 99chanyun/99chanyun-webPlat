package com.chanyun.entity;

import java.util.Date;

public class MeritsProduct {
    private Integer id;

    private Integer templeId;

    private String templeName;

    private Integer meritsType;

    private String meritsName;

    private Long salePrice;

    private Long settlementPrice;

    private Date createTime;

    private Integer meritsStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName == null ? null : templeName.trim();
    }

    public Integer getMeritsType() {
        return meritsType;
    }

    public void setMeritsType(Integer meritsType) {
        this.meritsType = meritsType;
    }

    public String getMeritsName() {
        return meritsName;
    }

    public void setMeritsName(String meritsName) {
        this.meritsName = meritsName == null ? null : meritsName.trim();
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Long getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(Long settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMeritsStatus() {
        return meritsStatus;
    }

    public void setMeritsStatus(Integer meritsStatus) {
        this.meritsStatus = meritsStatus;
    }
}
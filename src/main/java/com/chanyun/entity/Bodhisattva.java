package com.chanyun.entity;

import java.util.Date;

public class Bodhisattva {
    private Integer id;

    private Integer templeId;

    private String templeName;

    private String bodhisattvaName;

    private Date createTime;

    private Integer bodhisattvaStatus;

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

    public String getBodhisattvaName() {
        return bodhisattvaName;
    }

    public void setBodhisattvaName(String bodhisattvaName) {
        this.bodhisattvaName = bodhisattvaName == null ? null : bodhisattvaName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBodhisattvaStatus() {
        return bodhisattvaStatus;
    }

    public void setBodhisattvaStatus(Integer bodhisattvaStatus) {
        this.bodhisattvaStatus = bodhisattvaStatus;
    }
}
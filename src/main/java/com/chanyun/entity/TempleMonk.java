package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("寺庙僧人信息")
public class TempleMonk {
	@ApiModelProperty(value="id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="寺庙id",example="1",hidden=true)
    private Integer templeId;
	@ApiModelProperty(value="僧人名字",example="不净")
    private String templeMonkName;
	@ApiModelProperty(value="僧人描述",example="六根清净")
    private String templeMonkDesciption;
	@ApiModelProperty(value="排序",example="1")
    private Integer sort;
	@ApiModelProperty(value="僧人封面图片",example="https://imgurl")
    private String templeMonkCoverImg;
	@ApiModelProperty(value="状态 1显示 2不显示  99删除",example="1")
    private Integer status;
	@ApiModelProperty(value="创建时间",example="2018-09-20 16:35:22")
    private Date createTime;
	@ApiModelProperty(value="僧人简介",example="1")
    private String templeMonkIntroduce;

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

    public String getTempleMonkName() {
        return templeMonkName;
    }

    public void setTempleMonkName(String templeMonkName) {
        this.templeMonkName = templeMonkName == null ? null : templeMonkName.trim();
    }

    public String getTempleMonkDesciption() {
        return templeMonkDesciption;
    }

    public void setTempleMonkDesciption(String templeMonkDesciption) {
        this.templeMonkDesciption = templeMonkDesciption == null ? null : templeMonkDesciption.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTempleMonkCoverImg() {
        return templeMonkCoverImg;
    }

    public void setTempleMonkCoverImg(String templeMonkCoverImg) {
        this.templeMonkCoverImg = templeMonkCoverImg == null ? null : templeMonkCoverImg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTempleMonkIntroduce() {
        return templeMonkIntroduce;
    }

    public void setTempleMonkIntroduce(String templeMonkIntroduce) {
        this.templeMonkIntroduce = templeMonkIntroduce == null ? null : templeMonkIntroduce.trim();
    }
}
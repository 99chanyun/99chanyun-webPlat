package com.chanyun.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("寺庙简介信息")
public class TempleIntroduce {
	@ApiModelProperty(value="id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="寺庙id",example="1")
    private Integer templeId;
	@ApiModelProperty(value="寺庙名称",example="无名寺")
    private String templeName;
	@ApiModelProperty(value="寺庙描述",example="寺庙测试描述")
    private String templeDescription;
	@ApiModelProperty(value="寺庙封面图url",example="https://imgurl")
    private String templeCoverImg;
	@ApiModelProperty(value="创建时间",example="2018-09-19 19:52")
    private Date createTime;
	@ApiModelProperty(value="寺庙简介内容",example="图文内容")
    private String templeIntroduce;

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

    public String getTempleDescription() {
        return templeDescription;
    }

    public void setTempleDescription(String templeDescription) {
        this.templeDescription = templeDescription == null ? null : templeDescription.trim();
    }

    public String getTempleCoverImg() {
        return templeCoverImg;
    }

    public void setTempleCoverImg(String templeCoverImg) {
        this.templeCoverImg = templeCoverImg == null ? null : templeCoverImg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTempleIntroduce() {
        return templeIntroduce;
    }

    public void setTempleIntroduce(String templeIntroduce) {
        this.templeIntroduce = templeIntroduce == null ? null : templeIntroduce.trim();
    }
}
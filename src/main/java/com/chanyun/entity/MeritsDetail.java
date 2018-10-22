package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("功德详情")
public class MeritsDetail {
	@ApiModelProperty(value="主键id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value = "许愿内容")
    private String promiseContent;
	@ApiModelProperty(value = "功德事件id")
    private Integer meritsId;
	@ApiModelProperty(value = "功德回执图片1")
    private String meritsImg1;
	@ApiModelProperty(value = "功德回执图片2")
    private String meritsImg2;
	@ApiModelProperty(value = "创建时间")
    private Date createTime;
	@ApiModelProperty(value = "功德事件")
    private Merits merits;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromiseContent() {
        return promiseContent;
    }

    public void setPromiseContent(String promiseContent) {
        this.promiseContent = promiseContent == null ? null : promiseContent.trim();
    }

    public Integer getMeritsId() {
        return meritsId;
    }

    public void setMeritsId(Integer meritsId) {
        this.meritsId = meritsId;
    }

    public String getMeritsImg1() {
        return meritsImg1;
    }

    public void setMeritsImg1(String meritsImg1) {
        this.meritsImg1 = meritsImg1 == null ? null : meritsImg1.trim();
    }

    public String getMeritsImg2() {
        return meritsImg2;
    }

    public void setMeritsImg2(String meritsImg2) {
        this.meritsImg2 = meritsImg2 == null ? null : meritsImg2.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Merits getMerits() {
		return merits;
	}

	public void setMerits(Merits merits) {
		this.merits = merits;
	}
    
    
}
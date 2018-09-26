package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("首页banner信息")
public class IndexBanner {
	@ApiModelProperty(value="bannerid",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="banner封面图片路径，图片先调用上传图片接口获取路径")
    private String imgUrl;
	@ApiModelProperty(value="banner封面图描述")
    private String imgDescription;
	@ApiModelProperty(value="banner链接url")
    private String imgLink;
	@ApiModelProperty(value="banner排序")
    private Integer sort;
	@ApiModelProperty(value="banner状态  1启用 2 禁用 99 删除")
    private Integer status;
	@ApiModelProperty(value="banner 创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgDescription() {
        return imgDescription;
    }

    public void setImgDescription(String imgDescription) {
        this.imgDescription = imgDescription == null ? null : imgDescription.trim();
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink == null ? null : imgLink.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
}
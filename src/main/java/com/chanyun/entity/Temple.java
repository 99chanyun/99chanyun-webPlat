package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("寺庙信息")
public class Temple {
	@ApiModelProperty(value="id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="寺庙编号",example="T20180918000001")
    private String templeNumber;
	@ApiModelProperty(value="寺庙名称",example="小普陀寺")
    private String templeName;
	@ApiModelProperty(value="寺庙logo",example="url")
    private String templeLogo;
	@ApiModelProperty(value="寺庙所在省",example="上海")
    private String templeProvince;
	@ApiModelProperty(value="寺庙所在市",example="上海")
    private String templeCity;
	@ApiModelProperty(value="寺庙所在区/县",example="浦东新区")
    private String templeCounty;
	@ApiModelProperty(value="寺庙详细地址",example="XXX路118号")
    private String templeAddress;
	@ApiModelProperty(value="寺庙状态 0 申请 1启用 2禁用 3申请未通过 4异常",example="0")
    private Integer status;
	@ApiModelProperty(value="寺庙联系人姓名",example="不净")
    private String templeContactName;
	@ApiModelProperty(value="寺庙联系人电话",example="13111111111")
    private String templeContactTel;
	@ApiModelProperty(value="寺庙入驻时间",example="2018-09-18")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempleNumber() {
        return templeNumber;
    }

    public void setTempleNumber(String templeNumber) {
        this.templeNumber = templeNumber == null ? null : templeNumber.trim();
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName == null ? null : templeName.trim();
    }

    public String getTempleLogo() {
        return templeLogo;
    }

    public void setTempleLogo(String templeLogo) {
        this.templeLogo = templeLogo == null ? null : templeLogo.trim();
    }

    public String getTempleProvince() {
        return templeProvince;
    }

    public void setTempleProvince(String templeProvince) {
        this.templeProvince = templeProvince == null ? null : templeProvince.trim();
    }

    public String getTempleCity() {
        return templeCity;
    }

    public void setTempleCity(String templeCity) {
        this.templeCity = templeCity == null ? null : templeCity.trim();
    }

    public String getTempleCounty() {
        return templeCounty;
    }

    public void setTempleCounty(String templeCounty) {
        this.templeCounty = templeCounty == null ? null : templeCounty.trim();
    }

    public String getTempleAddress() {
        return templeAddress;
    }

    public void setTempleAddress(String templeAddress) {
        this.templeAddress = templeAddress == null ? null : templeAddress.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTempleContactName() {
        return templeContactName;
    }

    public void setTempleContactName(String templeContactName) {
        this.templeContactName = templeContactName == null ? null : templeContactName.trim();
    }

    public String getTempleContactTel() {
        return templeContactTel;
    }

    public void setTempleContactTel(String templeContactTel) {
        this.templeContactTel = templeContactTel == null ? null : templeContactTel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("用户功德(订单)信息")
public class Merits {
	@ApiModelProperty(value="功德id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="功德编号",example="GD201809161312000001")
    private String meritsNumber;
	@ApiModelProperty(value="用户Id",example="10000000001")
    private Integer userId;
	@ApiModelProperty(value="功德人姓名",example="张三")
    private String customerName;
	@ApiModelProperty("功德人年龄")
	private Integer customerAge;
	@ApiModelProperty(value="功德人年龄-年",example="1980")
    private Integer customerYear;
	@ApiModelProperty(value="功德人年龄-月",example="02")
    private Integer customerMonth;
	@ApiModelProperty(value="功德人年龄-日",example="28")
    private Integer customerDay;
	@ApiModelProperty(value="功德人年龄-时",example="14")
    private String customerHour;
	@ApiModelProperty(value="功德人地址-省",example="上海")
    private String customerAddressProvince;
	@ApiModelProperty(value="功德人地址-市",example="上海")
    private String customerAddressCity;
	@ApiModelProperty(value="功德人地址-区/县",example="浦东新区")
    private String customerAddressArea;
	@ApiModelProperty(value="功德人地址-街道地址",example="惠南镇城西路118号")
    private String customerAddress;
	@ApiModelProperty(value="功德产品id",example ="1")
	private Integer meritsProductId;
	@ApiModelProperty(value="功德类型  1请香  2 供佛灯  3 许愿    4忏悔  ",example="1")
    private Integer meritsType;
	@ApiModelProperty(value="功德名称",example="请财富香")
    private String meritsName;
	@ApiModelProperty(value="功德数量",example="18")
    private BigDecimal meritsAccount;
	@ApiModelProperty(value="寺庙id",example="1")
    private Integer templeId;
	@ApiModelProperty(value="寺庙名称",example="浦东小普陀寺")
	private String templeName;
	@ApiModelProperty(value="菩萨名称",example="观音大士")
    private String godName;
	@ApiModelProperty(value="寺庙殿名",example="圆通宝殿")
    private String templeHouseName;
	@ApiModelProperty(value="功德事件状态 0 申请 1未支付 2支付成功  3完成 4未完成 5退款 9异常",example="0")
    private Integer meritsStatus;
	@ApiModelProperty(value="申请时间",example="2018-09-16 14:00")
    private Date applyTime;
	@ApiModelProperty(value="完成时间",example="2018-09-17 14:00")
    private Date completionTime;
	@ApiModelProperty(value="支付方式",example="weixin")
    private String payType;
	@ApiModelProperty(value="支付流水号",example="",hidden=true)
    private String payNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeritsNumber() {
        return meritsNumber;
    }

    public void setMeritsNumber(String meritsNumber) {
        this.meritsNumber = meritsNumber == null ? null : meritsNumber.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getCustomerYear() {
        return customerYear;
    }

    public void setCustomerYear(Integer customerYear) {
        this.customerYear = customerYear;
    }

    public Integer getCustomerMonth() {
        return customerMonth;
    }

    public void setCustomerMonth(Integer customerMonth) {
        this.customerMonth = customerMonth;
    }

    public Integer getCustomerDay() {
        return customerDay;
    }

    public void setCustomerDay(Integer customerDay) {
        this.customerDay = customerDay;
    }

    public String getCustomerHour() {
        return customerHour;
    }

    public void setCustomerHour(String customerHour) {
        this.customerHour = customerHour == null ? null : customerHour.trim();
    }

    public String getCustomerAddressProvince() {
        return customerAddressProvince;
    }

    public void setCustomerAddressProvince(String customerAddressProvince) {
        this.customerAddressProvince = customerAddressProvince == null ? null : customerAddressProvince.trim();
    }

    public String getCustomerAddressCity() {
        return customerAddressCity;
    }

    public void setCustomerAddressCity(String customerAddressCity) {
        this.customerAddressCity = customerAddressCity == null ? null : customerAddressCity.trim();
    }

    public String getCustomerAddressArea() {
        return customerAddressArea;
    }

    public void setCustomerAddressArea(String customerAddressArea) {
        this.customerAddressArea = customerAddressArea == null ? null : customerAddressArea.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
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


    public BigDecimal getMeritsAccount() {
		return meritsAccount;
	}

	public void setMeritsAccount(BigDecimal meritsAccount) {
		this.meritsAccount = meritsAccount;
	}

	public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName == null ? null : godName.trim();
    }

    public String getTempleHouseName() {
        return templeHouseName;
    }

    public void setTempleHouseName(String templeHouseName) {
        this.templeHouseName = templeHouseName == null ? null : templeHouseName.trim();
    }

    public Integer getMeritsStatus() {
        return meritsStatus;
    }

    public void setMeritsStatus(Integer meritsStatus) {
        this.meritsStatus = meritsStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

	public String getPayType() {
		return payType;
	}

	public String getPayNumber() {
		return payNumber;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

	public String getTempleName() {
		return templeName;
	}

	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}

	public Integer getMeritsProductId() {
		return meritsProductId;
	}

	public void setMeritsProductId(Integer meritsProductId) {
		this.meritsProductId = meritsProductId;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	
}
package com.chanyun.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.chanyun.entity.User;

@ApiModel("订单查询类")
public class MeritsBean {
	@ApiModelProperty(value="功德id",readOnly=true,hidden=true)
    private Integer id;
	@ApiModelProperty(value="功德编号",example="GD201809161312000001")
    private String meritsNumber;
	@ApiModelProperty(value="下单用户",example="10000000001")
    private User user;
	@ApiModelProperty(value="功德人姓名",example="张三")
    private String customerName;
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
	@ApiModelProperty(value="功德类型",example="1")
    private Integer meritsType;
	@ApiModelProperty(value="功德名称",example="请财富香")
    private String meritsName;
	@ApiModelProperty(value="功德数量",example="18")
    private Integer meritsAccount;
	@ApiModelProperty(value="寺庙id",example="1")
    private Integer templeId;
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
}

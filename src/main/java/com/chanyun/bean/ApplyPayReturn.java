package com.chanyun.bean;

import com.chanyun.entity.Merits;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("支付返回结果类")
public class ApplyPayReturn {
	@ApiModelProperty("支付生成二维码url")
	private String payUrl;
	@ApiModelProperty("支付订单信息")
	private Merits merits;
	
	public Merits getMerits() {
		return merits;
	}
	
	public void setMerits(Merits merits) {
		this.merits = merits;
	}

	public String getPayUrl() {
		return payUrl;
	}

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	
	
}

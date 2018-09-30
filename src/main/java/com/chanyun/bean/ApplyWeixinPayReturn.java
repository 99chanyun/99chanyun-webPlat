package com.chanyun.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信支付申请返回类")
public class ApplyWeixinPayReturn {
	@ApiModelProperty("微信返回的随机字符串")
	private String nonce_str;
	@ApiModelProperty("trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付")
	private String code_url;
	@ApiModelProperty("调用接口提交的公众账号ID")
	private String appid;
	@ApiModelProperty("微信返回的签名值")
	private String sign;
	@ApiModelProperty("JSAPI 公众号支付 NATIVE 扫码支付APP APP支付")
	private String trade_type;
	@ApiModelProperty("")
	private String return_msg;
	@ApiModelProperty("业务结果 SUCCESS/FAIL")
	private String result_code;
	@ApiModelProperty("调用接口提交的商户号")
	private String mch_id;
	@ApiModelProperty("")
	private String return_code;
	@ApiModelProperty("微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时")
	private String prepay_id;
	
	public String getNonce_str() {
		return nonce_str;
	}
	public String getCode_url() {
		return code_url;
	}
	public String getAppid() {
		return appid;
	}
	public String getSign() {
		return sign;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public String getResult_code() {
		return result_code;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getReturn_code() {
		return return_code;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	
	
}

package com.chanyun.bean;

/**  

 * <p>Title: HttpResult.java</p>  

 * <p>Description: </p>  

 * <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

 * <p>Company: www.xinpiaoyuan.com</p>  

 * @author liuyang  

 * @date 2018年11月5日  

 * @version 1.0  

 */
public class HttpResult {
	private int code;
	
	private String body;

	
	public HttpResult(int code, String body) {
		super();
		this.code = code;
		this.body = body;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
}

package com.chanyun.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* <p>Title: QueryParams.java</p>  

* <p>Description: 查询基础类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月11日 

* @version 1.0
 */
@ApiModel("查询基础类")
public class QueryParams<T> {
	@ApiModelProperty(value="当面页",example="1")
	private int pageNum;
	@ApiModelProperty(value="页面展示数据条数",example="8")
	private int pageSize;
	@ApiModelProperty(value="查询条件对象")
	private T bean;
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public T getBean() {
		return bean;
	}
	public void setBean(T bean) {
		this.bean = bean;
	}
	
	@Override
	public String toString(){
		final StringBuffer sb = new StringBuffer("QueryParams{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", bean=").append(bean);
        sb.append('}');
        return sb.toString();
	}
}

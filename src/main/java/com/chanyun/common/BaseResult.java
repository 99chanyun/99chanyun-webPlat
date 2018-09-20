package com.chanyun.common;

/**
 * @author liuyang
 * @Description: 返回通用实体类
 * @data 2017-6-17 上午10:31:11
 */
public class BaseResult<T> {
    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

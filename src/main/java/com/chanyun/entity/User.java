package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

@ApiModel("用户数据类")
public class User {
	@ApiModelProperty(value="用户id",readOnly=true,required=true)
    private Integer id;
	@ApiModelProperty(value="用户姓名")
    private String userName;
	@ApiModelProperty(value="用户账号")
    private String userAccount;
	@ApiModelProperty(value="用户密码")
    private String userPassword;
	@ApiModelProperty(value="用户手机号")
    private String userPhone;
	@ApiModelProperty(value="用户微信id",hidden=true)
    private String webchatId;
	@ApiModelProperty(value="用户功德数")
    private Integer meritsAccount;
	@ApiModelProperty(value="用户自身功德数",hidden=true)
    private Integer meritsSelfAccount;
	@ApiModelProperty(value="用户注册时间")
    private Date registTime;
	@ApiModelProperty(value="用户最后一次登陆时间")
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getWebchatId() {
        return webchatId;
    }

    public void setWebchatId(String webchatId) {
        this.webchatId = webchatId == null ? null : webchatId.trim();
    }

    public Integer getMeritsAccount() {
        return meritsAccount;
    }

    public void setMeritsAccount(Integer meritsAccount) {
        this.meritsAccount = meritsAccount;
    }

    public Integer getMeritsSelfAccount() {
        return meritsSelfAccount;
    }

    public void setMeritsSelfAccount(Integer meritsSelfAccount) {
        this.meritsSelfAccount = meritsSelfAccount;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
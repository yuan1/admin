package com.funny.admin.domain.sys;

import com.funny.admin.domain.BaseEntity;

public class BasicUser extends BaseEntity {
    private static final long serialVersionUID = 1467208033489L;

    /**
    * 用户名
    */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;

    /**
    * 密码
    */
    private String userPwd;

    /**
    * 电话
    */
    private String mobile;

    /**
    * email
    */
    private String email;

    /**
    *  1 正常 2 禁用
    */
    private Integer userStatus;

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
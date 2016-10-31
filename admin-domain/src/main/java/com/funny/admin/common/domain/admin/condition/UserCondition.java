package com.funny.admin.common.domain.admin.condition;

import com.funny.admin.common.domain.PageCondition;

/**
 * Created by fangli@autohome.com.cn on 2016/8/6.
 */
public class UserCondition extends PageCondition {
    private String userName;
    private String realName;
    private String mobile;
    private String email;
    private Integer userStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}

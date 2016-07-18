package com.funny.admin.domain.sys;

import com.funny.admin.domain.BaseEntity;

public class BasicUserRole extends BaseEntity{
    private static final long serialVersionUID = 1467208035337L;

    /**
    * 
    */
    private Long userId;

    /**
    * 
    */
    private Long roleId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }
}
package com.funny.admin.domain.sys.entity;

import com.funny.admin.domain.BaseEntity;

public class RoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1467208031621L;

    /**
    * 
    */
    private String roleName;

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleName() {
        return roleName;
    }
}
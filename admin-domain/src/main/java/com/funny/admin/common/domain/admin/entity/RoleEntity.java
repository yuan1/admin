package com.funny.admin.common.domain.admin.entity;

import com.funny.admin.common.domain.BaseEntity;

public class RoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1467208031621L;

    /**
    * 
    */
    private String roleName;

    private boolean checked = false;

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
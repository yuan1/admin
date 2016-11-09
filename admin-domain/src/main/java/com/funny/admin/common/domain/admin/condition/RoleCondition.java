package com.funny.admin.common.domain.admin.condition;

import com.funny.admin.common.domain.PageCondition;

/**
 * Created by fangli@autohome.com.cn on 2016/8/6.
 */
public class RoleCondition extends PageCondition {
    private String roleName;

    private Long roleId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

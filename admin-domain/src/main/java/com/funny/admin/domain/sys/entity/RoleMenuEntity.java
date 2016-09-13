package com.funny.admin.domain.sys.entity;

import com.funny.admin.domain.BaseEntity;

import java.util.Date;

public class RoleMenuEntity extends BaseEntity {
    private static final long serialVersionUID = 1470922127154L;

    /**
    * 
    */
    private Long roleId;

    /**
    * 
    */
    private Long menuId;


    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return menuId;
    }

}
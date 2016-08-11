package com.funny.admin.domain.sys;

import com.funny.admin.domain.BaseEntity;

public class BasicDepartment extends BaseEntity {
    private static final long serialVersionUID = 1470922118120L;

    /**
    * 
    */
    private Long departId;

    /**
    * 
    */
    private String departName;

    /**
    * 
    */
    private Long parentId;


    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    public Long getDepartId() {
        return departId;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

}
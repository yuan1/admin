package com.funny.admin.domain.sys;

import java.util.Date;

import com.funny.admin.domain.BaseEntity;

public class BasicParameter extends BaseEntity{
    private static final long serialVersionUID = 1467208028712L;

    /**
    * 
    */
    private String paramName;

    /**
    * 
    */
    private String paramValue;

    /**
    * 1系统参数2业务参数
    */
    private Integer paramType;

    /**
    * 
    */
    private String note;

    /**
    * 
    */
    private Long createBy;

    /**
    * 
    */
    private Date createTime;

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getNote() {
        return note;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
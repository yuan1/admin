package com.funny.admin.common.domain.sys.entity;

import com.funny.admin.common.domain.BaseEntity;

public class ParameterEntity extends BaseEntity {
    private String paramName;
    private String paramValue;
    private Integer paramType;
    private String note;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
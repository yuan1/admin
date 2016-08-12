package com.funny.admin.domain.sys;

import com.funny.admin.domain.BaseEntity;

import java.util.Date;

public class BasicDict extends BaseEntity {
    private static final long serialVersionUID = 1470922120377L;

    /**
    * 
    */
    private Integer dictId;

    /**
    * 
    */
    private String dictName;


    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictName() {
        return dictName;
    }

}
package com.funny.admin.domain.sys;


import com.funny.admin.domain.BaseEntity;

import java.util.Date;

public class BasicDictionary extends BaseEntity {
    private static final long serialVersionUID = 1470922122780L;

    /**
    * 名称
    */
    private Long dictId;

    /**
    * 英文
    */
    private String dicName;

    /**
    * 编码
    */
    private String dicValue;

    /**
    * 排序
    */
    private Integer dicId;


    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public Integer getDicId() {
        return dicId;
    }

}
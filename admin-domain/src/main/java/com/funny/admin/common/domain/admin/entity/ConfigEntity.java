package com.funny.admin.common.domain.admin.entity;


import com.funny.admin.common.domain.BaseEntity;

public class ConfigEntity extends BaseEntity {
    /**
    * 配置编码
    */
    private String configCode;
    /**
     * 编码描述
     */
    private String configDesc;

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }
}
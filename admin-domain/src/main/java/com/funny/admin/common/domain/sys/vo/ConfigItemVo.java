package com.funny.admin.common.domain.sys.vo;

import java.io.Serializable;

/**
 * Created by funny on 16/9/8.
 */
public class ConfigItemVo implements Serializable {

    private Long id;
    /**
     * 配置id
     */
    private Long configId;
    /**
     * 配置编码
     */
    private String configCode;
    /**
     * 配置编码描述
     */
    private String configDesc;

    /**
     * 配置项描述
     */
    private String itemName;

    /**
     * 配置项value
     */
    private String itemValue;

    /**
     * 配置项id
     */
    private String itemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}

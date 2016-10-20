package com.funny.admin.common.domain.sys.condition;

import com.funny.admin.common.domain.PageCondition;

/**
 * Created by funny on 16/9/8.
 */
public class ConfigItemCondition extends PageCondition {
    /**
     * 配置编码
     */
    private String configCode;
    /**
     * 配置id
     */
    private Long configId;
    /**
     * 配置项value
     */
    private String itemValue;

    private Long nid;

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }
}

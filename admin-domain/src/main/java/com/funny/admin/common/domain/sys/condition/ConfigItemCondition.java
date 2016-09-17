package com.funny.admin.common.domain.sys.condition;

/**
 * Created by funny on 16/9/8.
 */
public class ConfigItemCondition{
    /**
     * 配置编码
     */
    private String configCode;
    /**
     * 配置id
     */
    private Long configId;
    /**
     * 配置项id
     */
    private Integer itemId;

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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}

package com.funny.admin.common.domain.admin.entity;


import com.funny.admin.common.domain.BaseEntity;

public class ConfigItemEntity extends BaseEntity {
    /**
    * 编码
    */
    private Long configId;

    /**
    * 描述
    */
    private String itemName;

    /**
    * 值
    */
    private String itemValue;

    /**
    * id
    */
    private Integer itemId;
    /**
     * 排序
     */
    private Integer orderNum;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
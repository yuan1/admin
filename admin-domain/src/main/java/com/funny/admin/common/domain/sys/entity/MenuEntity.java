package com.funny.admin.common.domain.sys.entity;


import com.funny.admin.common.domain.BaseEntity;

public class MenuEntity extends BaseEntity {
    private static final long serialVersionUID = 1468326216090L;

    /**
    * 
    */
    private String menuName;

    /**
    * 
    */
    private String menuUrl;

    /**
    * 
    */
    private Long parentId;

    /**
    * 
    */
    private String menuOrder;

    /**
    * 
    */
    private String menuIcon;

    /**
    * 
    */
    private Integer menuType;

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId ;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder == null ? null : menuOrder.trim();
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getMenuType() {
        return menuType;
    }
}
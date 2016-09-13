package com.funny.admin.domain.sys.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/8/2.
 */
public class MenuVo implements Serializable {
    private Long id;
    private MenuVo parentMenu;
    private List<MenuVo> childList;
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

    public MenuVo getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(MenuVo parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MenuVo> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuVo> childList) {
        this.childList = childList;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }
}

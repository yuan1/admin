package com.funny.admin.domain.sys.vo;

import com.funny.admin.domain.sys.entity.MenuEntity;

/**
 * Created by fangli@autohome.com.cn on 2016/8/2.
 */
public class MenuVo extends MenuEntity {
    private MenuEntity parentMenu;

    public MenuEntity getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(MenuEntity parentMenu) {
        this.parentMenu = parentMenu;
    }
}

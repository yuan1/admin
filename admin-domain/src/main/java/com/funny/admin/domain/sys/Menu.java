package com.funny.admin.domain.sys;

import java.util.List;

public class Menu extends BasicMenu {
    private static final long serialVersionUID = 1468326216093L;

    List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
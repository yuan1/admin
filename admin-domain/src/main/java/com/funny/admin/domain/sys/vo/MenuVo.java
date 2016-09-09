package com.funny.admin.domain.sys.vo;

import com.funny.admin.domain.sys.BasicMenu;
import com.funny.admin.domain.sys.Menu;

/**
 * Created by fangli@autohome.com.cn on 2016/8/2.
 */
public class MenuVo extends BasicMenu {
    private Menu parentMenu;

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }
}

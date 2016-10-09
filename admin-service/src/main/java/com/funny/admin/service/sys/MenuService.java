package com.funny.admin.service.sys;


import com.funny.admin.common.domain.sys.condition.MenuCondition;
import com.funny.admin.common.domain.sys.entity.MenuEntity;
import com.funny.admin.common.domain.sys.vo.MenuVo;

import java.util.List;

public interface MenuService {
    /**
     * @param condition
     * @return
     * @throws Exception
     */
    List<MenuEntity> selectMenuListByCondition(MenuCondition condition);
    /**
     * @param id
     * @return
     */
    MenuEntity getMenuById(Long id);
    /**
     * @param menu
     */
    int addMenu(MenuEntity menu);

    /**
     * @param menu
     * @throws Exception
     */
    int updateMenu(MenuEntity menu);
    /**
     * @param id
     */
    int deleteMenuById(Long id);


    List<MenuVo> getMenuTree();
}

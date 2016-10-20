package com.funny.admin.service.sys;


import com.funny.admin.common.domain.sys.condition.MenuCondition;
import com.funny.admin.common.domain.sys.entity.MenuEntity;
import com.funny.admin.common.domain.sys.vo.MenuVo;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface MenuService extends BaseService<MenuEntity,MenuCondition>{
    /**
     * @param condition
     * @return
     * @throws Exception
     */
    List<MenuEntity> selectMenuListByCondition(MenuCondition condition);

    List<MenuVo> getMenuTree();
}

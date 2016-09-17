package com.funny.admin.common.dao.sys;

import java.util.List;

import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.sys.condition.MenuCondition;
import com.funny.admin.common.domain.sys.entity.MenuEntity;

public interface MenuMapper extends BaseMapper<MenuEntity> {
    List<MenuEntity> selectMenuListByCondition(MenuCondition condition);
}
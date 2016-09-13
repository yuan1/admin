package com.funny.admin.dao.sys;

import java.util.List;

import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.condition.MenuCondition;
import com.funny.admin.domain.sys.entity.MenuEntity;

public interface MenuMapper extends BaseMapper<MenuEntity> {
    List<MenuEntity> selectMenuListByCondition(MenuCondition condition);
}
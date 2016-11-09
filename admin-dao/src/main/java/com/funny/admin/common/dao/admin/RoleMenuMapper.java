package com.funny.admin.common.dao.admin;

import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.admin.entity.RoleMenuEntity;

public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {
    /**
     * 根据角色删除
     * @param entity
     * @return
     */
    int deleteByRoleId(RoleMenuEntity entity);
}
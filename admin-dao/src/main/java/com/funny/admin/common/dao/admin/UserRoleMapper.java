package com.funny.admin.common.dao.admin;

import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.admin.entity.UserRoleEntity;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {
    /**
     * 查看角色有多少个用户
     * @return
     */
    List<UserRoleEntity> findUserRoleByRoleId(Long roleId);

    /**
     * 查看用户有多少个角色
     * @return
     */
    List<UserRoleEntity> findUserRoleByUserId(Long userId);
}
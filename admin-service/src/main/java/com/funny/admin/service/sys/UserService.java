package com.funny.admin.service.sys;

import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.funny.admin.common.domain.admin.entity.UserRoleEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<UserEntity,UserCondition>{
    UserEntity findByUsername(String name);

    /**
     * 为用户添加角色
     * @param id
     * @param roleIds
     * @return
     */
    int addRoles(Long operId,Long id, String roleIds);

    /**
     * 查看用户有多少个角色
     * @param userId
     * @return
     */
    List<UserRoleEntity> findUserRoleByUserId(Long userId);

}

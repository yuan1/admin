package com.funny.admin.service.sys;

import java.util.Set;

import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.github.pagehelper.PageInfo;

public interface DepartService {
    int addUser(UserEntity user);

    int updateUser(UserEntity user);

    UserEntity getUserById(Long id);

    int deleteUser(Long id);

    PageInfo<UserEntity> getPageUserList(UserCondition condition);

   Set<String> findRoles(String name);
    Set<String> findPermissions(String username);
    UserEntity findByUsername(String name);
}

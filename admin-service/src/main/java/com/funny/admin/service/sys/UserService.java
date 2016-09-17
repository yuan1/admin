package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.condition.UserCondition;
import com.funny.admin.domain.sys.entity.UserEntity;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;

import java.util.Set;

public interface UserService {
    int addUser(UserEntity user);

    int updateUser(UserEntity user);

    UserEntity getUserById(Long id);

    int deleteUser(Long id);

    PageInfo<UserEntity> getPageUserList(UserCondition condition);

   Set<String> findRoles(String name);
    Set<String> findPermissions(String username);
    UserEntity findByUsername(String name);
}

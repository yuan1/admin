package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.condition.UserCondition;
import com.funny.admin.domain.sys.entity.UserEntity;
import com.github.pagehelper.PageInfo;

public interface UserService {
    int addUser(UserEntity user);

    int updateUser(UserEntity user);

    UserEntity getUserById(Long id);

    int deleteUser(Long id);

    PageInfo<UserEntity> getPageUserList(UserCondition condition);
}

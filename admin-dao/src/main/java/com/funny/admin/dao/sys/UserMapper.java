package com.funny.admin.dao.sys;

import java.util.List;

import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.condition.UserCondition;
import com.funny.admin.domain.sys.entity.UserEntity;

public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserEntity> getPageUserList(UserCondition condition);
}

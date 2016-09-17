package com.funny.admin.common.dao.sys;

import java.util.List;

import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.sys.condition.UserCondition;
import com.funny.admin.common.domain.sys.entity.UserEntity;

public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserEntity> getPageUserList(UserCondition condition);
}

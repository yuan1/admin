package com.funny.admin.service.sys;

import com.funny.admin.common.domain.sys.condition.UserCondition;
import com.funny.admin.common.domain.sys.entity.UserEntity;
import com.funny.admin.common.service.BaseService;

public interface UserService extends BaseService<UserEntity,UserCondition>{
    UserEntity findByUsername(String name);
}

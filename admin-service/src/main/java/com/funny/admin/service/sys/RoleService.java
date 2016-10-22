package com.funny.admin.service.sys;

import com.funny.admin.common.domain.admin.condition.RoleCondition;
import com.funny.admin.common.domain.admin.entity.RoleEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<RoleEntity,RoleCondition>{
	
    List<RoleEntity> findRoleList(RoleCondition roleCondition);

}

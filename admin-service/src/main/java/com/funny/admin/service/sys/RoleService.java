package com.funny.admin.service.sys;

import com.funny.admin.common.domain.admin.condition.RoleCondition;
import com.funny.admin.common.domain.admin.entity.RoleEntity;
import com.funny.admin.common.domain.admin.entity.RoleMenuEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<RoleEntity,RoleCondition>{
	
    List<RoleEntity> findRoleList(RoleCondition roleCondition);
    /**
     * 添加菜单权限
     * @param roleId
     * @param menuIds
     * @return
     */
    int addRoleMenu(Long roleId,Long operId,String menuIds);

    /**
     * 查询角色有那些权限
     * @param roleId
     * @return
     */
    List<RoleMenuEntity> findRoleMenuList(Long roleId);
}

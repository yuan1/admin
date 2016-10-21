package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.admin.RoleMapper;
import com.funny.admin.common.domain.admin.condition.RoleCondition;
import com.funny.admin.common.domain.admin.entity.RoleEntity;
import com.funny.admin.service.sys.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int add(RoleEntity roleEntity) {
        return roleMapper.insert(roleEntity);
    }

    @Override
    public int update(RoleEntity roleEntity) {
        return roleMapper.updateByIdSelected(roleEntity);
    }

    @Override
    public RoleEntity findById(Long id) {
        return roleMapper.findById(id);
    }

    @Override
    public PageInfo<RoleEntity> getPageList(RoleCondition roleCondition) {
        PageHelper.startPage(roleCondition.getPageNo(),roleCondition.getPageSize());
        PageHelper.orderBy("id desc");
        List<RoleEntity> roleEntityList = roleMapper.findByCondition(roleCondition);
        return new PageInfo<>(roleEntityList);

    }
}

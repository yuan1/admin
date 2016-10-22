package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.admin.UserMapper;
import com.funny.admin.common.dao.admin.UserRoleMapper;
import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.entity.UserRoleEntity;
import com.funny.admin.service.sys.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserEntity findByUsername(String name) {
        UserCondition userCondition = new UserCondition();
        userCondition.setUserName(name);
        List<UserEntity> userEntityList = userMapper.findByCondition(userCondition);
        if (CollectionUtils.isEmpty(userEntityList)) {
            return null;
        }
        return userEntityList.get(0);
    }

    @Override
    public int addRoles(Long operId,Long id, String roleIds) {
        int num = 0;
        List<UserRoleEntity> userRoleEntityList = userRoleMapper.findUserRoleByUserId(id);
        if (CollectionUtils.isEmpty(userRoleEntityList)) {
            for (String roleId : roleIds.split(",")) {
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                userRoleEntity.setRoleId(Long.valueOf(roleId));
                userRoleEntity.setUserId(id);
                userRoleEntity.setCreateBy(operId);
                num += userRoleMapper.insert(userRoleEntity);
            }
        } else {
            Map<String, UserRoleEntity> userRoleEntityMap = Maps.newHashMapWithExpectedSize(userRoleEntityList.size());
            for (UserRoleEntity userRoleEntity : userRoleEntityList) {
                userRoleEntityMap.put(userRoleEntity.getUserId() + userRoleEntity.getRoleId() + "", userRoleEntity);
            }
            List<Long> addList = Lists.newArrayList();
            Map<Long, String> roleEntityMap = Maps.newHashMap();
            for (String roleId : roleIds.split(",")) {
                roleEntityMap.put(Long.valueOf(roleId), roleId);
                if (userRoleEntityMap.get(id + roleId) == null) {
                    addList.add(Long.valueOf(roleId));
                }
            }
            List<UserRoleEntity> removeList = Lists.newArrayList();
            for (UserRoleEntity userRoleEntity : userRoleEntityList) {
                if (roleEntityMap.get(userRoleEntity.getRoleId()) == null) {
                    removeList.add(userRoleEntity);
                }
            }
            for(Long roleId:addList){
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                userRoleEntity.setRoleId(roleId);
                userRoleEntity.setUserId(id);
                userRoleEntity.setCreateBy(operId);
                num +=userRoleMapper.insert(userRoleEntity);
            }
            for(UserRoleEntity userRoleEntity:removeList){
                userRoleEntity.setYn(0);
                userRoleEntity.setUpdateBy(operId);
                num +=userRoleMapper.updateByIdSelected(userRoleEntity);
            }
        }
        return num;
    }

    @Override
    public List<UserRoleEntity> findUserRoleByUserId(Long userId) {
        return userRoleMapper.findUserRoleByUserId(userId);
    }

    @Override
    public int add(UserEntity userEntity) {
        return userMapper.insert(userEntity);
    }

    @Override
    public int update(UserEntity userEntity) {
        return userMapper.updateByIdSelected(userEntity);
    }

    @Override
    public UserEntity findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public PageInfo<UserEntity> getPageList(UserCondition userCondition) {
        PageHelper.orderBy("id desc");
        PageHelper.startPage(userCondition.getPageNo(), userCondition.getPageSize());
        List<UserEntity> userEntityList = userMapper.findByCondition(userCondition);
        return new PageInfo<UserEntity>(userEntityList);
    }
}

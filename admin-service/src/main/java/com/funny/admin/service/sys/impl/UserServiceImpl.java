package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.admin.UserMapper;
import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.service.sys.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

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
        PageHelper.startPage(userCondition.getPageNo(),userCondition.getPageSize());
        List<UserEntity> userEntityList = userMapper.findByCondition(userCondition);
        return new PageInfo<UserEntity>(userEntityList);
    }
}

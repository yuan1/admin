package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.sys.UserMapper;
import com.funny.admin.common.domain.sys.entity.UserEntity;
import com.funny.admin.common.domain.sys.condition.UserCondition;
import com.funny.admin.service.sys.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserEntity user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(UserEntity user) {
        return userMapper.updateByIdSelected(user);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageInfo<UserEntity> getPageUserList(UserCondition condition) {
        PageHelper.startPage(condition.getPageNo(), condition.getPageSize());
        PageHelper.orderBy("id desc");
        List<UserEntity> users = userMapper.getPageUserList(condition);
        return new PageInfo<UserEntity>(users);
    }

    @Override
    public Set<String> findRoles(String name) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }

    @Override
    public UserEntity findByUsername(String name) {
        return null;
    }
}

package com.funny.admin.service.sys.impl;

import com.funny.admin.dao.sys.UserMapper;
import com.funny.admin.domain.sys.User;
import com.funny.admin.condition.sys.UserCondition;
import com.funny.admin.service.sys.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByIdSelected(user);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public PageInfo<User> getPageUserList(UserCondition condition) {
        PageHelper.startPage(condition.getPageNo(), condition.getPageSize());
        List<User> users = userMapper.getPageUserList(condition);
        return new PageInfo<User>(users);
    }
}

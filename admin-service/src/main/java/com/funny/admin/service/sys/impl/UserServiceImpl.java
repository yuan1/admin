package com.funny.admin.service.sys.impl;

import com.funny.admin.dao.sys.UserMapper;
import com.funny.admin.domain.sys.User;
import com.funny.admin.service.sys.UserService;
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
    public List<User> getUserList() {
        return userMapper.findAll();
    }
}

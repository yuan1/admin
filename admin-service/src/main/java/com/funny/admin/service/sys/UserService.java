package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> getUserList();
}

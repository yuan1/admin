package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.User;
import com.funny.admin.domain.sys.UserCondition;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    PageInfo<User> getPageUserList(UserCondition condition);
}

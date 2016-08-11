package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.User;
import com.funny.admin.condition.sys.UserCondition;
import com.github.pagehelper.PageInfo;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    PageInfo<User> getPageUserList(UserCondition condition);
}

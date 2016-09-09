package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.User;
import com.funny.admin.domain.sys.condition.UserCondition;
import com.github.pagehelper.PageInfo;

public interface UserService {
    int addUser(User user);

    int updateUser(User user);

    User getUserById(Long id);

    int deleteUser(Long id);

    PageInfo<User> getPageUserList(UserCondition condition);
}

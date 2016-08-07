package com.funny.admin.dao.sys;

import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.User;
import com.funny.admin.domain.sys.UserCondition;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> getPageUserList(UserCondition condition);
}

package com.funny.admin.common.domain.sys.vo;

import com.funny.admin.common.domain.sys.entity.UserEntity;
import com.funny.admin.common.domain.sys.enums.UserStatusEnum;

/**
 * Created by funny on 16/9/13.
 */
public class UserVo extends UserEntity {
    private String userStatusText;

    public String getUserStatusText() {
        return UserStatusEnum.getDescByValue(this.getUserStatus());
    }
}

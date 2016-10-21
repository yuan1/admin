package com.funny.admin.common.domain.admin.vo;

import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.funny.admin.common.domain.admin.enums.UserStatusEnum;

/**
 * Created by funny on 16/9/13.
 */
public class UserVo extends UserEntity {
    private String userStatusText;

    public String getUserStatusText() {
        return UserStatusEnum.getDescByValue(this.getUserStatus());
    }
}

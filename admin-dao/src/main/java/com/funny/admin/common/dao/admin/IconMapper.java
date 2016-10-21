package com.funny.admin.common.dao.admin;

import com.funny.admin.common.domain.admin.entity.IconEntity;

import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/10/11.
 */
public interface IconMapper {
    int insertIcon(IconEntity entity);

    List<IconEntity> findIcons(Integer iconType);
}

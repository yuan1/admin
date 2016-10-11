package com.funny.admin.common.dao.sys;

import com.funny.admin.common.domain.sys.entity.IconEntity;

import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/10/11.
 */
public interface IconMapper {
    int insertIcon(IconEntity entity);

    List<IconEntity> findIcons(Integer iconType);
}

package com.funny.admin.service.sys;

import com.funny.admin.common.domain.admin.entity.IconEntity;

import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/10/11.
 */
public interface IconService {

    List<IconEntity> findIcons(Integer iconType);
}

package com.funny.admin.service.sys;

import com.funny.admin.common.domain.sys.entity.IconEntity;

import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/10/11.
 */
public interface IconService {

    List<IconEntity> findIcons(Integer iconType);
}

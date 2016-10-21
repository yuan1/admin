package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.admin.IconMapper;
import com.funny.admin.common.domain.admin.entity.IconEntity;
import com.funny.admin.service.sys.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/10/11.
 */
@Service
public class IconServiceImpl implements IconService{
    @Autowired
    private IconMapper iconMapper;

    public List<IconEntity> findIcons(Integer iconType) {
        return iconMapper.findIcons(iconType);
    }
}

package com.funny.admin.dao.sys;

import java.util.List;

import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.domain.sys.condition.ConfigItemCondition;

public interface ConfigItemMapper extends BaseMapper<ConfigItemEntity> {
    List<ConfigItemEntity> findConfigItemByCondition(ConfigItemCondition configItemCondition);
}
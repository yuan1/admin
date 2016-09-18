package com.funny.admin.common.dao.sys;

import java.util.List;

import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;

public interface ConfigItemMapper extends BaseMapper<ConfigItemEntity> {
    List<ConfigItemEntity> findConfigItemByCondition(ConfigItemCondition configItemCondition);
    int selectMaxItemId(Long configId);
}
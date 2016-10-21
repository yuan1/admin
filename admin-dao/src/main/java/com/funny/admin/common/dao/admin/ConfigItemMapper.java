package com.funny.admin.common.dao.admin;

import java.util.List;

import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.admin.entity.ConfigItemEntity;
import com.funny.admin.common.domain.admin.condition.ConfigItemCondition;

public interface ConfigItemMapper extends BaseMapper<ConfigItemEntity> {
    List<ConfigItemEntity> findConfigItemByCondition(ConfigItemCondition configItemCondition);
    int selectMaxItemId(Long configId);
}
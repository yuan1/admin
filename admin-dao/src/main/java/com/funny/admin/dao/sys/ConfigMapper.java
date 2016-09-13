package com.funny.admin.dao.sys;

import java.util.List;


import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.entity.ConfigEntity;
import com.funny.admin.domain.sys.condition.ConfigItemCondition;

public interface ConfigMapper extends BaseMapper<ConfigEntity> {
    List<ConfigEntity> findConfigByCondition(ConfigItemCondition configItemCondition);
}
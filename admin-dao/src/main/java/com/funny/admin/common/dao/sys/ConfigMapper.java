package com.funny.admin.common.dao.sys;

import java.util.List;


import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.sys.entity.ConfigEntity;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;

public interface ConfigMapper extends BaseMapper<ConfigEntity> {
    List<ConfigEntity> findConfigByCondition(ConfigItemCondition configItemCondition);

    ConfigEntity findConfigByCode(String configCode);
}
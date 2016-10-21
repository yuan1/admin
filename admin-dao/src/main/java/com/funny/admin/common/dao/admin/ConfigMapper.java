package com.funny.admin.common.dao.admin;

import java.util.List;


import com.funny.admin.common.dao.BaseMapper;
import com.funny.admin.common.domain.admin.entity.ConfigEntity;
import com.funny.admin.common.domain.admin.condition.ConfigItemCondition;

public interface ConfigMapper extends BaseMapper<ConfigEntity> {
    List<ConfigEntity> findConfigByCondition(ConfigItemCondition configItemCondition);

    ConfigEntity findConfigByCode(String configCode);
}
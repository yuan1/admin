package com.funny.admin.service.sys;

import com.funny.admin.common.domain.admin.condition.ConfigItemCondition;
import com.funny.admin.common.domain.admin.entity.ConfigEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface ConfigService extends BaseService<ConfigEntity,ConfigItemCondition> {

    ConfigEntity findConfigByCode(String code);

    List<ConfigEntity> findAllConfig();
}

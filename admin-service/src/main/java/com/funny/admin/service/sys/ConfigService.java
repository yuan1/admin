package com.funny.admin.service.sys;

import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;
import com.funny.admin.common.domain.sys.entity.ConfigEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface ConfigService extends BaseService<ConfigEntity,ConfigItemCondition> {

    ConfigEntity findConfigByCode(String code);

    List<ConfigEntity> findAllConfig();
}

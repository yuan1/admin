package com.funny.admin.service.sys;

import java.util.List;

import com.funny.admin.common.domain.sys.entity.ConfigEntity;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;

public interface ConfigService {
    List<ConfigEntity> findConfigList();

    ConfigEntity findConfigById(Long id);

    int addConfig(ConfigEntity configEntity);

    int updateConfig(ConfigEntity configEntity);

    List<ConfigItemEntity> findConfigItemList(ConfigItemCondition condition);

    int addConfigItem(ConfigItemEntity item);

    int updateConfigItem(ConfigItemEntity item);

    ConfigItemEntity findConfigItemById(Long id);

}

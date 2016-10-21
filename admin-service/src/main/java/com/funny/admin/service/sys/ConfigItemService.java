package com.funny.admin.service.sys;

import com.funny.admin.common.domain.admin.condition.ConfigItemCondition;
import com.funny.admin.common.domain.admin.entity.ConfigItemEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface ConfigItemService extends BaseService<ConfigItemEntity,ConfigItemCondition> {
    int selectMaxItemId(Long configId);

    List<ConfigItemEntity> findConfigItemList(ConfigItemCondition condition);
}

package com.funny.admin.service.sys;

import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.common.service.BaseService;

import java.util.List;

public interface ConfigItemService extends BaseService<ConfigItemEntity,ConfigItemCondition> {
    int selectMaxItemId(Long configId);

    List<ConfigItemEntity> findConfigItemList(ConfigItemCondition condition);
}

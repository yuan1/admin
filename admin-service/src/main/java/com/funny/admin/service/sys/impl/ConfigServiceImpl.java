package com.funny.admin.service.sys.impl;

import com.funny.admin.common.domain.sys.entity.ConfigEntity;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funny.admin.common.dao.sys.ConfigItemMapper;
import com.funny.admin.common.dao.sys.ConfigMapper;
import com.funny.admin.service.sys.ConfigService;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private ConfigItemMapper configItemMapper;

    @Override
    public List<ConfigEntity> findConfigList() {
        return configMapper.findConfigByCondition(new ConfigItemCondition());
    }

    @Override
    public ConfigEntity findConfigById(Long id) {
        return configMapper.findById(id);
    }

    @Override
    public int addConfig(ConfigEntity configEntity) {
        return configMapper.insert(configEntity);
    }

    @Override
    public int updateConfig(ConfigEntity configEntity) {
        return configMapper.updateByIdSelected(configEntity);
    }

    @Override
    public List<ConfigItemEntity> findConfigItemList(ConfigItemCondition condition) {
        return configItemMapper.findConfigItemByCondition(condition);
    }

    @Override
    public int addConfigItem(ConfigItemEntity item) {
        return configItemMapper.insert(item);
    }

    @Override
    public int updateConfigItem(ConfigItemEntity item) {
        return configItemMapper.updateByIdSelected(item);
    }

    @Override
    public ConfigItemEntity findConfigItemById(Long id) {
        return configItemMapper.findById(id);
    }
}

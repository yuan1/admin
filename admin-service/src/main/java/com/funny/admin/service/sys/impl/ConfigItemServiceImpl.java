package com.funny.admin.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funny.admin.common.dao.sys.ConfigItemMapper;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.service.sys.ConfigItemService;
import com.github.pagehelper.PageInfo;

@Service
public class ConfigItemServiceImpl implements ConfigItemService {
    @Autowired
    private ConfigItemMapper configItemMapper;

    @Override
    public int selectMaxItemId(Long configId) {
        return configItemMapper.selectMaxItemId(configId);
    }

    @Override
    public List<ConfigItemEntity> findConfigItemList(ConfigItemCondition condition) {
        return configItemMapper.findByCondition(condition);
    }

    @Override
    public int add(ConfigItemEntity configItemEntity) {
        return configItemMapper.insert(configItemEntity);
    }

    @Override
    public int update(ConfigItemEntity configItemEntity) {
        return configItemMapper.updateByIdSelected(configItemEntity);
    }

    @Override
    public ConfigItemEntity findById(Long id) {
        return configItemMapper.findById(id);
    }

    @Override
    public PageInfo<ConfigItemEntity> getPageList(ConfigItemCondition configItemCondition) {
        List<ConfigItemEntity> configItemEntityList =  configItemMapper.findByCondition(configItemCondition);
        return new PageInfo<>(configItemEntityList);
    }
}

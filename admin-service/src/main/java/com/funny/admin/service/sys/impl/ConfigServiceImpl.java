package com.funny.admin.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funny.admin.common.dao.sys.ConfigMapper;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;
import com.funny.admin.common.domain.sys.entity.ConfigEntity;
import com.funny.admin.service.sys.ConfigService;
import com.github.pagehelper.PageInfo;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;

    @Override
    public int add(ConfigEntity configEntity) {
        return configMapper.insert(configEntity);
    }

    @Override
    public int update(ConfigEntity configEntity) {
        return configMapper.updateByIdSelected(configEntity);
    }

    @Override
    public ConfigEntity findById(Long id) {
        return configMapper.findById(id);
    }

    @Override
    public PageInfo<ConfigEntity> getPageList(ConfigItemCondition condition) {
        List<ConfigEntity> configEntityList = configMapper.findConfigByCondition(condition);
        return new PageInfo<ConfigEntity>(configEntityList);
    }

    @Override
    public ConfigEntity findConfigByCode(String code) {
        return configMapper.findConfigByCode(code);
    }

    @Override
    public List<ConfigEntity> findAllConfig() {
        return configMapper.findByCondition(new ConfigItemCondition());
    }
}

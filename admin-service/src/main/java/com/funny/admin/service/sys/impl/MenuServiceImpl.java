package com.funny.admin.service.sys.impl;

import com.funny.admin.dao.sys.MenuMapper;
import com.funny.admin.domain.sys.condition.MenuCondition;
import com.funny.admin.domain.sys.entity.MenuEntity;
import com.funny.admin.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuEntity> selectMenuListByCondition(MenuCondition condition) {
        return menuMapper.selectMenuListByCondition(condition);
    }

    @Override
    public MenuEntity getMenuById(Long id) {
        return menuMapper.findById(id);
    }

    @Override
    public int addMenu(MenuEntity menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int updateMenu(MenuEntity menu) {
        return menuMapper.updateByIdSelected(menu);
    }

    @Override
    public int deleteMenuById(Long id) {
        return menuMapper.deleteById(id);
    }
}

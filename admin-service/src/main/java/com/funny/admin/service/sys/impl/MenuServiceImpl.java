package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.admin.MenuMapper;
import com.funny.admin.common.domain.admin.condition.MenuCondition;
import com.funny.admin.common.domain.admin.entity.MenuEntity;
import com.funny.admin.common.domain.admin.vo.MenuVo;
import com.funny.admin.common.utils.CachedBeanCopier;
import com.funny.admin.service.sys.MenuService;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuEntity> selectMenuListByCondition(MenuCondition condition) {
        return menuMapper.findByCondition(condition);
    }

    @Override
    public List<MenuVo> getMenuTree() {
        List<MenuEntity> menuList = menuMapper.findByCondition(new MenuCondition());
        Map<Long, MenuEntity> menuEntityMap = Maps.newHashMapWithExpectedSize(menuList.size());
        Map<Long, List<MenuVo>> childMap = Maps.newHashMapWithExpectedSize(menuList.size());

        for (MenuEntity menu : menuList) {
            menuEntityMap.put(menu.getId(), menu);
        }
        List<MenuVo> entityList = null;
        for (MenuEntity menu : menuList) {
            if (childMap.get(menu.getParentId()) == null) {
                entityList = Lists.newArrayList();
            } else {
                entityList = childMap.get(menu.getParentId());
            }
            MenuVo menuVo = new MenuVo();
            CachedBeanCopier.copy(menu, menuVo);
            entityList.add(menuVo);
            childMap.put(menu.getParentId(), entityList);
        }
        List<MenuVo> menuVoList = Lists.newArrayList();
        for (MenuEntity menu : menuList) {
            MenuVo menuVo = new MenuVo();
            CachedBeanCopier.copy(menu, menuVo);
            menuVo.setChildList(childMap.get(menuVo.getId()));
            menuVoList.add(menuVo);
        }
        Predicate<MenuVo> menuVoPredicate = new Predicate<MenuVo>() {
            @Override
            public boolean apply(MenuVo vo) {
                return vo.getParentId() == 999999999L;
            }
        };
        List<MenuVo> resultList = Lists.newArrayList(Iterables.filter(menuVoList, menuVoPredicate));
        return resultList;
    }

    @Override
    public int add(MenuEntity menuEntity) {
        return menuMapper.insert(menuEntity);
    }

    @Override
    public int update(MenuEntity menuEntity) {
        return menuMapper.updateByIdSelected(menuEntity);
    }

    @Override
    public MenuEntity findById(Long id) {
        return menuMapper.findById(id);
    }

    @Override
    public PageInfo<MenuEntity> getPageList(MenuCondition menuCondition) {
        List<MenuEntity> menuEntityList = menuMapper.findByCondition(menuCondition);
        return new PageInfo<MenuEntity>(menuEntityList);
    }
}

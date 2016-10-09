package com.funny.admin.service.sys.impl;

import com.funny.admin.common.dao.sys.MenuMapper;
import com.funny.admin.common.domain.sys.condition.MenuCondition;
import com.funny.admin.common.domain.sys.entity.MenuEntity;
import com.funny.admin.common.domain.sys.vo.MenuVo;
import com.funny.admin.service.sys.MenuService;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
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

    @Override
    public List<MenuVo> getMenuTree() {
        List<MenuEntity> menuList = menuMapper.selectMenuListByCondition(new MenuCondition());
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
            BeanUtils.copyProperties(menu, menuVo);
            entityList.add(menuVo);
            childMap.put(menu.getParentId(), entityList);
        }
        List<MenuVo> menuVoList = Lists.newArrayList();
        for (MenuEntity menu : menuList) {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(menu, menuVo);
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
}

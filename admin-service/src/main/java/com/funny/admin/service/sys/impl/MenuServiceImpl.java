package com.funny.admin.service.sys.impl;

import com.funny.admin.dao.sys.MenuMapper;
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
	public List<MenuEntity> listSubMenuByParentId(Long parentId) throws Exception {
		return menuMapper.listSubMenuByParentId(parentId);
	}

	@Override
	public MenuEntity getMenuById(Long id) throws Exception {
		return menuMapper.findById(id);
	}

	@Override
	public void saveMenu(MenuEntity menu) throws Exception {
		 menuMapper.updateByIdSelected(menu);
	}

	@Override
	public void deleteMenuById(String MENU_ID) throws Exception {

	}

	@Override
	public void edit(MenuEntity menu) throws Exception {

	}

	@Override
	public List<MenuEntity> listAllMenu(String MENU_ID) throws Exception {
		return null;
	}

	@Override
	public List<MenuEntity> listAllMenuQx(String MENU_ID) throws Exception {
		return null;
	}
}

package com.funny.admin.dao.sys;

import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> listSubMenuByParentId(Long parentId);
}
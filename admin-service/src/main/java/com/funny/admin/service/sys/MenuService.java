package com.funny.admin.service.sys;


import com.funny.admin.domain.sys.entity.MenuEntity;

import java.util.List;

public interface MenuService {
    /**
     * @param parentId
     * @return
     * @throws Exception
     */
    List<MenuEntity> listSubMenuByParentId(Long parentId) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    MenuEntity getMenuById(Long id) throws Exception;

    /**
     * @param menu
     * @throws Exception
     */
    void saveMenu(MenuEntity menu) throws Exception;


    /**
     * @param MENU_ID
     * @throws Exception
     */
    void deleteMenuById(String MENU_ID) throws Exception;

    /**
     * @param menu
     * @throws Exception
     */
    void edit(MenuEntity menu) throws Exception;

    /**
     * @param MENU_ID
     * @return
     * @throws Exception
     */
    List<MenuEntity> listAllMenu(String MENU_ID) throws Exception;

    /**
     * @param MENU_ID
     * @return
     * @throws Exception
     */
    List<MenuEntity> listAllMenuQx(String MENU_ID) throws Exception;
}

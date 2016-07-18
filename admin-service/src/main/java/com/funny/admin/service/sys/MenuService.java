package com.funny.admin.service.sys;


import com.funny.admin.domain.sys.Menu;

import java.util.List;

public interface MenuService {
    /**
     * @param parentId
     * @return
     * @throws Exception
     */
    List<Menu> listSubMenuByParentId(Long parentId) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
	Menu getMenuById(Long id) throws Exception;

    /**
     * @param menu
     * @throws Exception
     */
    void saveMenu(Menu menu) throws Exception;


    /**
     * @param MENU_ID
     * @throws Exception
     */
    void deleteMenuById(String MENU_ID) throws Exception;

    /**
     * @param menu
     * @throws Exception
     */
    void edit(Menu menu) throws Exception;

    /**
     * @param MENU_ID
     * @return
     * @throws Exception
     */
    List<Menu> listAllMenu(String MENU_ID) throws Exception;

    /**
     * @param MENU_ID
     * @return
     * @throws Exception
     */
    List<Menu> listAllMenuQx(String MENU_ID) throws Exception;
}

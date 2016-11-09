package com.funny.admin.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.funny.admin.common.AdminConstants;
import com.funny.admin.common.domain.admin.condition.MenuCondition;
import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.entity.IconEntity;
import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.funny.admin.common.domain.admin.enums.UserStatusEnum;
import com.funny.admin.common.domain.admin.vo.UserVo;
import com.funny.admin.common.result.ReturnCode;
import com.funny.admin.common.utils.CachedBeanCopier;
import com.funny.admin.service.sys.IconService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funny.admin.common.domain.admin.entity.MenuEntity;
import com.funny.admin.common.domain.admin.vo.MenuVo;
import com.funny.admin.common.result.JsonResult;
import com.funny.admin.service.sys.MenuService;
import com.funny.admin.web.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/menu/")
public class MenuController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private IconService iconService;

    @RequestMapping(value = "/getIconHtml")
    @ResponseBody
    public ModelAndView getIconHtml() throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/menu-icon");
        try {
            List<IconEntity> faIcons = iconService.findIcons(1);
            modelAndView.addObject("faIcons", faIcons);
        } catch (Exception e) {
            logger.error("获取菜单图标失败", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/getIconList")
    @ResponseBody
    public JsonResult getIconList() {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.setSuccess(iconService.findIcons(1));
        } catch (Exception e) {
            logger.error("获取菜单图标失败", e);
            jsonResult.setFail("获取菜单图标失败");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getMenuParentById")
    @ResponseBody
    public JsonResult getMenuParentById(Long id) {
        JsonResult<MenuVo> jsonResult = new JsonResult<>();
        MenuVo menuVo = new MenuVo();
        try {
            MenuEntity menu = menuService.findById(id);
            CachedBeanCopier.copy(menu, menuVo);
            if (menu.getParentId() != null && !menu.getParentId().equals(AdminConstants.PARENT_MENU)) {
                MenuEntity parentEntity = menuService.findById(menu.getParentId());
                MenuVo parent = new MenuVo();
                CachedBeanCopier.copy(parentEntity, parent);
                menuVo.setParentMenu(parent);
            }
            jsonResult.setSuccess();
            jsonResult.setResult(menuVo);
        } catch (Exception e) {
            logger.error("获取菜单失败,param={}", id, e);
            jsonResult.setFail("获取菜单失败");
        }
        return jsonResult;
    }

    @RequestMapping("/list")
    public ModelAndView getMenuList(UserCondition condition) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/menu-list");
        return modelAndView;
    }

    @RequestMapping("/getSubMenuList")
    public ModelAndView getSubMenuList(Long parentId) throws Exception {
        ModelAndView mv = new ModelAndView("/admin/menu-page");
        MenuCondition menuCondition = new MenuCondition();
        menuCondition.setParentId(parentId);
        try {
            List<MenuEntity> menuEntityList = menuService.selectMenuListByCondition(menuCondition);
            mv.addObject("subMenuList", menuEntityList);
        } catch (Exception e) {
            logger.error("获取子菜单列表失败,param={}", parentId, e);
        }
        return mv;
    }

    @RequestMapping(value = "/getMenuList")
    @ResponseBody
    public JsonResult getMenuList() {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.setSuccess(menuService.getMenuTree());
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            jsonResult.setFail("获取菜单失败");
        }
        return jsonResult;
    }

    @RequestMapping("/getById")
    public ModelAndView getById(Long id, Long parentId) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/menu-edit");
        if (id != null) {
            MenuEntity menu = menuService.findById(id);
            modelAndView.addObject("menu", menu);

            MenuEntity parentMenu = menuService.findById(menu.getParentId());
            MenuCondition menuCondition = new MenuCondition();
            menuCondition.setParentId(parentMenu.getParentId());
            List<MenuEntity> menuEntityList = menuService.selectMenuListByCondition(menuCondition);
            modelAndView.addObject("parentMenu", parentMenu);
            modelAndView.addObject("menuList", menuEntityList);
        } else {
            MenuEntity parentMenu = new MenuEntity();
            parentMenu.setId(parentId);
            modelAndView.addObject("parentMenu", parentMenu);
            if (!parentId.equals(AdminConstants.PARENT_MENU)) {
                MenuEntity menu = menuService.findById(parentId);
                MenuCondition menuCondition = new MenuCondition();
                menuCondition.setParentId(menu.getParentId());
                List<MenuEntity> menuEntityList = menuService.selectMenuListByCondition(menuCondition);
                modelAndView.addObject("menuList", menuEntityList);
            }
        }
        return modelAndView;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult deleteUser(Long id) {
        JsonResult jsonResult = new JsonResult();
        try {
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setUpdateBy(getCurrentLoginUserId());
            menuEntity.setId(id);
            menuEntity.setYn(0);
            menuService.update(menuEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("删除菜单失败,param={}", id, e);
            jsonResult.setFail("删除菜单失败");
        }
        return jsonResult;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult saveMenu(MenuEntity menuEntity) {
        JsonResult jsonResult = checkMenu(menuEntity);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            if (menuEntity.getId() != null) {
                menuEntity.setUpdateBy(getCurrentLoginUserId());
                menuService.update(menuEntity);
            } else {
                menuEntity.setCreateBy(getCurrentLoginUserId());
                if (menuEntity.getParentId() == null) {
                    menuEntity.setParentId(AdminConstants.PARENT_MENU);
                    menuEntity.setMenuType(1);
                }
                menuService.add(menuEntity);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("保存菜单失败,param={}", JSON.toJSONString(menuEntity), e);
            jsonResult.setFail("保存菜单失败");
        }
        return jsonResult;
    }

    private JsonResult checkMenu(MenuEntity user) {
        JsonResult jsonResult = new JsonResult();
        if (Strings.isNullOrEmpty(user.getMenuName())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "菜单名不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(user.getMenuUrl())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "菜单url不能为空!");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }
}

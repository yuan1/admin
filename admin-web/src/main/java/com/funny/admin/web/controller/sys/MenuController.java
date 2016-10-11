package com.funny.admin.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.funny.admin.common.domain.sys.condition.MenuCondition;
import com.funny.admin.common.domain.sys.condition.UserCondition;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.common.domain.sys.entity.IconEntity;
import com.funny.admin.common.domain.sys.enums.UserStatusEnum;
import com.funny.admin.service.sys.IconService;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funny.admin.common.domain.sys.entity.MenuEntity;
import com.funny.admin.common.domain.sys.vo.MenuVo;
import com.funny.admin.common.result.JsonResult;
import com.funny.admin.service.sys.MenuService;
import com.funny.admin.web.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
    public ModelAndView getIconHtml() {
        ModelAndView modelAndView= new ModelAndView("menu/icon");
        try {
            List<IconEntity> faIcons= iconService.findIcons(1);
            modelAndView.addObject("faIcons",faIcons);
        } catch (Exception e) {
            logger.error("获取菜单图标失败",e);
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
            logger.error("获取菜单图标失败",e);
            jsonResult.setFail("获取菜单图标失败");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getMenuParentById")
    @ResponseBody
    public JsonResult getMenuParentById(Long id) {
        JsonResult<MenuVo> jsonResult = new JsonResult<MenuVo>();
        MenuVo menuVo = new MenuVo();
        try {
            MenuEntity menu = menuService.getMenuById(id);
            BeanUtils.copyProperties(menu, menuVo);
            if (menu.getParentId() != null && menu.getParentId() != 999999999L) {
                MenuEntity parentEntity = menuService.getMenuById(menu.getParentId());
                MenuVo parent = new MenuVo();
                BeanUtils.copyProperties(parentEntity, parent);
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
    public ModelAndView getMenuList(UserCondition condition) {
        ModelAndView modelAndView = new ModelAndView("menu/list");
        return modelAndView;
    }

    @RequestMapping("/getSubMenuList")
    public ModelAndView getSubMenuList(Long parentId) {
        ModelAndView mv = new ModelAndView("menu/page");
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
            logger.error("获取菜单失败",e);
            jsonResult.setFail("获取菜单失败");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/saveMenu")
    @ResponseBody
    public JsonResult saveMenu(MenuEntity menuEntity) {
        JsonResult jsonResult = new JsonResult();
        try {
            menuService.addMenu(menuEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("获取菜单失败",e);
            jsonResult.setFail("获取菜单失败");
        }
        return jsonResult;
    }

}

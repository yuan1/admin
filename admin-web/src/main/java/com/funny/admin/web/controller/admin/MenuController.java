package com.funny.admin.web.controller.admin;

import com.funny.admin.common.domain.admin.condition.MenuCondition;
import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.entity.IconEntity;
import com.funny.admin.common.utils.CachedBeanCopier;
import com.funny.admin.service.sys.IconService;
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
    public ModelAndView getIconHtml() throws Exception{
        ModelAndView modelAndView= new ModelAndView("/admin/menu-icon");
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
        JsonResult<MenuVo> jsonResult = new JsonResult<>();
        MenuVo menuVo = new MenuVo();
        try {
            MenuEntity menu = menuService.findById(id);
            CachedBeanCopier.copy(menu, menuVo);
            if (menu.getParentId() != null && menu.getParentId() != 999999999L) {
                MenuEntity parentEntity = menuService.findById(menu.getParentId());
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
    public ModelAndView getMenuList(UserCondition condition) throws Exception{
        ModelAndView modelAndView = new ModelAndView("/admin/menu-list");
        return modelAndView;
    }

    @RequestMapping("/getSubMenuList")
    public ModelAndView getSubMenuList(Long parentId) throws Exception{
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
            menuService.add(menuEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("获取菜单失败",e);
            jsonResult.setFail("获取菜单失败");
        }
        return jsonResult;
    }

}

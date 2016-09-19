package com.funny.admin.web.controller.sys;

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

@Controller
@RequestMapping("/admin/menu/")
public class MenuController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getMenuParentById")
    @ResponseBody
    public JsonResult getMenuParentById(Long id) {
        JsonResult<MenuVo> jsonResult = new JsonResult<MenuVo>();
        MenuVo menuVo = new MenuVo();
        try {
            MenuEntity menu = menuService.getMenuById(id);
            BeanUtils.copyProperties(menu, menuVo);
            if (menu.getParentId() != null && menu.getParentId() != 0L) {
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
}

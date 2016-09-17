package com.funny.admin.web.controller.sys;

import com.funny.admin.web.controller.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funny.admin.web.controller.BaseController;
import com.funny.admin.domain.sys.entity.MenuEntity;
import com.funny.admin.domain.sys.vo.MenuVo;
import com.funny.admin.service.sys.MenuService;
import com.funny.result.JsonResult;

@Controller
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu/getMenuParentById")
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
                BeanUtils.copyProperties(parentEntity,parent);
                menuVo.setParentMenu(parent);
            }
            jsonResult.setSuccess();
            jsonResult.setResult(menuVo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setReturncode(500);
            jsonResult.setMessage(e.getMessage());
        }
        return jsonResult;
    }
}

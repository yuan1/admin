package com.funny.admin.controller.sys;

import com.funny.admin.controller.BaseController;
import com.funny.admin.domain.sys.Menu;
import com.funny.admin.service.sys.MenuService;
import com.funny.admin.vo.sys.MenuVo;
import com.funny.result.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value="/menu/getMenuParentById")
    @ResponseBody
    public JsonResult getMenuParentById(Long id){
        JsonResult<MenuVo> jsonResult = new JsonResult<MenuVo>();
        MenuVo menuVo = new MenuVo();
        try {
            Menu menu = menuService.getMenuById(id);
            BeanUtils.copyProperties(menu,menuVo);
            if(menu.getParentId()!=null && menu.getParentId() != 0L){
                Menu parentMenu = menuService.getMenuById(menu.getParentId());
                menuVo.setParentMenu(parentMenu);
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

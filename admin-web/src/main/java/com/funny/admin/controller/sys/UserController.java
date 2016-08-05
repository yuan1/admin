package com.funny.admin.controller.sys;

import com.funny.admin.domain.sys.User;
import com.funny.admin.service.sys.UserService;
import com.funny.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public ModelAndView getUserList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_list");
        return modelAndView;
    }

    @RequestMapping("/user/add")
    public ModelAndView add(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_edit");
        return modelAndView;
    }

    @RequestMapping("/user/getUserById")
    public ModelAndView getUserById(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_edit");
        return modelAndView;
    }

    @RequestMapping("/user/save")
    @ResponseBody
    public JsonResult saveUser(HttpServletRequest request, User user) {
        JsonResult jsonResult = new JsonResult();
        try {
            if (user.getId() != null) {
                user.setUpdateBy(1L);
                user.setUpdateTime(new Date());
                userService.updateUser(user);
            } else {
                user.setCreateBy(1L);
                user.setCreateTime(new Date());
                userService.addUser(user);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setReturncode(500);
            jsonResult.setMessage("保存失败");
        }
        return jsonResult;
    }

}

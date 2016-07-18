package com.funny.admin.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.controller.BaseController;


@Controller
public class UserController extends BaseController {
	

    @RequestMapping("/user/list")
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_list");



        return  modelAndView;
    }

}

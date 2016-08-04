package com.funny.admin.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.controller.BaseController;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController extends BaseController {
	

    @RequestMapping("/user/list")
    public ModelAndView getUserList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_list");
        return  modelAndView;
    }

    @RequestMapping("/user/add")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_edit");


        return  modelAndView;
    }

}

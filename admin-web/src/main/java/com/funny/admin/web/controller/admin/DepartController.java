package com.funny.admin.web.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.enums.UserStatusEnum;
import com.funny.admin.service.sys.UserService;
import com.funny.admin.web.controller.BaseController;

@Controller
@RequestMapping("/admin/depart/")
public class DepartController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(DepartController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView getUserList(UserCondition condition) throws Exception {
        ModelAndView modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("statusList", UserStatusEnum.values());
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }



}

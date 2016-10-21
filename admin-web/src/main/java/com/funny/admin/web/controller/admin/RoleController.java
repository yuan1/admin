package com.funny.admin.web.controller.admin;

import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.enums.UserStatusEnum;
import com.funny.admin.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/admin/role")
public class RoleController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @RequestMapping("/list")
    public ModelAndView getRoleList(UserCondition condition) throws Exception{
        ModelAndView modelAndView = new ModelAndView("/admin/role-list");
        modelAndView.addObject("statusList", UserStatusEnum.values());
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

}
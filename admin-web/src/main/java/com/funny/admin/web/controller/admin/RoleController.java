package com.funny.admin.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.funny.admin.common.domain.admin.condition.RoleCondition;
import com.funny.admin.common.domain.admin.condition.UserCondition;
import com.funny.admin.common.domain.admin.entity.RoleEntity;
import com.funny.admin.common.domain.admin.entity.UserEntity;
import com.funny.admin.common.domain.admin.enums.UserStatusEnum;
import com.funny.admin.common.domain.admin.vo.UserVo;
import com.funny.admin.common.result.JsonResult;
import com.funny.admin.common.result.ReturnCode;
import com.funny.admin.common.utils.CachedBeanCopier;
import com.funny.admin.service.sys.RoleService;
import com.funny.admin.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value="/admin/role")
public class RoleController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView getUserList() throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/role-list");
        return modelAndView;
    }

    @RequestMapping(value = "rolePageList")
    public ModelAndView rolePageList(RoleCondition condition) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/role-page");
        PageInfo<RoleEntity> pageInfo = roleService.getPageList(condition);
        modelAndView.addObject("pageInfo", pageInfo);
        if (CollectionUtils.isNotEmpty(pageInfo.getList())) {
            modelAndView.addObject("roleList", pageInfo.getList());
        }
        return modelAndView;
    }

    @RequestMapping("/getById")
    public ModelAndView getUserById(Long id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/role-edit");
        RoleEntity roleEntity = roleService.findById(id);
        modelAndView.addObject("role", roleEntity);
        return modelAndView;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult saveUser(RoleEntity roleEntity) {
        JsonResult jsonResult = checkUser(roleEntity);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            if (roleEntity.getId() != null) {
                roleEntity.setUpdateBy(getCurrentLoginUserId());
                roleService.update(roleEntity);
            } else {
                roleEntity.setCreateBy(getCurrentLoginUserId());
                roleService.add(roleEntity);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("保存角色失败,param={}", JSON.toJSONString(roleEntity), e);
            jsonResult.setFail("保存角色失败");
        }
        return jsonResult;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult deleteUser(Long id) {
        JsonResult jsonResult = new JsonResult();
        try {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setUpdateBy(getCurrentLoginUserId());
            roleEntity.setId(id);
            roleEntity.setYn(0);
            roleService.update(roleEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("删除角色失败,param={}", id, e);
            jsonResult.setFail("删除角色失败");
        }
        return jsonResult;
    }

    private JsonResult checkUser(RoleEntity roleEntity) {
        JsonResult jsonResult = new JsonResult();
        if (Strings.isNullOrEmpty(roleEntity.getRoleName())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "角色名不能为空!");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }


}
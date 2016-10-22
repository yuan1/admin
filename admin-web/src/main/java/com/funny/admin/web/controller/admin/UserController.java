package com.funny.admin.web.controller.admin;

import java.util.List;
import java.util.Map;

import com.funny.admin.common.domain.admin.entity.UserRoleEntity;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
import com.funny.admin.service.sys.UserService;
import com.funny.admin.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/admin/user/")
public class UserController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView getUserList(UserCondition condition) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/user-list");
        modelAndView.addObject("statusList", UserStatusEnum.values());
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping(value = "userPageList")
    public ModelAndView userPageList(UserCondition condition) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/user-page");
        PageInfo<UserEntity> pageInfo = userService.getPageList(condition);
        modelAndView.addObject("pageInfo", pageInfo);
        if (CollectionUtils.isNotEmpty(pageInfo.getList())) {
            List<UserVo> userVoList = Lists.newArrayListWithExpectedSize(pageInfo.getList().size());
            for (UserEntity userEntity : pageInfo.getList()) {
                UserVo userVo = new UserVo();
                CachedBeanCopier.copy(userEntity, userVo);
                userVoList.add(userVo);
            }
            modelAndView.addObject("userList", userVoList);
        }
        return modelAndView;
    }

    @RequestMapping("/getById")
    public ModelAndView getById(Long id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/user-edit");
        UserEntity user = userService.findById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult saveUser(UserVo user) {
        JsonResult jsonResult = checkUser(user);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            UserEntity userEntity = new UserEntity();
            CachedBeanCopier.copy(user, userEntity);
            if (userEntity.getId() != null) {
                userEntity.setUpdateBy(getCurrentLoginUserId());
                userService.update(userEntity);
            } else {
                userEntity.setCreateBy(getCurrentLoginUserId());
                userEntity.setUserStatus(UserStatusEnum.NORMAL.getValue());
                userService.add(userEntity);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("保存用户失败,param={}", JSON.toJSONString(user), e);
            jsonResult.setFail("保存用户失败");
        }
        return jsonResult;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult deleteUser(Long id) {
        JsonResult jsonResult = new JsonResult();
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUpdateBy(getCurrentLoginUserId());
            userEntity.setId(id);
            userEntity.setYn(0);
            userService.update(userEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("删除用户失败,param={}", id, e);
            jsonResult.setFail("删除用户失败");
        }
        return jsonResult;
    }

    @RequestMapping("/getRoleList")
    public ModelAndView getRoleList(Long id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/admin/user-role");
        RoleCondition condition = new RoleCondition();
        condition.setUserId(id);
        List<RoleEntity> roleEntityList = roleService.findRoleList(condition);

        List<UserRoleEntity> userRoleEntityList = userService.findUserRoleByUserId(id);
        if (CollectionUtils.isNotEmpty(userRoleEntityList)) {
            Map<Long, Long> userRoleMap = Maps.newHashMapWithExpectedSize(userRoleEntityList.size());
            for (UserRoleEntity userRoleEntity : userRoleEntityList) {
                userRoleMap.put(userRoleEntity.getRoleId(), userRoleEntity.getRoleId());
            }
            for (RoleEntity roleEntity : roleEntityList) {
                if (userRoleMap.get(roleEntity.getId()) != null) {
                    roleEntity.setChecked(true);
                }
            }
        }
        modelAndView.addObject("roleList", roleEntityList);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("/saveRoles")
    @ResponseBody
    public JsonResult saveRoles(Long id, String roleIds) {
        JsonResult jsonResult = new JsonResult();
        if (Strings.isNullOrEmpty(roleIds)) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "请选择角色!");
            return jsonResult;
        }
        if (id == null) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "未找到用户信息,请重新操作!");
            return jsonResult;
        }
        try {
            userService.addRoles(getCurrentLoginUserId(), id, roleIds);
            jsonResult.setSuccess();
        } catch (Exception e) {
            logger.error("分配角色失败,id={id},roleIds={roleIds}", e);
            jsonResult.setFail("分配角色失败!");
        }
        return jsonResult;
    }

    private JsonResult checkUser(UserVo user) {
        JsonResult jsonResult = new JsonResult();
        if (Strings.isNullOrEmpty(user.getUserName())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "用户名不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(user.getRealName())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "姓名不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(user.getMobile())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "手机不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(user.getEmail())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "邮箱不能为空!");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

}

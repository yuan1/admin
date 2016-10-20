package com.funny.admin.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.funny.admin.common.domain.sys.entity.UserEntity;
import com.funny.admin.common.domain.sys.condition.UserCondition;
import com.funny.admin.common.domain.sys.enums.UserStatusEnum;
import com.funny.admin.common.domain.sys.vo.UserVo;
import com.funny.admin.common.result.ReturnCode;
import com.funny.admin.common.utils.CachedBeanCopier;
import com.funny.admin.service.sys.UserService;
import com.funny.admin.common.result.JsonResult;
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

import com.funny.admin.web.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/user/")
public class UserController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView getUserList(UserCondition condition) {
        ModelAndView modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("statusList", UserStatusEnum.values());
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping(value = "userPageList")
    public ModelAndView userPageList(UserCondition condition) {
        ModelAndView modelAndView = new ModelAndView("user/page");
        try {
            PageInfo<UserEntity> pageInfo = userService.getPageList(condition);
            modelAndView.addObject("pageInfo", pageInfo);
            if(CollectionUtils.isNotEmpty(pageInfo.getList())){
                List<UserVo> userVoList = Lists.newArrayListWithExpectedSize(pageInfo.getList().size());
                for(UserEntity userEntity:pageInfo.getList()){
                    UserVo userVo = new UserVo();
                    CachedBeanCopier.copy(userEntity,userVo);
                    userVoList.add(userVo);
                }
                modelAndView.addObject("userList", userVoList);
            }
        } catch (Exception e) {
            logger.error("获取用户列表，内部发生异常", e);
        }
        return modelAndView;
    }

    @RequestMapping("/getUserById")
    public ModelAndView getUserById(Long id) {
        ModelAndView modelAndView = new ModelAndView("user/edit");
        try {
            UserEntity user = userService.findById(id);
            modelAndView.addObject("user", user);
        } catch (Exception e) {
            logger.error("查询用户失败,param={}", id, e);
        }
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

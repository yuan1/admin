package com.funny.admin.controller.sys;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.funny.admin.condition.sys.DictCondition;
import com.funny.admin.domain.sys.Dict;
import com.funny.admin.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.condition.sys.UserCondition;
import com.funny.admin.controller.BaseController;
import com.funny.admin.domain.sys.User;
import com.funny.admin.service.sys.UserService;
import com.funny.result.JsonResult;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;

@Controller
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @RequestMapping("/dict/list")
    public ModelAndView getUserList(HttpServletRequest request, DictCondition condition) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/dict/dict_list");
        PageInfo<Dict> pageInfo = dictService.getPageDictList(condition);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("dictList", pageInfo.getList());
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping("/dict/add")
    public ModelAndView add(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/dict/dict_edit");
        return modelAndView;
    }

    @RequestMapping("/dict/getUserById")
    public ModelAndView getUserById(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_edit");
        return modelAndView;
    }

    @RequestMapping("/dict/save")
    @ResponseBody
    public JsonResult saveUser(HttpServletRequest request, Dict dict) {
        JsonResult jsonResult = checkDict(dict);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            if (dict.getId() != null) {
                dict.setUpdateBy(1L);
                dict.setUpdateTime(new Date());
                dictService.updateDict(dict);
            } else {
                dict.setCreateBy(1L);
                dict.setCreateTime(new Date());
                dict.setYn(1);
                dictService.addDict(dict);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setReturncode(500);
            jsonResult.setMessage("保存失败");
        }
        return jsonResult;
    }

    private JsonResult checkDict(Dict dict) {
        JsonResult jsonResult = new JsonResult();
        if (dict.getDictId() == null) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("字典类型id不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(dict.getDictName())) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("字典类型名称不能为空!");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

}

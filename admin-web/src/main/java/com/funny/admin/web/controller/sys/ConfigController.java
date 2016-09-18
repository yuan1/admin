package com.funny.admin.web.controller.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.funny.admin.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.common.domain.sys.entity.ConfigEntity;
import com.funny.admin.common.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.common.domain.sys.condition.ConfigItemCondition;
import com.funny.admin.common.domain.sys.vo.ConfigItemVo;
import com.funny.admin.service.sys.ConfigService;
import com.funny.admin.common.result.JsonResult;
import com.google.common.base.Strings;

/**
 * Created by funny on 16/8/25.
 */
@Controller
@RequestMapping("/admin/config/")
public class ConfigController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
    @Resource
    private ConfigService configService;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("config/tree");
        return mv;
    }

    @RequestMapping(value = "/getConfigList")
    @ResponseBody
    public JsonResult getConfigList() {
        JsonResult jsonResult = new JsonResult();
        try {
            List<ConfigEntity> stringList = configService.findConfigList();
            jsonResult.setSuccess(stringList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取系统配置列表,内部发生异常", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getConfigById")
    @ResponseBody
    public JsonResult getConfigById(Long id) {
        JsonResult jsonResult = new JsonResult();
        try {
            ConfigEntity configEntity = configService.findConfigById(id);
            jsonResult.setSuccess(configEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

    @RequestMapping(value = "/itemList")
    public ModelAndView itemList(ConfigItemCondition condition) {
        ModelAndView mv = new ModelAndView("config/list");
        try {
            List<ConfigItemEntity> configItemEntityList = configService.findConfigItemList(condition);
            mv.addObject("configItemList", configItemEntityList);
        } catch (Exception e) {
        }
        return mv;
    }

    @RequestMapping(value = "/saveConfig")
    @ResponseBody
    public JsonResult saveConfig(HttpServletRequest request, ConfigItemVo vo) {
        JsonResult jsonResult = new JsonResult();
        jsonResult = checkConfig(vo);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }

        ConfigEntity configEntity = new ConfigEntity();
        try {
            BeanUtils.copyProperties(vo, configEntity);
            if (vo.getId() == null) {
                configService.addConfig(configEntity);
            } else {
                configService.updateConfig(configEntity);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setReturncode(1);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/addItem")
    public ModelAndView addItem(Long configId) {
        ModelAndView mv = new ModelAndView("config/item-add");
        if (configId != null) {
            ConfigEntity configEntity = configService.findConfigById(configId);
            mv.addObject("config", configEntity);
        }
        return mv;
    }

    @RequestMapping(value = "/submitAddItem")
    @ResponseBody
    public JsonResult submitAddItem(HttpServletRequest request, ConfigItemVo vo) {
        JsonResult jsonResult = checkConfigItem(vo);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        ConfigItemEntity configItemEntity = new ConfigItemEntity();
        try {
            BeanUtils.copyProperties(vo, configItemEntity);
            configItemEntity.setItemId(Integer.parseInt(vo.getItemId()));
            configService.addConfigItem(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setReturncode(1);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/editItem")
    public ModelAndView editItem(Long id) {
        ModelAndView mv = new ModelAndView("config/item-edit");
        ConfigItemEntity configItemEntity = configService.findConfigItemById(id);
        mv.addObject("configItem", configItemEntity);
        return mv;
    }

    @RequestMapping(value = "/submitEditItem")
    @ResponseBody
    public JsonResult submitEditItem(HttpServletRequest request, ConfigItemVo vo) {
        JsonResult jsonResult = new JsonResult();
        if (vo.getId() == null) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("请选择1条记录!");
            return jsonResult;
        }
        jsonResult = checkConfigItem(vo);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }

        ConfigItemEntity configItemEntity = new ConfigItemEntity();
        try {
            BeanUtils.copyProperties(vo, configItemEntity);
            configItemEntity.setItemId(Integer.parseInt(vo.getItemId()));
            configService.updateConfigItem(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setReturncode(1);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/removeItem")
    public ModelAndView removeItem(Long id) {
        ModelAndView mv = new ModelAndView("config/item-remove");
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping(value = "/submitRemoveItem", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult submitRemoveItem(HttpServletRequest request, Long id) {
        JsonResult jsonResult = new JsonResult();
        ConfigItemEntity configItemEntity = new ConfigItemEntity();
        try {
            if (id == null) {
                jsonResult.setReturncode(1);
                return jsonResult;
            }
            configItemEntity.setId(id);
            configItemEntity.setUpdateBy(1L);
            configItemEntity.setUpdateTime(new Date());
            configService.updateConfigItem(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setReturncode(1);
        }
        return jsonResult;
    }

    private JsonResult checkConfig(ConfigItemVo vo) {
        JsonResult jsonResult = new JsonResult();
        if (vo.getId() == null && Strings.isNullOrEmpty(vo.getConfigCode())) {
            jsonResult.setReturncode(500);
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getConfigDesc())) {
            jsonResult.setReturncode(500);
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

    private JsonResult checkConfigItem(ConfigItemVo vo) {
        JsonResult jsonResult = new JsonResult();
        if (vo.getConfigId() == null) {
            jsonResult.setReturncode(500);
            return jsonResult;
        }
        try {
            Integer dicId = Integer.parseInt(vo.getItemId().trim());
        } catch (NumberFormatException e) {
            jsonResult.setReturncode(500);
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getItemValue())) {
            jsonResult.setReturncode(500);
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getItemName())) {
            jsonResult.setReturncode(500);
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

}

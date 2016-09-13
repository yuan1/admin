package com.funny.admin.controller.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.controller.BaseController;
import com.funny.admin.domain.sys.entity.ConfigEntity;
import com.funny.admin.domain.sys.entity.ConfigItemEntity;
import com.funny.admin.domain.sys.condition.ConfigItemCondition;
import com.funny.admin.domain.sys.vo.ConfigItemVo;
import com.funny.admin.service.sys.ConfigService;
import com.funny.result.JsonResult;
import com.google.common.base.Strings;
import com.sun.tracing.dtrace.ModuleName;

/**
 * Created by funny on 16/8/25.
 */
@Controller
@ModuleName("系统配置")
public class ConfigController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
    @Resource
    private ConfigService configService;

    @RequestMapping(value = "/config/list")
    public ModelAndView list(Long configId) {
        ModelAndView mv = new ModelAndView("config/list");
        return mv;
    }

    @RequestMapping(value = "/config/getConfigList")
    @ResponseBody
    public JsonResult getConfigList() {
        JsonResult jsonResult = new JsonResult();
        try {
            List<ConfigEntity> stringList = configService.findConfigList();
            jsonResult.setSuccess(stringList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取系统配置列表，内部发生异常", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/config/getConfigById")
    @ResponseBody
    public JsonResult getConfigById(Long id) {
        JsonResult jsonResult = new JsonResult();
        try {
            ConfigEntity configEntity = configService.findConfigById(id);
            jsonResult.setSuccess(configEntity);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取系统配置列表，内部发生异常", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/config/itemList")
    public ModelAndView itemList(ConfigItemCondition condition) {
        ModelAndView mv = new ModelAndView("config/item-list");
        try {
            List<ConfigItemEntity> configItemEntityList = configService.findConfigItemList(condition);
            mv.addObject("configItemList", configItemEntityList);
        } catch (Exception e) {
            logger.error("获取系统配置列表，内部发生异常", e);
        }
        return mv;
    }

    @RequestMapping(value = "/config/saveConfig")
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
            jsonResult.setMessage("系统内部发生异常，请联系相关联系人");
            logger.error("添加系统配置，内部发生异常", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/config/addItem")
    public ModelAndView addItem(Long configId) {
        ModelAndView mv = new ModelAndView("config/item-add");
        if (configId != null) {
            ConfigEntity configEntity = configService.findConfigById(configId);
            mv.addObject("config", configEntity);
        }
        return mv;
    }

    @RequestMapping(value = "/config/submitAddItem")
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
            jsonResult.setMessage("系统内部发生异常，请联系相关联系人");
            logger.error("添加系统配置，内部发生异常", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/config/editItem")
    public ModelAndView editItem(Long id) {
        ModelAndView mv = new ModelAndView("config/item-edit");
        ConfigItemEntity configItemEntity = configService.findConfigItemById(id);
        mv.addObject("configItem", configItemEntity);
        return mv;
    }

    @RequestMapping(value = "/config/submitEditItem")
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
            jsonResult.setMessage("系统内部发生异常，请联系相关联系人");
            logger.error("添加系统配置，内部发生异常", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/config/removeItem")
    public ModelAndView removeItem(Long id) {
        ModelAndView mv = new ModelAndView("config/item-remove");
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping(value = "/config/submitRemoveItem", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult submitRemoveItem(HttpServletRequest request, Long id) {
        JsonResult jsonResult = new JsonResult();
        ConfigItemEntity configItemEntity = new ConfigItemEntity();
        try {
            if (id == null) {
                jsonResult.setReturncode(1);
                jsonResult.setMessage("请选择1条记录");
                return jsonResult;
            }
            configItemEntity.setId(id);
            configItemEntity.setUpdateBy(1L);
            configItemEntity.setUpdateTime(new Date());
            configService.updateConfigItem(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setReturncode(1);
            jsonResult.setMessage("系统内部发生异常，请联系相关联系人");
            logger.error("删除系统配置，内部发生异常", e);
        }
        return jsonResult;
    }

    private JsonResult checkConfig(ConfigItemVo vo) {
        JsonResult jsonResult = new JsonResult();
        if (vo.getId() == null && Strings.isNullOrEmpty(vo.getConfigCode())) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("配置编码不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getConfigDesc())) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("配置描述不能为空!");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

    private JsonResult checkConfigItem(ConfigItemVo vo) {
        JsonResult jsonResult = new JsonResult();
        if (vo.getConfigId() == null) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("请选择1个配置再添加配置项!");
            return jsonResult;
        }
        try {
            Integer dicId = Integer.parseInt(vo.getItemId().trim());
        } catch (NumberFormatException e) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("配置项id必须为数字!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getItemValue())) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("配置项value不能为空!");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getItemName())) {
            jsonResult.setReturncode(500);
            jsonResult.setMessage("配置项描述不能为空!");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

}

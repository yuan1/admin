package com.funny.admin.web.controller.admin;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.funny.admin.common.result.ReturnCode;
import com.funny.admin.service.sys.ConfigItemService;
import com.funny.admin.web.controller.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.common.domain.admin.entity.ConfigEntity;
import com.funny.admin.common.domain.admin.entity.ConfigItemEntity;
import com.funny.admin.common.domain.admin.condition.ConfigItemCondition;
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
    @Autowired
    private ConfigService configService;
    @Autowired
    private ConfigItemService configItemService;

    @RequestMapping(value = "/list")
    public ModelAndView list() throws Exception {
        ModelAndView mv = new ModelAndView("/admin/config-tree");
        return mv;
    }

    @RequestMapping(value = "/getConfigList")
    @ResponseBody
    public JsonResult getConfigList() {
        JsonResult jsonResult = new JsonResult();
        try {
            List<ConfigEntity> stringList = configService.findAllConfig();
            jsonResult.setSuccess(stringList);
        } catch (Exception e) {
            jsonResult.setFail("获取配置列表失败");
            logger.error("获取配置列表失败", e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getConfigById")
    @ResponseBody
    public JsonResult getConfigById(Long id) {
        JsonResult jsonResult = new JsonResult();
        try {
            ConfigEntity configEntity = configService.findById(id);
            jsonResult.setSuccess(configEntity);
        } catch (Exception e) {
            jsonResult.setFail("获取配置详情失败");
            logger.error("获取配置详情失败,param={}", id, e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/itemList")
    public ModelAndView itemList(ConfigItemCondition condition) throws Exception {
        ModelAndView mv = new ModelAndView("/admin/config-list");
        List<ConfigItemEntity> configItemEntityList = configItemService.findConfigItemList(condition);
        mv.addObject("configItemList", configItemEntityList);
        return mv;
    }

    @RequestMapping(value = "/saveConfig")
    @ResponseBody
    public JsonResult saveConfig(ConfigEntity vo) {
        JsonResult jsonResult = checkConfig(vo);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            if (vo.getId() == null) {
                configService.add(vo);
            } else {
                configService.update(vo);
            }
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setFail("新增配置项失败");
            logger.error("新增配置项失败,param={}", JSON.toJSONString(vo), e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/addItem")
    public ModelAndView addItem(Long configId) throws Exception {
        ModelAndView mv = new ModelAndView("/admin/config-add");
        if (configId != null) {
            ConfigEntity configEntity = configService.findById(configId);
            mv.addObject("config", configEntity);
        }
        return mv;
    }

    @RequestMapping(value = "/submitAddItem")
    @ResponseBody
    public JsonResult submitAddItem(ConfigItemEntity configItemEntity) {
        JsonResult jsonResult = checkConfigItem(configItemEntity);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            int maxItemId = configItemService.selectMaxItemId(configItemEntity.getConfigId());
            configItemEntity.setItemId(maxItemId + 1);
            configItemService.add(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setFail("修改配置项失败");
            logger.error("修改配置项失败,param={}", JSON.toJSONString(configItemEntity), e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/editItem")
    public ModelAndView editItem(Long id)throws Exception {
        ModelAndView mv = new ModelAndView("config/edit");
        ConfigItemEntity configItemEntity = configItemService.findById(id);
        mv.addObject("configItem", configItemEntity);
        return mv;
    }

    @RequestMapping(value = "/submitEditItem")
    @ResponseBody
    public JsonResult submitEditItem(ConfigItemEntity configItemEntity) {
        JsonResult jsonResult = new JsonResult();
        if (configItemEntity.getId() == null) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "请选择1条记录!");
            return jsonResult;
        }
        jsonResult = checkConfigItem(configItemEntity);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        try {
            configItemEntity.setUpdateBy(getCurrentLoginUserId());
            configItemService.update(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setFail("修改配置项失败");
            logger.error("修改配置项失败,param={}", JSON.toJSONString(configItemEntity), e);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/submitRemoveItem", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult submitRemoveItem(Long id) {
        JsonResult jsonResult = new JsonResult();
        if (id == null) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "请选择1条记录!");
            return jsonResult;
        }
        ConfigItemEntity configItemEntity = new ConfigItemEntity();
        configItemEntity.setId(id);
        configItemEntity.setYn(0);
        try {
            configItemEntity.setUpdateBy(getCurrentLoginUserId());
            configItemService.update(configItemEntity);
            jsonResult.setSuccess();
        } catch (Exception e) {
            jsonResult.setFail("删除配置项失败");
            logger.error("删除配置项失败,param={}", id, e);
        }
        return jsonResult;
    }

    private JsonResult checkConfig(ConfigEntity vo) {
        JsonResult jsonResult = new JsonResult();
        if (Strings.isNullOrEmpty(vo.getConfigCode())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "配置编码不能为空");
            return jsonResult;
        } else {
            ConfigEntity configEntity = configService.findConfigByCode(vo.getConfigCode());
            if (configEntity != null && !configEntity.getId().equals(vo.getId())) {
                jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "配置编码已存在");
                return jsonResult;
            }
        }
        if (Strings.isNullOrEmpty(vo.getConfigDesc())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "配置描述不能为空");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

    private JsonResult checkConfigItem(ConfigItemEntity vo) {
        JsonResult jsonResult = new JsonResult();
        if (vo.getConfigId() == null) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "configId不能为空");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getItemValue())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "itemValue不能为空");
            return jsonResult;
        }
        if (Strings.isNullOrEmpty(vo.getItemName())) {
            jsonResult.setFail(ReturnCode.PARAMS_IS_NOT_VALID, "itemName不能为空");
            return jsonResult;
        }

        ConfigItemCondition condition = new ConfigItemCondition();
        condition.setConfigId(vo.getConfigId());
        condition.setItemValue(vo.getItemValue());
        if (vo.getId() != null) {
            condition.setNid(vo.getId());
        }

        List<ConfigItemEntity> itemEntityList = configItemService.findConfigItemList(condition);
        if (CollectionUtils.isNotEmpty(itemEntityList)) {
            jsonResult.setFail("该配置下已存在此配置项");
            return jsonResult;
        }
        jsonResult.setSuccess();
        return jsonResult;
    }

}

package com.funny.admin.service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

import com.funny.admin.common.dao.admin.ParameterMapper;
import com.funny.admin.common.domain.admin.entity.ParameterEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.funny.admin.common.utils.RedisUtils;
import com.google.common.collect.Maps;

@Service
public class ParameInitServiceImpl  implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(ParameInitServiceImpl.class);
    private static final String PARAM_CACHE_KEY = "SYW_PARAMETER_CACHE_KEY";
    @Resource
    private ParameterMapper parameterMapper;
    @Override
    public void afterPropertiesSet() throws Exception {
//        if (!hasCached()) {
//            List<Parameter> parameterList = parameterMapper.findAll();
//            loadData(parameterList);
//        }


    }

    /**
     * spring 初始化后load数据，程序中<b>不许</b>调用此方法
     */
    public static void loadData(List<ParameterEntity> dict) {
        logger.info("load parameters data into memory.");
        ConcurrentMap<Long, ParameterEntity> dataMap = Maps.newConcurrentMap();
        for (ParameterEntity para : dict) {
            dataMap.put(para.getId(), para);
        }
        RedisUtils.getInstance().OBJECTS.set(PARAM_CACHE_KEY, dataMap);
    }

    /**
     * 根据词典类型和词典id找值
     *
     * @param dicType 参数code
     * @return 参数value
     */
    @SuppressWarnings("unchecked")
    public static ParameterEntity getDictValue(final Long dicType) {
        ConcurrentMap<Long, ParameterEntity> dataMap = (ConcurrentMap<Long, ParameterEntity>) RedisUtils.getInstance().OBJECTS.get(PARAM_CACHE_KEY);
        return dataMap.get(dicType);
    }

    /**
     * 判断是否有缓存
     *
     * @return
     */
    public static boolean hasCached() {
        return RedisUtils.getInstance().OBJECTS.get(PARAM_CACHE_KEY) != null;
    }

}

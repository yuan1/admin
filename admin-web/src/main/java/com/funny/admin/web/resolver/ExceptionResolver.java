package com.funny.admin.web.resolver;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;

/**
 * @author funny
 */
public class ExceptionResolver implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object o, Exception e) {
        logger.error("异常信息：", e);
        Map<String, Object> model = Maps.newHashMap();
        model.put("e", e);
        // 根据不同错误转向不同页面
        if (e instanceof IOException) {
            return new ModelAndView("business_error", model);
        } else if (e instanceof NullPointerException) {
            return new ModelAndView("parameter_error", model);
        }
        return new ModelAndView("/error/exception", model);
    }
}

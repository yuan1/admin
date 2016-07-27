package com.funny.admin.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by funny on 16/7/27.
 */
public class BasePathInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(request.getScheme());
        stringBuffer.append("://");
        stringBuffer.append(request.getServerName());
        stringBuffer.append(":");
        stringBuffer.append(request.getServerPort());
        stringBuffer.append(request.getContextPath());
        stringBuffer.append("/");
        request.setAttribute("basePath", stringBuffer.toString());
        return true;
    }
}

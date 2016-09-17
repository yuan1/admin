package com.funny.admin.web.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.funny.admin.service.sys.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;
    public static final String CURRENT_USER = "user";
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(CURRENT_USER, userService.findByUsername(username));
        return true;
    }
}

package com.funny.admin.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebAppContextListener implements ServletContextListener {
    private static WebApplicationContext was = null;

    public void contextDestroyed(ServletContextEvent event) {
    }

    public void contextInitialized(ServletContextEvent event) {
        was = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    }

}

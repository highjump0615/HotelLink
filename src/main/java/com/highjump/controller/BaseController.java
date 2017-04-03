package com.highjump.controller;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class BaseController implements ServletContextAware {
    // servlet context to store global data
    protected ServletContext context;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
}

package com.highjump.controller;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class BaseController implements ServletContextAware {
    // servlet context to store global data
    ServletContext context;

    // key for nationality suggestion
    protected final String kNationality = "nationality";

    // key for destination suggestion
    protected final String kDestination = "destination";

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
}

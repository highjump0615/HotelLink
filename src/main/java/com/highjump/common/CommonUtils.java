package com.highjump.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (CommonUtils.applicationContext == null) {
            CommonUtils.applicationContext = applicationContext;
        }
    }

    /**
     * get Picture base url from application.properties
     * @return String
     */
    public static String getPicBaseUrl() {
        return applicationContext.getEnvironment().getProperty("webservice.pictureurl");
    }
}

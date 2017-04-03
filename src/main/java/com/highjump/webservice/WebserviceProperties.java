package com.highjump.webservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "webservice")
public class WebserviceProperties {
    // root url of web service
    private String rooturl;

    public String getRootUrl() {
        return rooturl;
    }

    public void setRooturl(String rooturl) {
        this.rooturl = rooturl;
    }
}

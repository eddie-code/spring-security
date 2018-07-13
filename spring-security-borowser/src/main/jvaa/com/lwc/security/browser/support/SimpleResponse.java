package com.lwc.security.browser.support;

import lombok.Data;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.browser.support
 * @ClassName SimpleResponse
 * @description
 * @date created in 2018-07-13 14:26
 * @modified by
 */
//@Data
public class SimpleResponse {

    public SimpleResponse(Object content) {
        System.out.println("SimpleResponse: " + content);
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

package com.lwc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.core.properties
 * @ClassName SecurityProperties
 * @description 读取配置里面的 lwc.security.browser.loginPage = /demo-signIn.html
 * @date created in 2018-07-13 14:37
 * @modified by
 */
@ConfigurationProperties(prefix = "lwc.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

}

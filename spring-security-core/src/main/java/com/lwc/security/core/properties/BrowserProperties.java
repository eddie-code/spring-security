package com.lwc.security.core.properties;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.core.properties
 * @ClassName BrowserProperties
 * @description 系统配置封装
 * @date created in 2018-07-13 14:38
 * @modified by
 */
public class BrowserProperties {

    private String loginPage = "/lwc-signln.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

}
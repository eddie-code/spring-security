package com.lwc.security.core.properties;

import lombok.Data;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.core.properties
 * @ClassName BrowserProperties
 * @description 系统配置封装
 * @date created in 2018-07-13 14:38
 * @modified by
 */
@Data
public class BrowserProperties {

    //登录认证页面
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    /**
     * ----------------------------------------------------------------------------------
     **/

    //登录认证返回 JSON格式
    private LoginResponseType loginType = LoginResponseType.JSON;


    /**
     * ----------------------------------------------------------------------------------
     **/

    // 记住我 保存 一小时
    private int rememberMeSeconds = 3600;

}
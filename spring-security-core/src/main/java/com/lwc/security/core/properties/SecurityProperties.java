package com.lwc.security.core.properties;

import lombok.Data;
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
@Data
@ConfigurationProperties(prefix = "lwc.security")
public class SecurityProperties {

    //登录验证跳转, 记住我功能
    private BrowserProperties browser = new BrowserProperties();

    //图片验证码
    private ValidateCodeProperties code = new ValidateCodeProperties();

}

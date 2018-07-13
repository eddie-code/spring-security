package com.lwc.security.core;

import com.lwc.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.core
 * @ClassName SecurityCoreConfig
 * @description
 * @date created in 2018-07-13 14:40
 * @modified by
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

    /**
     * @ConfigurationProperties注解主要用来把properties配置文件转化为bean来使用的，
     * 而@EnableConfigurationProperties注解的作用是@ConfigurationProperties注解生效。
     * 如果只配置@ConfigurationProperties注解，在IOC容器中是获取不到properties配置文件转化的bean的
     */

}

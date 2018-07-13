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

}

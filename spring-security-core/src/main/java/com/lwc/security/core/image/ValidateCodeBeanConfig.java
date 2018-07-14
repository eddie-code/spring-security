package com.lwc.security.core.image;

import com.lwc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ValidateCodeBeanConfig
 * @description 图片验证 系统启动时候加载
 * @date created in 2018-07-14 0:37
 * @modified by
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator") //  <-- 系统启动时候查找是否有这个Bean,如果有就不会在加载下面的方法；
    public ValidateCodeGenerator imageCodeGenerator() {
        System.out.println("ValidateCodeBeanConfig.imageCodeGenerator 不存在");
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        //验证码需要系统的配置信息
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

}


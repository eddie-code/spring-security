package com.lwc.security.core.validate.code;

import com.lwc.security.core.validate.code.image.ImageCodeGenerator;
import com.lwc.security.core.properties.SecurityProperties;
import com.lwc.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.lwc.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.validate.code.image
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
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}



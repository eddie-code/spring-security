package com.lwc.security.core.sms;

import com.lwc.security.core.ValidateCode;
import com.lwc.security.core.ValidateCodeGenerator;
import com.lwc.security.core.properties.SecurityProperties;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ImageCodeGenerator
 * @description 短信验证码 生成
 * @date created in 2018-07-14 1:11
 * @modified by
 */
@Data
@Component
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        System.out.println("短信验证码 生成: " + code + " 过期时间： " + securityProperties.getCode().getSms().getExpireIn());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }

}
